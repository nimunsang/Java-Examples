package com.example.apidevelop1.domain.post.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostUpdateCommand {

    private final Long id;

    private final String title;

    private final String content;

    private final String category;

}