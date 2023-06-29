package com.example.kakaopractice.domain.order.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(force=true)
@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

}
