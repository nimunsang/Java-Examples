package com.example.kakaopractice.domain.user.entity;


import com.example.kakaopractice.domain.cart.entity.Cart;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(force = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "user_tb")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 256)
    private String password;

    @Column(length = 20)
    private String role;

    @CreatedDate
    @Column(name = "join_date")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    // cart <-> user 양방향 매핑. 왜? user -> cart item을 조회해야 할 때가 있다.
    private List<Cart> carts;

    @Builder
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
