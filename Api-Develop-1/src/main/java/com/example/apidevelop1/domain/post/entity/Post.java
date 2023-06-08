package com.example.apidevelop1.domain.post.entity;


import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import utils.Constants;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Post {

    private final Long id;

    private String title;

    private String content;

    private String category;

    private final Long memberId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final LocalDateTime createdAt;

    @Builder
    public Post(Long id, String title, String content, String category, Long memberId, LocalDateTime createdAt) {
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.content = Objects.requireNonNull(content);
        this.category = Objects.requireNonNull(category);
        this.memberId = Objects.requireNonNull(memberId);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    public void changeTitle(String to) {
        title = to;
    }

    public void changeContent(String to) {
        content = to;
    }

    public void changeCategory(String to) {
        category = to;
    }

    public boolean validateCategory(String category) {
        return Constants.POST_CATEGORIES.contains(category);
    }
}
