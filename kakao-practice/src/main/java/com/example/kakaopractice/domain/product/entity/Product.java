package com.example.kakaopractice.domain.product.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    private final String productName;

    private final String description;

    private final String image;

    private final int price;
}
