package com.example.kakaopractice.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserCreateDto {

    private String username;

    private String email;

    private String password;
}
