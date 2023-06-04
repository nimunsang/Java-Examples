package com.example.apidevelop1.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class UserDto {

    private final Long id;

    private final String name;

    private final String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final LocalDate createdDate;

}
