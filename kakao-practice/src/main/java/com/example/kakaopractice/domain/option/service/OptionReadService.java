package com.example.kakaopractice.domain.option.service;

import com.example.kakaopractice.domain.option.entity.Option;
import com.example.kakaopractice.domain.option.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OptionReadService {

    private final OptionRepository optionRepository;

    public List<Option> getOptionsByProductId(Long productId) {
        return optionRepository.findAllByProductId(productId).orElseThrow();
    }

    public Option getOptionById(Long optionId) {
        return optionRepository.findById(optionId).orElseThrow();
    }
}
