package com.example.kakaopractice.domain.product.entity;


import com.example.kakaopractice.domain.option.entity.Option;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(force = true)
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String image;

    private Long price;

    @OneToMany(mappedBy = "product")
    private List<Option> options;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Product(String name, String description, String image, Long price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }
}
