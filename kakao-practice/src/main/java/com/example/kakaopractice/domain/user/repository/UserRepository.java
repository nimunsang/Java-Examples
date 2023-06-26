package com.example.kakaopractice.domain.user.repository;

import com.example.kakaopractice.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserById(long id);

}