package com.example.kakaopractice.domain.like.repository;

import com.example.kakaopractice.domain.like.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    public int getLikeByUserId(long id);
}
