package com.englishquiz.controller;

import com.englishquiz.model.Level;
import com.englishquiz.model.Question;
import com.englishquiz.model.Answer;
import com.englishquiz.model.UserAnswer;
import com.englishquiz.service.QuestionService;
import com.englishquiz.view.QuestionText;

import java.util.List;
import java.util.Scanner;


public class QuestionController implements Controller {
    private QuestionService questionService = new QuestionService();
    private QuestionText questionText = new QuestionText();
    private Scanner scanner = new Scanner(System.in);
    private AnswerController answerController;

    private String escolhaDeUsuario;
    private Level levelAtual;
    private List<Question> questoes;
    private int contadorQuestaoAtual = 0;

    private boolean usuarioRespondeuTudo = false;
    QuestionController() {}

    QuestionController(Level level) {
        this.levelAtual = level;
        questoes = questionService.listarPorNivel(levelAtual);
        if (questoes.isEmpty())
            System.out.println("Nenhuma questão disponível para este nível.");
    }

    @Override
    public void abrirView() {
        verificarSeRespondeu();
        questionText.mostrarQuestao(contadorQuestaoAtual, questoes.get(contadorQuestaoAtual));
        answerController.abrirView();
        if(usuarioRespondeuTudo) {
            questionText.trocarPergunta();
            olharAsPerguntas();
        } else {
            questionText.pedirResposta();
            receberResposta();
        }
    }
    private void verificarSeRespondeu() {
        answerController = new AnswerController(questoes.get(contadorQuestaoAtual));
        List<UserAnswer> answers = answerController.getRespostasDaQuestao();
        if(answers.size() == 5) {
            usuarioRespondeuTudo = true;
        }
        else {
            contadorQuestaoAtual = answers.size();
        }
        
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

        enviaRespostas(respostaEscolhida);
    }

    private void enviaRespostas(Answer respostaEscolhida) {
        //Criando o userAnswer que será enviado ao DB
        new AnswerController().criarRespostaDoUsuario(respostaEscolhida);
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

    private void olharAsPerguntas() {
        setarEscolha();
        switch (Integer.parseInt(escolhaDeUsuario)) {
            case 1:
                voltarPergunta();
                break;
            case 2:
                proximaPergunta();
                break;
            case 0:
                new LevelController().abrirView();
                return;
            default:
                olharAsPerguntas();
                break;
        }
    }
    private void voltarPergunta() {
        if(contadorQuestaoAtual != 0)
            contadorQuestaoAtual--;
        abrirView();
    }

    private void proximaPergunta() {
        if(contadorQuestaoAtual != 4)
            contadorQuestaoAtual++;
        abrirView();
    }
    
    protected void setarEscolha() {
        try {
            this.escolhaDeUsuario = scanner.nextLine();
        } catch (Exception e) {
            questionText.mensagemDeErroGenerico("Escolha uma opção valida");
        }
    }
}
