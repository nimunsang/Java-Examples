package com.example.kakaopractice.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductOptionDto {

    private Long id;

    private String optionName;

    private int price;

}
