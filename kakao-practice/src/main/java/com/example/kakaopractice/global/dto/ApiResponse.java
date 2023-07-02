package com.example.kakaopractice.global.dto;

import lombok.*;

@Setter
public class ApiResponse {

    private boolean success;

    private Object response;

    private ApiError error;
}
