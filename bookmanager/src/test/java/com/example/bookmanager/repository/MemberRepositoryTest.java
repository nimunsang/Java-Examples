package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crud() {
        memberRepository.findAll().forEach(System.out::println);
    }

}