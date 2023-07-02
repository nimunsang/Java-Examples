package com.example.kakaopractice.domain.cart.service;

import com.example.kakaopractice.domain.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartReadService {

    private final CartRepository cartRepository;


}
