package com.englishquiz.service;

import com.englishquiz.model.Answer;
import com.englishquiz.model.User;
import com.englishquiz.model.UserAnswer;

import java.util.List;

import com.englishquiz.dao.UserAnswerDAO;

public class UserAnswerService {
    private UserAnswerDAO userAnswerDAO = new UserAnswerDAO();

    public void enviarResposta(UserAnswer userAnswer){
        userAnswerDAO.save(userAnswer);
    }
    public List<UserAnswer> encontrarPorUsuario(User user) {
        return userAnswerDAO.findByUser(user);
    }
    public List<UserAnswer> encontrarPorRespostaEUsuario(Answer answer, User user) {
        return userAnswerDAO.findByAnswer(answer, user);
    }
}
