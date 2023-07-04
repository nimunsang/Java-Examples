package com.example.kakaopractice.domain.product.entity;

import com.example.kakaopractice.domain.product.dto.ProductOptionDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(force = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "option_tb")
public class ProductOption {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private String name;

    private int price;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public ProductOption(Product product, String name, int price) {
        this.product = product;
        this.name = name;
        this.price = price;
    }

    public ProductOptionDto toDto() {
        return new ProductOptionDto(id, name, price);
    }
}
