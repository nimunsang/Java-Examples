package com.example.kakaopractice.domain.option.repository;

import com.example.kakaopractice.domain.option.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OptionRepository extends JpaRepository<Option, Long> {
    public Optional<List<Option>> findAllByProductId(Long id);
}
