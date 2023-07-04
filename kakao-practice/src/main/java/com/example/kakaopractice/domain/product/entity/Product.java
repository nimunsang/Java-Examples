package com.example.kakaopractice.domain.product.entity;


import com.example.kakaopractice.domain.option.entity.Option;
import com.example.kakaopractice.domain.product.dto.ProductWithOptionsDto;
import com.example.kakaopractice.domain.product.dto.ProductDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(force = true)
@Table(name = "product_tb")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String image;

    private int price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Option> options;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Product(String name, String description, String image, int price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public ProductWithOptionsDto toDtoWithOptions() {
        return new ProductWithOptionsDto(id, name, description, image, price,
                options.stream().map(Option::toDto).collect(Collectors.toList()));
    }

    public ProductDto toDto() {
        return new ProductDto(id, name, description, image, price);
    }
}
