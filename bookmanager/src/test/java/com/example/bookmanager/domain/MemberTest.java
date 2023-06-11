package com.example.bookmanager.domain;

import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    void test() {
        Member member = new Member();
        member.setEmail("martin@fastcampus.com");
        member.setName("martin");

//        User user1 = new User("martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now());

        System.out.println(">>> " + member.toString());
    }

}