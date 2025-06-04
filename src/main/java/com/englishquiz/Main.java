package com.englishquiz;

import com.englishquiz.controller.UserController;
import com.englishquiz.service.AnswerService;
import com.englishquiz.service.LevelService;
import com.englishquiz.service.QuestionService;
import com.englishquiz.service.UserService;
import com.englishquiz.view.LoginView;

public class Main {
    static LoginView loginView;

    public static void main(String[] args) {
        loginView = new LoginView();
        loginView.setVisible(true);

        UserService userService = new UserService();
        userService.criarUserPadrao();
        
        LevelService levelService = new LevelService();
        levelService.inicializarNiveisPadrao();

        QuestionService questionService = new QuestionService();
        questionService.criarQuestoesPadrao();

        AnswerService answerService = new AnswerService();
        answerService.criarRespostasPadrao();

        UserController userController = new UserController();
        userController.abrirView();
    }
}