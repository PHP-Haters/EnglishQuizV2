package com.englishquiz.controller;

import com.englishquiz.model.Level;
import com.englishquiz.model.Question;
import com.englishquiz.service.QuestionService;
import com.englishquiz.view.QuestionText;

import java.util.List;
import java.util.Scanner;


public class QuestionController implements Controller {
    private QuestionService questionService = new QuestionService();
    private QuestionText questionText = new QuestionText();
    private Scanner scanner = new Scanner(System.in);
    private AnswerController answerController;

    private int escolhaDeUsuario;
    private Level levelAtual;
    private List<Question> questoes;
    private int contadorQuestaoAtual = 0;

    QuestionController() {}

    QuestionController(Level level) {
        this.levelAtual = level;
        questoes = questionService.listarPorNivel(levelAtual);
        if (questoes.isEmpty())
            System.out.println("Nenhuma questão disponível para este nível.");
    }

    @Override
    public void abrirView() {
        answerController = new AnswerController(questoes.get(contadorQuestaoAtual));

        questionText.mostrarQuestao(contadorQuestaoAtual, questoes.get(contadorQuestaoAtual));
        answerController.abrirView();
        questionText.pedirResposta();
        receberResposta();
    }

    public void receberResposta() {
        setarEscolhaNumerica();
        switch (escolhaDeUsuario) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:

                break;
            case 0:
                new LevelController().abrirView(); // Volta pro menu de níveis
                return;
            default:
                receberResposta();
                break;
        }
    }

    // private void voltarPergunta() {
    //     if(contadorQuestaoAtual != 0)
    //         contadorQuestaoAtual--;
    //     abrirView();
    // }

    // private void proximaPergunta() {
    //     if(contadorQuestaoAtual != 4)
    //         contadorQuestaoAtual++;
    //     abrirView();
    // }
    
    protected void setarEscolhaNumerica() {
        try {
            this.escolhaDeUsuario = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            questionText.mensagemDeErroGenerico("Escolha uma opção valida");
        }
    }
}
