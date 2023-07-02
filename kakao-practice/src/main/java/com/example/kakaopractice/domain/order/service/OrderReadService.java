package com.example.kakaopractice.domain.order.service;

import com.example.kakaopractice.domain.order.entity.Order;
import com.example.kakaopractice.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderReadService {

    private final OrderRepository orderRepository;

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

}
