package com.example.kakaopractice.domain.product.entity;


import com.example.kakaopractice.domain.product.dto.ProductWithOptionsDto;
import com.example.kakaopractice.domain.product.dto.ProductDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(force = true)
@Table(name = "product_tb")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String productName;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(length = 500)
    private String image;

    private int price;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Product(Long id, String productName, String description, String image, int price) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public ProductDto toDto() {
        return new ProductDto(id, productName, description, image, price);
    }
}
