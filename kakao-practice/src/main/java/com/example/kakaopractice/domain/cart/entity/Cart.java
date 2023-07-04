package com.example.kakaopractice.domain.cart.entity;

import com.example.kakaopractice.domain.product.entity.ProductOption;
import com.example.kakaopractice.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cart_tb")
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductOption productOption;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private int quantity;

    @Builder
    public Cart(Long id, ProductOption productOption, User user, int quantity) {
        this.id = id;
        this.productOption = productOption;
        this.user = user;
        this.quantity = quantity;
    }
}
