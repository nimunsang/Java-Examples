package com.example.kakaopractice.domain.product.service;

import com.example.kakaopractice.domain.product.entity.ProductOption;
import com.example.kakaopractice.domain.product.repository.ProductOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductOptionReadService {

    private final ProductOptionRepository productOptionRepository;

    public List<ProductOption> getOptionsByProductId(Long productId) {
        return productOptionRepository.findAllByProductId(productId).orElseThrow();
    }

    public ProductOption getOptionById(Long optionId) {
        return productOptionRepository.findById(optionId).orElseThrow();
    }
}
