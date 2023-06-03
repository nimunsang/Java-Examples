package com.example.test1.domain.member.dto;

import java.time.LocalDate;

public record MemberRegisterCommand(
        String email,
        String nickname,
        LocalDate birthday
) {
}
