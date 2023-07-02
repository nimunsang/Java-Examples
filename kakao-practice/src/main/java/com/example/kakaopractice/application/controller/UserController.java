package com.example.kakaopractice.application.controller;

import com.example.kakaopractice.domain.user.dto.UserCreateDto;
import com.example.kakaopractice.domain.user.service.UserReadService;
import com.example.kakaopractice.domain.user.service.UserWriteService;
import com.example.kakaopractice.global.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserReadService userReadService;

    private final UserWriteService userWriteService;

    @PostMapping("/join")
    public ApiResponse createUser(@RequestBody UserCreateDto userCreateDto) {
        String email = userCreateDto.getEmail();
        boolean isUserAlreadyExists = userReadService.checkUserAlreadyExists(email);
        if (isUserAlreadyExists) {
            int errorCode = 400;
            String errorMessage = "동일한 이메일이 존재합니다 : " + email;
            return ApiResponse.ERROR(errorMessage, errorCode);
        }

        userWriteService.createUser(userCreateDto);
        return ApiResponse.OK();
    }

    @PostMapping("/check")
    public ApiResponse checkDuplicateEmail(@RequestBody HashMap<String, String> param) {
        String email = param.get("email");
        System.out.println(email);
        boolean isUserAlreadyExists = userReadService.checkUserAlreadyExists(email);
        if (isUserAlreadyExists) {
            int errorCode = 400;
            String errorMessage = "동일한 이메일이 존재합니다 : " + email;
            return ApiResponse.ERROR(errorMessage, errorCode);
        }

        return ApiResponse.OK();
    }
}
