package com.example.kakaopractice.domain.product.controller;


import com.example.kakaopractice.domain.product.dto.ProductWithOptionsDto;
import com.example.kakaopractice.domain.product.dto.ProductDto;
import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.product.service.ProductReadService;
import com.example.kakaopractice.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/products")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductReadService productReadService;


    @GetMapping("")
    public ResponseEntity<?> getProductPage(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int page_size,
                                            @RequestParam(defaultValue = "asc") String direction,
                                            @RequestParam(defaultValue = "createdAt") String property) {

        PageRequest pageRequest = direction.equals("asc") ?
                PageRequest.of(page, page_size, Sort.Direction.ASC, property) :
                PageRequest.of(page, page_size, Sort.Direction.DESC, property);

        List<Product> products = productReadService.getProducts(pageRequest);
        List<ProductDto> productDtos = products.stream()
                .map(Product::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ApiUtils.success(productDtos));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getOneProduct(@PathVariable Long productId) {
        ProductWithOptionsDto productWithOptionsDto = productReadService.getOneProductWithOptions(productId);
        return ResponseEntity.ok(ApiUtils.success(productWithOptionsDto));
    }
}
