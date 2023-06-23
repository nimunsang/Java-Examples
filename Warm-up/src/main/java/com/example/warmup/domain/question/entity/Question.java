package com.example.warmup.domain.question.entity;

import com.example.warmup.domain.answer.entity.Answer;
import com.example.warmup.domain.user.entity.SiteUser;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> voter;

    @Builder
    public Question(Integer id, String subject, String content, LocalDateTime createDate, LocalDateTime updateDate, List<Answer> answerList, SiteUser author, Set<SiteUser> voter) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.createDate = createDate == null ? LocalDateTime.now() : createDate;
        this.updateDate = updateDate == null ? LocalDateTime.now() : updateDate;
        this.answerList = answerList;
        this.author = author;
        this.voter = voter;
    }
}
