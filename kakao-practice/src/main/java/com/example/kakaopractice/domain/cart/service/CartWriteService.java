package com.example.kakaopractice.domain.cart.service;

import com.example.kakaopractice.domain.cart.entity.Cart;
import com.example.kakaopractice.domain.cart.repository.CartRepository;
import com.example.kakaopractice.domain.product.entity.ProductOption;
import com.example.kakaopractice.domain.product.service.ProductOptionReadService;
import com.example.kakaopractice.domain.user.entity.User;
import com.example.kakaopractice.domain.user.service.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartWriteService {

    private final CartRepository cartRepository;

    private final ProductOptionReadService productOptionReadService;

    private final UserReadService userReadService;

    public void addCart(Long userId, Long optionId, int quantity) {
        User user = userReadService.findUserById(userId);
        ProductOption productOption = productOptionReadService.getOptionById(optionId);
        Cart cart = Cart.builder()
                .user(user)
                .productOption(productOption)
                .quantity(quantity)
                .build();

        cartRepository.save(cart);
    }

    public void deleteCart(Long userId) {
        cartRepository.deleteCartsByUserId(userId);
    }

}
