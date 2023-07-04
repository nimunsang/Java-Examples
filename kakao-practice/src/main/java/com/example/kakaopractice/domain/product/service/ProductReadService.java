package com.example.kakaopractice.domain.product.service;


import com.example.kakaopractice.domain.product.dto.ProductWithOptionsDto;
import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.product.entity.ProductOption;
import com.example.kakaopractice.domain.product.repository.ProductOptionRepository;
import com.example.kakaopractice.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductReadService {

    private final ProductRepository productRepository;

    private final ProductOptionRepository productOptionRepository;

    public List<Product> getProducts(Pageable pageable) {
        return productRepository.findProductsBy(pageable).orElseThrow();
    }

    public Product getOneProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    public ProductWithOptionsDto getOneProductWithOptions(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        List<ProductOption> productOptions = productOptionRepository.findAllByProductId(productId).orElseThrow();

        return new ProductWithOptionsDto(product, productOptions);
    }
}
