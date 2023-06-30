package com.example.kakaopractice.domain.cart.service;

import com.example.kakaopractice.domain.cart.entity.Cart;
import com.example.kakaopractice.domain.cart.repository.CartRepository;
import com.example.kakaopractice.domain.option.entity.Option;
import com.example.kakaopractice.domain.option.repository.OptionRepository;
import com.example.kakaopractice.domain.option.service.OptionReadService;
import com.example.kakaopractice.domain.user.entity.User;
import com.example.kakaopractice.domain.user.service.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartWriteService {

    private final CartRepository cartRepository;

    private final OptionReadService optionReadService;

    private final UserReadService userReadService;

    public void addCart(Long userId, Long optionId, int quantity) {
        User user = userReadService.findUserById(userId);
        Option option = optionReadService.getOptionById(optionId);
        Cart cart = Cart.builder()
                .user(user)
                .option(option)
                .quantity(quantity)
                .build();

        cartRepository.save(cart);
    }

    public void deleteCart(Long userId) {
        cartRepository.deleteCartsByUserId(userId);
    }

}
