package com.englishquiz.service;

import com.englishquiz.model.UserAnswer;
import com.englishquiz.dao.UserAnswerDAO;

public class UserAnswerService {
    private UserAnswerDAO userAnswerDAO = new UserAnswerDAO();

    public void enviarResposta(UserAnswer userAnswer){
        userAnswerDAO.save(userAnswer);
    }
}
