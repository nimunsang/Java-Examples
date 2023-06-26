package com.example.kakaopractice.domain.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {

    private final long id;

    private final String name;

    private final String email;

    private final String password;
}
