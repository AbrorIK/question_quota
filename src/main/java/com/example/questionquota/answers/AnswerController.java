package com.example.questionquota.answers;

import com.example.questionquota.questions.Question;
import com.example.questionquota.questions.QuestionRepository;
import org.aspectj.weaver.patterns.NotTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerController(AnswerService answerService, QuestionRepository questionRepository) {
        this.answerService = answerService;
        this.questionRepository = questionRepository;
    }

    @PostMapping("/questions/{questionId}/answers")
    public ResponseEntity<Answer> createAnswer(@PathVariable(value = "questionId") Long questionId,
                                                @RequestBody Answer answerRequest) {
        Answer answer = questionRepository.findById(questionId).map(question -> {
            answerRequest.setQuestion(question);
            return answerService.addNewAnswer(answerRequest);
        }).orElseThrow(() -> new RuntimeException("Not found Question with id = " + questionId));
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }
}
