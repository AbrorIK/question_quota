package com.example.questionquota.questions;

import com.example.questionquota.answers.Answer;
import com.example.questionquota.answers.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class QuestionController {
    private final QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @PostMapping("/questions")
    public void addNewQuestion(@RequestBody Question question){
        questionService.addNewQuestion(question);
    }

}
