package com.example.kakaopractice.domain.product.service;


import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductReadService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }
}
