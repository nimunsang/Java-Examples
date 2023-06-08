package com.example.apidevelop1.domain.post.repository;

import com.example.apidevelop1.domain.post.entity.Post;
import com.example.apidevelop1.domain.post.dto.PostCommand;
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
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PostRepository {

    private static final String TABLE = "Post";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<Post> ROW_MAPPER = (ResultSet resultSet, int rowNum) ->
            Post.builder()
                    .id(resultSet.getLong("id"))
                    .title(resultSet.getString("title"))
                    .content(resultSet.getString("content"))
                    .category(resultSet.getString("category"))
                    .memberId(resultSet.getLong("memberId"))
                    .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
                    .build();

    public Post save(Post post) {
        if (post.getId() == null) {
            return insert(post);
        }
        throw new IllegalArgumentException("이미 존재하는 POST입니다.");
    }

    public Optional<Post> getPostById(Long id) {
        String sql = String.format("SELECT * FROM %s WHERE id = :id", TABLE);
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        List<Post> posts = namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER);
        Optional<Post> post = Optional.ofNullable(DataAccessUtils.singleResult(posts));

        return post;
    }

    private Post insert(Post post) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id");

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("title", post.getTitle())
                .addValue("content", post.getContent())
                .addValue("category", post.getCategory())
                .addValue("memberId", post.getMemberId())
                .addValue("createdAt", post.getCreatedAt());

        Long postId = simpleJdbcInsert.executeAndReturnKey(params).longValue();

        return Post.builder()
                .id(postId)
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .memberId(post.getMemberId())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
