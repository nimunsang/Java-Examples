package com.example.apidevelop1.domain.user.repository;


import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    private final String TABLE = "User";

    private final RowMapper<User> rowMapper = (ResultSet resultSet, int rowNum) -> User
            .builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .email(resultSet.getString("email"))
            .createdDate(resultSet.getObject("createdDate", LocalDate.class))
            .build();

    public User save(User user) {
        if (user.getId() == null) {
            return insert(user);
        }
        throw new IllegalArgumentException("이미 존재하는 id입니다.");
    }

    public Optional<User> findById(Long id) {
        String sql = String.format("SELECT * FROM %s WHERE id = :id", TABLE);
        var params = new MapSqlParameterSource("id", id);
        return getNullableSingleUser(sql, params, rowMapper);
    }

    public Optional<User> findByName(String name) {
        String sql = String.format("SELECT * FROM %s WHERE name = :name", TABLE);
        var params = new MapSqlParameterSource("name", name);
        return getNullableSingleUser(sql, params, rowMapper);
    }

    public Optional<User> findByEmail(String email) {
        String sql = String.format("SELECT * FROM %s WHERE email = :email", TABLE);
        var params = new MapSqlParameterSource("email", email);
        return getNullableSingleUser(sql, params, rowMapper);
    }

    public Optional<List<User>> findByCreatedDate(LocalDate date) {
        String sql = String.format("SELECT * FROM %s WHERE createdDate = :createdDate", TABLE);
        var params = new MapSqlParameterSource("createdDate", date);

        List<User> users = namedParameterJdbcTemplate.query(sql, params, rowMapper);
        return Optional.of(users);
    }

    public User insert(User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id");

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("name", user.getName())
                .addValue("email", user.getEmail())
                .addValue("createdDate", LocalDate.now());

        Long id = simpleJdbcInsert.executeAndReturnKey(mapSqlParameterSource).longValue();

        return User
                .builder()
                .id(id)
                .name(user.getName())
                .email(user.getEmail())
                .createdDate((LocalDate) mapSqlParameterSource.getValue("createdDate"))
                .build();
    }

    public int update(User user) {
        String sql = String.format("UPDATE %s SET name = :name, email = :email, createdDate = :createdDate WHERE id = :id", TABLE);
        var params = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, params);
    }

    public int delete(User user) {
        String sql = String.format("DELETE FROM %s WHERE id = :id", TABLE);
        var params = new MapSqlParameterSource().addValue("id", user.getId());
        return namedParameterJdbcTemplate.update(sql, params);
    }

    public boolean nameNotExistsInDatabase(String name) {
        String sql = String.format("SELECT * FROM %s WHERE name = :name", TABLE);
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("name", name);
        List<User> users = namedParameterJdbcTemplate.query(sql, params, rowMapper);
        return users.isEmpty();
    }

    public boolean emailNotExistsInDatabase(String email) {
        String sql = String.format("SELECT * FROM %s WHERE email = :email", TABLE);
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("email", email);
        List<User> users = namedParameterJdbcTemplate.query(sql, params, rowMapper);
        return users.isEmpty();
    }

    public User getRandomUser() {
        String sql = String.format("SELECT * FROM %s LIMIT 1", TABLE);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        if (users.size() == 0) {
            throw new NoSuchElementException("사용자가 아무도 존재하지 않습니다.");
        }
        return users.get(0);
    }

    private Optional<User> getNullableSingleUser(String sql, MapSqlParameterSource params, RowMapper<User> rowMapper) {
        List<User> users = namedParameterJdbcTemplate.query(sql, params, rowMapper);
        return Optional.ofNullable(DataAccessUtils.singleResult(users));
    }

}
