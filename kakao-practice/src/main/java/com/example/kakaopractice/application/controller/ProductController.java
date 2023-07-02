package com.example.kakaopractice.application.controller;


import com.example.kakaopractice.domain.product.dto.ProductWithOptionsDto;
import com.example.kakaopractice.domain.product.dto.ProductDto;
import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.product.service.ProductReadService;
import com.example.kakaopractice.global.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/products")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductReadService productReadService;

    @GetMapping("")
    public ApiResponse getProductPage(@RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 5);
        List<Product> products = productReadService.getProducts(pageRequest);
        List<ProductDto> productDtos = products.stream()
                .map(Product::toDto)
                .collect(Collectors.toList());

        return ApiResponse.OK(productDtos);
    }

    @GetMapping("/{productId}")
    public ApiResponse getOneProduct(@PathVariable Long productId) {
        Product product = productReadService.getOneProduct(productId);
        ProductWithOptionsDto productWithOptionsDto = product.toDtoWithOptions();
        return ApiResponse.OK(productWithOptionsDto);
    }
}
