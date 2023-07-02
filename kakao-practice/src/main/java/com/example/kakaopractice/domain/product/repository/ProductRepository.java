package com.example.kakaopractice.domain.product.repository;

import com.example.kakaopractice.domain.product.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Optional<List<Product>> findProductsBy(Pageable page);
    public Optional<Product> findById(Long id);
}
