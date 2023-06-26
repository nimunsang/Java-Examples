package com.example.kakaopractice.domain.like.domain;


import com.example.kakaopractice.domain.product.entity.Product;
import com.example.kakaopractice.domain.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @ManyToMany
    private final User userId;

    @ManyToOne
    private final Product productId;

    private final LocalDateTime createdAt;

}
