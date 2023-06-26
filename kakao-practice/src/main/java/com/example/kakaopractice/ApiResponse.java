package com.example.kakaopractice;

import lombok.*;

@Setter
public class ApiResponse {

    private boolean success;

    private Object response;

    private ApiError error;
}
