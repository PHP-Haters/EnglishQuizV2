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
import com.englishquiz.model.UserAnswer;
import com.englishquiz.server.Session;
import com.englishquiz.model.Answer;
import com.englishquiz.service.AnswerService;
import com.englishquiz.service.UserAnswerService;

public class AnswerController{
    
    AnswerService answerService;
    UserAnswerService userAnswerService;

    public AnswerController() {
        answerService = new AnswerService();
        userAnswerService = new UserAnswerService();
    }
    public List<Answer> getAnswersOfQuestion(Question question) {
        
        return answerService.listarPorPergunta(question);
    }

    public void setUserAnswer(Answer answer) {
        
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAnswer(answer);
        userAnswer.setUser(Session.getInstance().getLoggedUser());

        userAnswerService.enviarResposta(userAnswer);
    }

    public boolean findIfAnswerWasAnswered(Answer answer) {

        List<UserAnswer> lista = userAnswerService.encontrarPorRespostaEUsuario(answer, Session.getInstance().getLoggedUser());

        if(lista.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
}
