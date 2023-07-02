package com.example.kakaopractice.domain.option.service;

import com.example.kakaopractice.domain.option.entity.Option;
import com.example.kakaopractice.domain.option.repository.OptionRepository;
import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.product.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Service
@RequiredArgsConstructor
public class OptionWriteService {

    private final OptionRepository optionRepository;

    private final ProductRepository productRepository;

    public void create(String name, int price, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();

        Option option = Option.builder()
                .name(name)
                .price(price)
                .product(product)
                .build();

        optionRepository.save(option);
    }

    public void modifyPrice(Long optionId, int price) {
        Option option = optionRepository.findById(optionId).orElseThrow();
        option.setPrice(price);
        optionRepository.save(option);
    }
}
