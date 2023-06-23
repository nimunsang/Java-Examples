package com.example.warmup;

import com.example.warmup.domain.answer.repository.AnswerRepository;
import com.example.warmup.domain.question.repository.QuestionRepository;
import com.example.warmup.domain.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@Transactional
@SpringBootTest
class WarmUpApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    QuestionService questionService;

    @Test
    void testJpa() {
        for (int i = 0; i < 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용 x";
            questionService.create(subject, content);
        }
    }
}
