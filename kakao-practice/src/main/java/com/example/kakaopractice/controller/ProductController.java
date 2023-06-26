package com.example.kakaopractice.controller;


import com.example.kakaopractice.ApiResponse;
import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.product.service.ProductReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductReadService productReadService;

    @GetMapping("")
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 5);
        return productReadService.getAllProducts(pageRequest);
    }
}
