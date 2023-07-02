package com.example.kakaopractice.domain.order.service;

import com.example.kakaopractice.domain.cart.service.CartWriteService;
import com.example.kakaopractice.domain.order.entity.Order;
import com.example.kakaopractice.domain.order.repository.OrderRepository;
import com.example.kakaopractice.domain.user.entity.User;
import com.example.kakaopractice.domain.user.service.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderWriteService {

    private final OrderRepository orderRepository;

    private final UserReadService userReadService;

    private final OrderItemWriteService orderItemWriteService;

    private final CartWriteService cartWriteService;


    @Transactional
    public void doOrder(Long userId) {
        /*
        1. order 추가
        2. order_item에 장바구니 옮기기
        3. 장바구니 비우기
         */

        // 현재 쿼리가 총 8번 나가는 문제..

        User user = userReadService.findUserById(userId); // Q1 (select)
        Order order = new Order(user);
        orderRepository.save(order); // Q2 (insert)
        orderItemWriteService.addOrderItem(order); // order item에 장바구니 옮겼음. 장바구니의 아이템 갯수만큼 쿼리가 나갈 것
        cartWriteService.deleteCart(userId); // 장바구니 비웠음. 장바구니의 아이템 갯수만큼 쿼리가 나갈 것

    }
}
