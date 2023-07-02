package com.example.kakaopractice.application.controller;


import com.example.kakaopractice.domain.cart.service.CartReadService;
import com.example.kakaopractice.domain.cart.service.CartWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CartController { // jwt 필요!?

    private final CartReadService cartReadService;

//    @GetMapping("/carts")
//    public void getCart()
}
