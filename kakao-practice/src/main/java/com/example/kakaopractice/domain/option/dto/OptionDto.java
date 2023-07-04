package com.example.kakaopractice.domain.option.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OptionDto {

    private Long id;

    private String optionName;

    private int price;

}
