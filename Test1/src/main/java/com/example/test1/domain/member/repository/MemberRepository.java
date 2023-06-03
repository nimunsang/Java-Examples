package com.example.test1.domain.member.repository;

import com.example.test1.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String TABLE = "member";

    RowMapper<Member> rowMapper = (ResultSet resultSet, int rowNum) -> Member
            .builder()
            .id(resultSet.getLong("id"))
            .email(resultSet.getString("email"))
            .nickname(resultSet.getString("nickname"))
            .birthday(resultSet.getObject("birthday", LocalDate.class))
            .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
            .build();


    public Optional<Member> findById(Long id) {
        String sql = String.format(
                """
                SELECT *
                FROM %s
                WHERE id = :id
                """, TABLE);
        var param = new MapSqlParameterSource()
                .addValue("id", id);

        Member member = namedParameterJdbcTemplate.queryForObject(sql, param, rowMapper);
        return Optional.ofNullable(member);
    }

    public List<Member> findAllByIdIn(List<Long> ids) {
        if (ids.isEmpty()) {
            return List.of();
        }

        String sql = String.format(
                """
                SELECT *
                FROM %s
                WHERE id in (:ids)
                """, TABLE);
        var param = new MapSqlParameterSource()
                .addValue("ids", ids);

        return namedParameterJdbcTemplate.query(sql, param, rowMapper);
    }

    public Member save(Member member) {
        /*
            member id를 보고 갱신 또는 삽입을 정함
            반환값은 id를 담아서 반환
         */
        if (member.getId() == null) {
            return insert(member);
        }
        return update(member);
    }


    private Member insert(Member member) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id");

        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        var id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
        return Member
                .builder()
                .id(id)
                .email(member.getEmail())
                .nickname(member.getNickname())
                .birthday(member.getBirthday())
                .createdAt(member.getCreatedAt())
                .build();
    }

    private Member update(Member member) {
        var sql = String.format(
                """
                UPDATE %s
                SET email = :email, nickname = :nickname, birthday = :birthday
                WHERE id = :id
                """, TABLE);

        var param = new BeanPropertySqlParameterSource(member);
        namedParameterJdbcTemplate.update(sql, param);
        return member;
    }
}