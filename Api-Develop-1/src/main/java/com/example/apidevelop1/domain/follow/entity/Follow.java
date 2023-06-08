package com.example.apidevelop1.domain.follow.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class Follow {

    private final Long id;

    private final long fromId;

    private final long toId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final LocalDateTime createdAt;

    @Builder
    public Follow(Long id, long fromId, long toId, LocalDateTime createdAt) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
}
