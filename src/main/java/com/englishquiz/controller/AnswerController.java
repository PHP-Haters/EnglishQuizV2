package com.englishquiz.controller;

import java.util.List;
import com.englishquiz.service.AnswerService;
import com.englishquiz.service.UserAnswerService;
import com.englishquiz.view.AnswerText;
import com.englishquiz.model.Question;
import com.englishquiz.model.User;
import com.englishquiz.model.UserAnswer;
import com.englishquiz.server.Session;
import com.englishquiz.model.Answer;

public class AnswerController implements Controller{

    private UserAnswerService userAnswerService = new UserAnswerService();
    private AnswerService answerService = new AnswerService();
    private AnswerText answerText = new AnswerText();
    private Question currentQuestion = new Question();
    private List<Answer> respostasDaQuestao;

    AnswerController() {}

    AnswerController(Question question) {
        this.currentQuestion = question;
        respostasDaQuestao = answerService.listarPorPergunta(currentQuestion);
        if (respostasDaQuestao.isEmpty())
            System.out.println("Nenhuma resposta disponível para esta pergunta.");
    }

    public List<UserAnswer> getRespostasDaQuestao() {
        return userAnswerService.encontrarPorUsuario(Session.getInstance().getLoggedUser());
    }

    @Override
    public void abrirView() {
        answerText.mostrarRespostasDaPergunta(respostasDaQuestao);
    }

    public Answer encontrarResposta(String escolhida) {
        escolhida = '('+escolhida+')';
        return answerService.encontrarRespostaCom(escolhida, this.currentQuestion);
    }

    public void criarRespostaDoUsuario(Answer respostaEscolhida) {
        //Criando o userAnswer que será enviado ao DB
        User currentUser = Session.getInstance().getLoggedUser();         
        UserAnswer userAnswer = new UserAnswer(currentUser, respostaEscolhida);        
        userAnswerService.enviarResposta(userAnswer);
    }

}
