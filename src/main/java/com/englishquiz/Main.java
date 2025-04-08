package com.englishquiz;

import com.englishquiz.controller.MainController;
import com.englishquiz.controller.UserController;
import com.englishquiz.server.Session;
import com.englishquiz.service.LevelService;
import com.englishquiz.service.QuestionService;

public class Main {
    public static void main(String[] args) {
        
        LevelService levelService = new LevelService();
        levelService.inicializarNiveisPadrao();

        QuestionService questionService = new QuestionService();
        questionService.criarQuestoesPadrao();

        UserController userController = new UserController();
        userController.abrirView();

        if(Session.getInstance().getLoggedUser() != null) {
            MainController mainController = new MainController();
            mainController.abrirView();
        }
    }
}