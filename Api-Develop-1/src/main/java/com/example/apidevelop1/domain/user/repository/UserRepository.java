package com.example.apidevelop1.domain.user.repository;


import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String TABLE = "User";

    public User save(User user) {
        if (user.getId() == null) {
            return insert(user);
        }
        return insert(user);
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
}
