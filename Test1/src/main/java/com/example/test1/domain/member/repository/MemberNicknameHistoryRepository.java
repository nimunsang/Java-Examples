package com.example.test1.domain.member.repository;


import com.example.test1.domain.member.entity.MemberNicknameHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberNicknameHistoryRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String TABLE = "MemberNicknameHistory";

    RowMapper<MemberNicknameHistory> rowMapper = (ResultSet resultset, int rowNum) ->
            MemberNicknameHistory
                    .builder()
                    .id(resultset.getLong("id"))
                    .memberId(resultset.getLong("memberId"))
                    .nickname(resultset.getString("nickname"))
                    .createdAt(resultset.getObject("createdAt", LocalDateTime.class))
                    .build();

    public MemberNicknameHistory save(MemberNicknameHistory history) {
        if (history.getId() == null) {
            return insert(history);
        }
        throw new UnsupportedOperationException("MemberNicknameHistory는 갱신을 지원하지 않습니다.");
    }

    private MemberNicknameHistory insert(MemberNicknameHistory history) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id");

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(history);
        var id = simpleJdbcInsert.executeAndReturnKey(sqlParameterSource).longValue();

        return MemberNicknameHistory
                .builder()
                .id(id)
                .memberId(history.getMemberId())
                .nickname(history.getNickname())
                .createdAt(history.getCreatedAt())
                .build();
    }

    public List<MemberNicknameHistory> getMemberNicknameHistory(Long memberId) {
        String sql = String.format(
                """
                SELECT *
                FROM %s
                WHERE memberId = :memberId
                """, TABLE);

        var param = new MapSqlParameterSource().addValue("memberId", memberId);

        return namedParameterJdbcTemplate.query(sql, param, rowMapper);
    }
}
