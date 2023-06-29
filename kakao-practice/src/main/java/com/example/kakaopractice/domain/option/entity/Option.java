package com.example.kakaopractice.domain.option.entity;

import com.example.kakaopractice.domain.product.entity.Product;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(force = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "options")
public class Option {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Product product;

    private String name;

    private Long price;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Option(Product product, String name, Long price) {
        this.product = product;
        this.name = name;
        this.price = price;
    }
}
