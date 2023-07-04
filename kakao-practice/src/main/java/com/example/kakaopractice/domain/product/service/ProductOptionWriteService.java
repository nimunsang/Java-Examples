package com.example.kakaopractice.domain.product.service;

import com.example.kakaopractice.domain.product.repository.ProductOptionRepository;
import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.product.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class ProductOptionWriteService {

    private final ProductOptionRepository productOptionRepository;

    private final ProductRepository productRepository;

    public void create(String name, int price, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();

        Option option = Option.builder()
                .name(name)
                .price(price)
                .product(product)
                .build();

        productOptionRepository.save(option);
    }

    public void modifyPrice(Long optionId, int price) {
        Option option = productOptionRepository.findById(optionId).orElseThrow();
        option.setPrice(price);
        productOptionRepository.save(option);
    }
}
