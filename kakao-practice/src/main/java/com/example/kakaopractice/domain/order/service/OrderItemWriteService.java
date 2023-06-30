package com.example.kakaopractice.domain.order.service;

import com.example.kakaopractice.domain.cart.entity.Cart;
import com.example.kakaopractice.domain.option.entity.Option;
import com.example.kakaopractice.domain.option.service.OptionReadService;
import com.example.kakaopractice.domain.order.entity.Order;
import com.example.kakaopractice.domain.order.entity.OrderItem;
import com.example.kakaopractice.domain.order.repository.OrderItemRepository;
import com.example.kakaopractice.domain.order.repository.OrderRepository;
import com.example.kakaopractice.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemWriteService {

    private final OrderItemRepository orderItemRepository;

    private final OrderReadService orderReadService;

    private final OptionReadService optionReadService;

    public void addOrderItem(Order order) {
        User user = order.getUser();
        List<Cart> carts = user.getCarts();

        for (Cart cart: carts) {
            Option option = cart.getOption();
            int quantity = cart.getQuantity();
            int order_price = option.getPrice(); // 현재는 세일가가 없으므로, 그냥 가져오면 된다.

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .option(option)
                    .quantity(quantity)
                    .price(order_price)
                    .build();

            orderItemRepository.save(orderItem);
        }

    }
}
