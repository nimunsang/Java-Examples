package com.example.kakaopractice.domain.order.service;

import com.example.kakaopractice.domain.product.service.ProductOptionReadService;
import com.example.kakaopractice.domain.order.entity.Order;
import com.example.kakaopractice.domain.order.repository.OrderItemRepository;
import com.example.kakaopractice.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemWriteService {

    private final OrderItemRepository orderItemRepository;

    private final OrderReadService orderReadService;

    private final ProductOptionReadService productOptionReadService;

    public void addOrderItem(Order order) {
        User user = order.getUser();
    }
}
