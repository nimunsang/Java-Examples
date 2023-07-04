package com.example.kakaopractice.domain.product.dto;

import com.example.kakaopractice.domain.product.entity.Product;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductWithOptionsDto extends ProductDto {

    private Product product;

    private List<ProductOptionDto> options;

    public ProductWithOptionsDto(Long id, String productName, String description, String image, int price, List<ProductOptionDto> options) {
        super(id, productName, description, image, price);
        this.options = options;
    }

    public ProductWithOptionsDto(Product product, List<ProductOptionDto> options) {

    }

}
