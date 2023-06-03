package com.example.apidevelop1.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // getter
@RequiredArgsConstructor // 생성자
public class UserRegisterCommand {

    private final String name;

    private final String email;
}
