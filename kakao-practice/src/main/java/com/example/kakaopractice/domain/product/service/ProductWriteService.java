package com.example.kakaopractice.domain.product.service;


import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductWriteService {

    private final ProductRepository productRepository;

    public void create(String productName, String description, String image, int price) {
        Product product = Product.builder()
                .productName(productName)
                .description(description)
                .image(image)
                .price(price)
                .build();

        productRepository.save(product);
    }

}

