package com.englishquiz.controller;

import com.englishquiz.model.Level;
import com.englishquiz.model.Question;
import com.englishquiz.model.User;
import com.englishquiz.model.Answer;
import com.englishquiz.model.UserAnswer;
import com.englishquiz.server.Session;
import com.englishquiz.service.QuestionService;
import com.englishquiz.service.UserAnswerService;
import com.englishquiz.view.QuestionText;

import java.util.List;
import java.util.Scanner;


public class QuestionController implements Controller {
    private QuestionService questionService = new QuestionService();
    private QuestionText questionText = new QuestionText();
    private Scanner scanner = new Scanner(System.in);
    private AnswerController answerController;
    private UserAnswerService userAnswerService = new UserAnswerService();

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
        if(escolhaDeUsuario == 1 || escolhaDeUsuario == 2 || escolhaDeUsuario == 3){
            //Aqui temos que achar um jeito de descobrir o id da resposta selecionada

            //Criando o userAnswer que será enviado ao DB
            Answer selectedAnswer = new Answer();
            User currentUser = Session.getInstance().getLoggedUser();           
            UserAnswer userAnswer = new UserAnswer(currentUser, selectedAnswer);
            
            userAnswerService.enviarResposta(userAnswer);
        } else if (escolhaDeUsuario == 0) {
            new LevelController().abrirView(); // Volta pro menu de níveis
        } else {
            receberResposta();
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
