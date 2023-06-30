package com.example.kakaopractice;

import com.example.kakaopractice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KakaoPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(KakaoPracticeApplication.class, args);
    }
}
