package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class UsersTest {
    @Test
    void test() {
        Users user = new Users();
        user.setEmail("martin@fastcampus.com");
        user.setName("martin");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        Users user1 = new Users(null, "martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now());
        Users user2 = new Users("martin", "martin@fastcampus.com");
        Users user3 = Users.builder()
                    .name("martin")
                    .email("martin@fastcampus.com")
                    .build();


        System.out.println(">>> " + user);
    }

}