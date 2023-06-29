package com.example.kakaopractice.domain.cart.entity;

import com.example.kakaopractice.domain.option.entity.Option;
import com.example.kakaopractice.domain.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Cart {

    @Id @GeneratedValue
    private Long id;

    @OneToMany
    private List<Option> options;

    @OneToOne
    private User user;

    private int quantity;

}
