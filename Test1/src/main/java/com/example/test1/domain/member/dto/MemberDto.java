package com.example.test1.domain.member.dto;

import java.time.LocalDate;

public record MemberDto(
        Long id,
        String email,
        String nickname,
        LocalDate birthday
) {
}