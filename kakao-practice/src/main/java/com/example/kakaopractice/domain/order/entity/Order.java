package com.example.kakaopractice.domain.order.entity;

import com.example.kakaopractice.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(force=true)
@Entity
@EntityListeners(AuditingEntityListener.class)

@Table(name = "order_tb")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @CreatedDate
    @Column(name = "order_date")
    private LocalDateTime createdAt;

    @Builder
    public Order(User user) {
        this.user = user;
    }
}
