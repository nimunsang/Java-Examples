package com.example.apidevelop1.domain.post.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class PostCommand {

    private final String title;

    private final String content;

    private final String category;

    private final Long memberId;
}
