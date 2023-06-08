package com.example.apidevelop1.domain.follow.repository;

import com.example.apidevelop1.domain.follow.entity.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class FollowRepository {

    private final String TABLE = "Follow";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<Follow> rowMapper = (ResultSet resultSet, int rowNum) ->
            Follow.builder()
                    .id(resultSet.getLong("id"))
                    .fromId(resultSet.getLong("fromId"))
                    .toId(resultSet.getLong("toId"))
                    .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
                    .build();

    public Follow save(Follow follow) {
        if (follow.getId() != null) {
            throw new IllegalArgumentException("이미 존재하는 팔로우입니다.");
        }
        return create(follow);
    }

    public Follow create(Follow follow) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id");

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("fromId", follow.getFromId())
                .addValue("toId", follow.getToId())
                .addValue("createdAt", LocalDateTime.now());

        long id = simpleJdbcInsert.executeAndReturnKey(params).longValue();

        return Follow.builder()
                .id(id)
                .fromId(follow.getFromId())
                .toId(follow.getToId())
                .createdAt((LocalDateTime) params.getValue("createdAt"))
                .build();
    }

    public boolean alreadyExists(Follow follow) {
        String sql = String.format("SELECT * FROM %s WHERE fromId = :fromId AND toId = :toId", TABLE);
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("fromId", follow.getFromId())
                .addValue("toId", follow.getToId());
        List<Follow> follows = namedParameterJdbcTemplate.query(sql, params, rowMapper);
        return DataAccessUtils.singleResult(follows) != null;
    }
}
