package com.example.questionquota.questions;

import com.example.questionquota.answers.Answer;
import com.example.questionquota.answers.AnswerRepository;
import com.example.questionquota.answers.AnswerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class QuestionConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuestionRepository questionRepository,
                                        AnswerService answerService){
        return args -> {
            Question question1 = new Question(
                    "How to build a website?",
                    "Website"
            );

            Question question2 = new Question(
                    "How to send HTTP Requests?",
                    "HTTP Requests"
            );
            Question question3 = new Question(
                    "How to handle HTTP Responses?",
                    "HTTP Responses"
            );

            Question question4 = new Question(
                    "What is a Database?",
                    "Database"
            );
            questionRepository.saveAll(List.of(question1, question2, question3, question4));

        };
    }
}
