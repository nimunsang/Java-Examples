package com.example.kakaopractice.domain.user.repository;

import com.example.kakaopractice.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserById(long id);
    public Optional<User> findUserByEmail(String email);

}