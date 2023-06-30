package com.example.kakaopractice.domain.cart.repository;

import com.example.kakaopractice.domain.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    public void deleteCartsByUserId(Long id);
}
