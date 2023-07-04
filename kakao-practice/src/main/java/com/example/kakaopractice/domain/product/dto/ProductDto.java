package com.example.kakaopractice.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String productName;

    private String description;

    private String image;

    private int price;

}
