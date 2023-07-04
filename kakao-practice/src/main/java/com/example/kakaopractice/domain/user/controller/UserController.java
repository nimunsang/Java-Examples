package com.example.kakaopractice.domain.user.controller;

import com.example.kakaopractice.domain.user.dto.UserCreateDto;
import com.example.kakaopractice.domain.user.service.UserReadService;
import com.example.kakaopractice.domain.user.service.UserWriteService;
import com.example.kakaopractice.global.dto.ApiResponse;
import com.example.kakaopractice.utils.ApiUtils;
import com.example.kakaopractice.utils.ErrorCode;
import com.example.kakaopractice.utils.Validator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public ResponseEntity<?> createUser(@RequestBody UserCreateDto userCreateDto) {
        /*
        Json을 받아오는 방법
        1. String으로 받아온 후, ObjectMapper를 통하여 DTO로 변경한다.
            - 사용하려면, JsonProcessingException을 Throw한다는 것을 명시적으로 선언해주어야 한다.
            //        ObjectMapper mapper = new ObjectMapper();
            //        UserCreateDto userCreateDto = mapper.readValue(json, UserCreateDto.class);
            //        String email = userCreateDto.getEmail();
        2. HashMap으로 받아온 후, 매칭한다.
        아래의 방법은 ObjectMapper를 사용한 방법이다.
         */

        /**
         * 1. Email 검증 로직 구현
         * 2. Email 중복 로직 구현
         */

        userWriteService.createUser(userCreateDto);
        return ResponseEntity.ok(ApiUtils.success(null));
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkDuplicateEmail(@RequestBody String email) {

        // TODO : 이메일 중복 체크 로직 구현 (이것을 Exception으로 뺄것인가..)
        return ResponseEntity.ok(ApiUtils.success(null));
    }
}
