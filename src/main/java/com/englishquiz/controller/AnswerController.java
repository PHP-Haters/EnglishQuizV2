package com.englishquiz.controller;
// import java.util.List;
// import com.englishquiz.service.AnswerService;
// import com.englishquiz.service.UserAnswerService;
// import com.englishquiz.view.AnswerText;
// import com.englishquiz.model.Question;
// import com.englishquiz.model.User;
// import com.englishquiz.model.UserAnswer;
// import com.englishquiz.server.Session;
// import com.englishquiz.model.Answer;

import java.util.List;

import com.englishquiz.model.Question;
import com.englishquiz.model.Answer;
import com.englishquiz.service.AnswerService;

public class AnswerController{
    
    AnswerService answerService;

    public List<Answer> getAnswersOfQuestion(Question question) {
        answerService = new AnswerService();
        return answerService.listarPorPergunta(question);
    }
}
