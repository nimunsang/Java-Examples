package com.example.kakaopractice.domain.product.repository;

import com.example.kakaopractice.domain.product.entity.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
    public Optional<List<ProductOption>> findAllByProductId(Long id);
    public Optional<ProductOption> findById(Long id);
}
