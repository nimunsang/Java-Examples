package com.example.kakaopractice.utils;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    EMAIL_ALREADY_EXISTS("동일한 이메일이 존재합니다:%s" , HttpStatus.BAD_REQUEST.value()),
    EMAIL_FORMAT_ERROR("이메일 형식으로 작성해주세요:%s", HttpStatus.BAD_REQUEST.value());


    private final String message;

    private final int status;

    ErrorCode(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage(String args) {
        return String.format(message, args);
    }

    public int getStatus() {
        return status;
    }
}
