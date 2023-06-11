package com.example.apidevelop1.domain.post.entity;


import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;
import utils.Constants;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Post {

    private final Long id;

    private String title;

    private String content;

    private String category;

    private final Long userId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final LocalDateTime createdAt;

    @Builder
    public Post(Long id, String title, String content, String category, Long userId, LocalDateTime createdAt) {
        this.id = id;

        validateTitle(title);
        this.title = Objects.requireNonNull(title);

        validateContent(content);
        this.content = Objects.requireNonNull(content);

        validateCategory(category);
        this.category = Objects.requireNonNull(category);

        this.userId = Objects.requireNonNull(userId);

        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    public void validateTitle(String title) {
        Assert.isTrue(title.length() <= Constants.POST_TITLE_LENGTH_MAX,
                String.format("작성 가능한 제목의 최대 길이는 %d입니다.", Constants.POST_TITLE_LENGTH_MAX));
    }

    public void validateContent(String content) {
        Assert.isTrue(content.length() <= Constants.POST_CONTENT_LENGTH_MAX,
                String.format("작성 가능한 게시글의 최대 길이는 %d입니다.", Constants.POST_CONTENT_LENGTH_MAX));
    }

    public void validateCategory(String category) {
        Assert.isTrue(Constants.POST_CATEGORIES.contains(category),
                "존재하지 않는 카테고리입니다.");
    }
}
