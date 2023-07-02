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

    public List<Product> getProducts(Pageable pageable) {
        List<Product> products = productRepository.findProductsBy(pageable).orElseThrow();
        return products;
    }

    public Product getOneProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }
}
