package com.example.kakaopractice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class ApiResult<T> {
    private final boolean success;

    private final T response;

    private final ApiError error;
}
