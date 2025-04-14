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

    private String escolhaDeUsuario;
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
        setarEscolha();
        if(escolhaDeUsuario.compareTo("a") == 0  || escolhaDeUsuario.compareTo("b") == 0 || escolhaDeUsuario.compareTo("c") == 0){
            buscarResposta();
        } else if (escolhaDeUsuario == "0") {
            new LevelController().abrirView(); // Volta pro menu de níveis
        } else {
            receberResposta();
        }
    }

    private void buscarResposta() {
        AnswerController answerController = new AnswerController(questoes.get(contadorQuestaoAtual));
        Answer respostaEscolhida = answerController.encontrarResposta(escolhaDeUsuario);
        System.err.println(respostaEscolhida.getContent());

        criarRespostaDoUsuario(respostaEscolhida);
    }

    private void criarRespostaDoUsuario(Answer respostaEscolhida) {
        //Criando o userAnswer que será enviado ao DB
        User currentUser = Session.getInstance().getLoggedUser();         
        UserAnswer userAnswer = new UserAnswer(currentUser, respostaEscolhida);        
        userAnswerService.enviarResposta(userAnswer);

        continuarPerguntas();
    }
    private void continuarPerguntas() {
        if(contadorQuestaoAtual != 4) {
            contadorQuestaoAtual++;
            abrirView();
        }
        else {
            new LevelController().abrirView();
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
    
    protected void setarEscolha() {
        try {
            this.escolhaDeUsuario = scanner.nextLine();
        } catch (Exception e) {
            questionText.mensagemDeErroGenerico("Escolha uma opção valida");
        }
    }
}
