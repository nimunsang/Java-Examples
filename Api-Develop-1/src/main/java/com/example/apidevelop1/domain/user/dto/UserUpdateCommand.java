package com.example.apidevelop1.domain.user.dto;

import lombok.Getter;

import java.util.Objects;


@Getter
public class UserUpdateCommand {

    private final Long id;

    private final String name;

    private final String email;

    public UserUpdateCommand(Long id, String name, String email) {
        this.id = Objects.requireNonNull(id);
        this.name = name;
        this.email = email;
    }
}
