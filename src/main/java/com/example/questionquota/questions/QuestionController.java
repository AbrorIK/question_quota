package com.example.questionquota.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/question")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @PostMapping
    public void addNewQuestion(@RequestBody Question question){
        questionService.addNewQuestion(question);
    }

}
