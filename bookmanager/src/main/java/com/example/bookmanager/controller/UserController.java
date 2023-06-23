package com.example.bookmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }
}
