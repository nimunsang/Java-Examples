package com.example.apidevelop1.domain.post.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class PostCreateCommand {

    private final String title;

    private final String content;

    private final String category;

    private final Long userId;

}
