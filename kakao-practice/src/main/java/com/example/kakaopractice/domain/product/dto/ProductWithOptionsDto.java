package com.example.kakaopractice.domain.product.dto;

import com.example.kakaopractice.domain.option.dto.OptionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
public class ProductWithOptionsDto extends ProductDto {

    private List<OptionDto> options;

    public ProductWithOptionsDto(Long id, String productName, String description, String image, int price, List<OptionDto> options) {
        super(id, productName, description, image, price);
        this.options = options;
    }
}
