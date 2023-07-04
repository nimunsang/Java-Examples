package com.example.kakaopractice.application.controller;

import com.example.kakaopractice.domain.user.dto.UserCreateDto;
import com.example.kakaopractice.domain.user.service.UserReadService;
import com.example.kakaopractice.domain.user.service.UserWriteService;
import com.example.kakaopractice.global.dto.ApiResponse;
import com.example.kakaopractice.utils.ErrorCode;
import com.example.kakaopractice.utils.Validator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class UserController {

    private final UserReadService userReadService;

    private final UserWriteService userWriteService;

    @PostMapping("/join")
    public ApiResponse createUser(@RequestBody String json) throws JsonProcessingException {
        /*
        Json을 받아오는 방법
        1. String으로 받아온 후, ObjectMapper를 통하여 DTO로 변경한다.
            - 사용하려면, JsonProcessingException을 Throw한다는 것을 명시적으로 선언해주어야 한다.
        2. HashMap으로 받아온 후, 매칭한다.
        아래의 방법은 ObjectMapper를 사용한 방법이다.
         */

        ObjectMapper mapper = new ObjectMapper();
        UserCreateDto userCreateDto = mapper.readValue(json, UserCreateDto.class);
        String email = userCreateDto.getEmail();

        if (Validator.isInValidEmail(email)) {
            ErrorCode errorCode = ErrorCode.EMAIL_FORMAT_ERROR;
            String message = errorCode.getMessage(email);
            int status = errorCode.getStatus();
            return ApiResponse.ERROR(message, status);
        }

        boolean UserAlreadyExists = userReadService.checkUserAlreadyExists(email);
        if (UserAlreadyExists) {
            ErrorCode errorCode = ErrorCode.EMAIL_ALREADY_EXISTS;
            String message = errorCode.getMessage(email);
            int status = errorCode.getStatus();
            return ApiResponse.ERROR(message, status);
        }

        userWriteService.createUser(userCreateDto);
        return ApiResponse.OK();
    }

    @PostMapping("/check")
    public ApiResponse checkDuplicateEmail(@RequestBody HashMap<String, String> param) {
        String email = param.get("email");
        if (Validator.isInValidEmail(email)) {
            ErrorCode errorCode = ErrorCode.EMAIL_FORMAT_ERROR;
            String message = errorCode.getMessage(email);
            int status = errorCode.getStatus();
            return ApiResponse.ERROR(message, status);
        }

        boolean UserAlreadyExists = userReadService.checkUserAlreadyExists(email);
        if (UserAlreadyExists) {
            ErrorCode errorCode = ErrorCode.EMAIL_ALREADY_EXISTS;
            String message = errorCode.getMessage(email);
            int status = errorCode.getStatus();
            return ApiResponse.ERROR(message, status);
        }

        return ApiResponse.OK();
    }
}
