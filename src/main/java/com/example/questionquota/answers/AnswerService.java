package com.example.questionquota.answers;

import com.example.questionquota.questions.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer addNewAnswer(Answer answer){
        return answerRepository.save(answer);
    }
}
