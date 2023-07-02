package com.example.kakaopractice.global.dto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class ApiError {

    private String errorMessage;

    private int errorCode;

}
