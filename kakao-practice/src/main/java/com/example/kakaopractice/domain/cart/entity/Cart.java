package com.example.kakaopractice.domain.cart.entity;

import com.example.kakaopractice.domain.option.entity.Option;
import com.example.kakaopractice.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

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
    private Option option;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private int quantity;

    @Builder
    public Cart(Option option, User user, int quantity) {
        this.option = option;
        this.user = user;
        this.quantity = quantity;
    }
}
