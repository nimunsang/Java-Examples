package com.example.apidevelop1.domain.user.entity;

import com.example.apidevelop1.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;
import utils.Constants;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;


@Getter
public class User {

    private final Long id;

    private String name;

    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final LocalDate createdDate;

    @Builder
    public User(Long id, String name, String email, LocalDate createdDate) {
        this.id = id;

        validateName(name);
        this.name = Objects.requireNonNull(name);

        validateEmail(email);
        this.email = Objects.requireNonNull(email);

        this.createdDate = createdDate == null ? LocalDate.now() : createdDate;
    }

    public UserDto toDto() {
        return new UserDto(id, name, email, createdDate);
    }

    public void validateName(String name) {
        Assert.isTrue(
                Constants.NAME_LENGTH_MIN <= name.length() && name.length() <= Constants.NAME_LENGTH_MAX,
                Constants.NAME_LENGTH_ERROR_MESSAGE);
        Assert.isTrue(
                Pattern.matches(Constants.NAME_PATTERN, name),
                Constants.NAME_PATTERN_ERROR_MESSAGE);
    }

    public void validateEmail(String email) {
        Assert.isTrue(
                Pattern.matches(Constants.EMAIL_PATTERN, email),
                Constants.EMAIL_PATTERN_ERROR_MESSAGE);
    }

    public void changeName(String to) {
        Objects.requireNonNull(to);
        validateName(to);
        this.name = to;
    }

    public void changeEmail(String to) {
        Objects.requireNonNull(to);
        validateEmail(to);
        this.email = to;
    }
}
