package com.example.kakaopractice.domain.order.repository;

import com.example.kakaopractice.domain.order.entity.Order;
import com.example.kakaopractice.domain.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public Optional<Order> findById(Long id);
}
