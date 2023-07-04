package com.example.kakaopractice.domain.user.entity;


import com.example.kakaopractice.domain.cart.entity.Cart;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "user_tb")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String username;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 256, nullable = false)
    private String password;

    // 테이블 생성 시, default값 설정
    @Column(length = 30)
    @ColumnDefault("customer")
    private String roles;

    // 객체 생성 시, default값 설정 방법
//    @Builder.Default()
//    private String role = "customer";

    @CreatedDate
    @Column(name = "join_date")
    private LocalDateTime createdAt;

    @Builder
    public User(Long id, String username, String email, String password, String roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
