package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    void crud() {
        Users user = new Users();
        user.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching()
                        .withMatcher("email", contains());
        Example<Users> example = Example.of(user, matcher);

        usersRepository.findAll(example).forEach(System.out::println);
    }
}