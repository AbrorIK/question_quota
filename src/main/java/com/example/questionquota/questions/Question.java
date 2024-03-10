package com.example.questionquota.questions;

import com.example.questionquota.answers.Answer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Question {
    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    private Long id;
    private String text;
    private LocalDate date;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Question(Long id, String text, LocalDate date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    public Question(String text, LocalDate date) {
        this.text = text;
        this.date = date;
    }

    public Question() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
