package com.example.warmup;

import com.example.warmup.domain.answer.repository.AnswerRepository;
import com.example.warmup.domain.question.repository.QuestionRepository;
import com.example.warmup.domain.question.service.QuestionService;
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
}
