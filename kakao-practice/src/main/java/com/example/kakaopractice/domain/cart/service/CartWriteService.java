package com.example.kakaopractice.domain.cart.service;

import com.example.kakaopractice.domain.cart.repository.CartRepository;
import com.example.kakaopractice.domain.option.entity.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartWriteService {

    private final CartRepository cartRepository;

    public void addOption(Long optionId, int quantity) {
        Option option =  Option.builder()
                .name("상품1옵션1")
                .price(1000L)
                .build();
    }

}
