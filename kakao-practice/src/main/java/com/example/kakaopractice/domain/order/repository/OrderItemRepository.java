package com.example.kakaopractice.domain.order.repository;

import com.example.kakaopractice.domain.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
