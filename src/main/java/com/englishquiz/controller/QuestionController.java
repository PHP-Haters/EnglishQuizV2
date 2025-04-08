package com.englishquiz.controller;

import com.englishquiz.model.Level;
import com.englishquiz.model.Question;
import com.englishquiz.service.QuestionService;
import com.englishquiz.view.QuestionText;

import java.util.List;
import java.util.Scanner;

public class QuestionController {
    private QuestionService questionService = new QuestionService();
    private QuestionText questionText = new QuestionText();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarQuestoesDoNivel(Level nivel) {
        List<Question> questoes = questionService.listarPorNivel(nivel);
        questionText.mostrarQuestoesDoNivel(nivel.getNomeLevel(), questoes);

        scanner.nextLine(); // Espera o usuário apertar ENTER
        new LevelController().abrirView(); // Volta pro menu de níveis
    }
}
