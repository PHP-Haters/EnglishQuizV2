package com.englishquiz.controller;

import com.englishquiz.model.Level;
import com.englishquiz.model.Question;
import com.englishquiz.service.QuestionService;

import java.util.List;


public class QuestionController{

    QuestionService questionService;
    public List<Question> getQuestionsOfLevel(Level level) {
        questionService = new QuestionService();
        return questionService.listarPorNivel(level);
    }
}
