package com.example.kakaopractice.domain.order.entity;


import com.example.kakaopractice.domain.product.entity.ProductOption;
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
    private ProductOption productOption;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Builder
    public OrderItem(Long id, Order order, ProductOption productOption, int quantity, int price) {
        this.id = id;
        this.order = order;
        this.productOption = productOption;
        this.quantity = quantity;
        this.price = price;
    }
}
