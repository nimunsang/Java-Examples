package com.example.kakaopractice.domain.order.entity;


import com.example.kakaopractice.domain.option.entity.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "order_item_tb")
@NoArgsConstructor
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Builder
    public OrderItem(Order order, Option option, int quantity, int price) {
        this.order = order;
        this.option = option;
        this.quantity = quantity;
        this.price = price;
    }
}
