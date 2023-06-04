package com.example.apidevelop1.domain.user.entity;

import com.example.apidevelop1.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;


@Getter
public class User {

    private final Long id;

    private final String name;

    private final String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final LocalDate createdDate;

    private final int LENGTH_MIN = 4;
    private final int LENGTH_MAX = 20;

    private final String namePattern = "[a-zA-Z0-9]+";
    private final String emailPattern = "[a-zA-Z0-9]+@[a-zA-Z0-9]+.com";


    @Builder
    public User(Long id, String name, String email, LocalDate createdDate) {
        this.id = id;

        this.name = Objects.requireNonNull(name);
        validateName(name);

        this.email = Objects.requireNonNull(email);
        validateEmail(email);

        this.createdDate = createdDate;
    }

    public UserDto toDto() {
        return new UserDto(id, name, email, createdDate);
    }

    public void validateName(String name) {
        Assert.isTrue(
                LENGTH_MIN <= name.length() && name.length() <= LENGTH_MAX,
                String.format("이름 사용 불가: 이름의 길이는 %d 이상 %d 이하여야 합니다", LENGTH_MIN, LENGTH_MAX));

        Assert.isTrue(
                name.matches(namePattern),
                "이름 사용 불가: 이름은 반드시 영어 소문자, 영어 대문자, 숫자만 포함해야 합니다.");

        //TODO: 이름이 데이터베이스에 존재하는가 체크
    }

    public void validateEmail(String email) {
        Assert.isTrue(
                email.matches(emailPattern),
                "이메일 사용 불가: 이메일 형식이 올바르지 않습니다.");

        //TODO: 이메일이 데이터베이스에 존재하는가 체크
    }
}
