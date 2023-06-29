package com.example.kakaopractice.domain.order.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderItem {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "option_id")
    private Long optionId;

    private int quantity;
}
