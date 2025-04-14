package com.englishquiz.service;

import com.englishquiz.dao.QuestionDAO;

import java.util.List;

import com.englishquiz.dao.AnswerDAO;
import com.englishquiz.model.Answer;
import com.englishquiz.model.Question;

public class AnswerService {
    private final QuestionDAO questionDAO = new QuestionDAO();
    private final AnswerDAO answerDAO = new AnswerDAO();
    private List<Question> questoes;
     public void criarRespostasPadrao() {
        // Só insere se não houver respostas no banco
        if (answerDAO.findAll().isEmpty()) {
            questoes = questionDAO.findAll();
        
            salvarRespostasPrimeiroNivel();
            salvarRespostasSegundoNivel();
            salvarRespostasTerceiroNivel();
            System.out.println("Respostas padrão criadas com sucesso!");
        }
    }

    private void salvarRespostasPrimeiroNivel() {
        // respostas pergunta 1
        answerDAO.save(new Answer("(1) it´s", questoes.get(0), false));
        answerDAO.save(new Answer("(2) are", questoes.get(0), false));
        answerDAO.save(new Answer("(3) am", questoes.get(0), true));
        // respostas pergunta 2
        answerDAO.save(new Answer("(1) is", questoes.get(1), true));
        answerDAO.save(new Answer("(2) are", questoes.get(1), false));
        answerDAO.save(new Answer("(3) am", questoes.get(1), false));
        // respostas pergunta 3
        answerDAO.save(new Answer("(1) are", questoes.get(2), false));
        answerDAO.save(new Answer("(2) am", questoes.get(2), false));
        answerDAO.save(new Answer("(3) is", questoes.get(2), true));
        // respostas pergunta 4
        answerDAO.save(new Answer("(1) live", questoes.get(3), true));
        answerDAO.save(new Answer("(2) lives", questoes.get(3), false));
        answerDAO.save(new Answer("(3) living", questoes.get(3), false));
        // respostas pergunta 5
        answerDAO.save(new Answer("(1) They", questoes.get(4), true));
        answerDAO.save(new Answer("(2) Them", questoes.get(4), false));
        answerDAO.save(new Answer("(3) Their", questoes.get(4), false));
    }

    private void salvarRespostasSegundoNivel() {
        // respostas pergunta 1
        answerDAO.save(new Answer("(1) have", questoes.get(5), false));
        answerDAO.save(new Answer("(2) had", questoes.get(5), true));
        answerDAO.save(new Answer("(3) has", questoes.get(5), false));
        // respostas pergunta 2
        answerDAO.save(new Answer("(1) has", questoes.get(6), true));
        answerDAO.save(new Answer("(2) have", questoes.get(6), false));
        answerDAO.save(new Answer("(3) had", questoes.get(6), false));
        // respostas pergunta 3
        answerDAO.save(new Answer("(1) has", questoes.get(7), false));
        answerDAO.save(new Answer("(2) have", questoes.get(7), true));
        answerDAO.save(new Answer("(3) had", questoes.get(7), false));
        // respostas pergunta 4
        answerDAO.save(new Answer("(1) but", questoes.get(8), false));
        answerDAO.save(new Answer("(2) if", questoes.get(8), true));
        answerDAO.save(new Answer("(3) unless", questoes.get(8), false));
        // respostas pergunta 5
        answerDAO.save(new Answer("(1) am", questoes.get(9), false));
        answerDAO.save(new Answer("(2) were", questoes.get(9), true));
        answerDAO.save(new Answer("(3) was", questoes.get(9), false));
    }

    private void salvarRespostasTerceiroNivel() {
        // respostas pergunta 1
        answerDAO.save(new Answer("(1) will have been", questoes.get(10), false));
        answerDAO.save(new Answer("(2) will be", questoes.get(10), true));
        answerDAO.save(new Answer("(3) have been", questoes.get(10), false));
        // respostas pergunta 2
        answerDAO.save(new Answer("(1) did", questoes.get(11), true));
        answerDAO.save(new Answer("(2) does", questoes.get(11), false));
        answerDAO.save(new Answer("(3) has", questoes.get(11), false));
        // respostas pergunta 3
        answerDAO.save(new Answer("(1) return", questoes.get(12), true));
        answerDAO.save(new Answer("(2) returned", questoes.get(12), false));
        answerDAO.save(new Answer("(3) will return", questoes.get(12), false));
        // respostas pergunta 4
        answerDAO.save(new Answer("(1) do", questoes.get(13), false));
        answerDAO.save(new Answer("(2) does", questoes.get(13), true));
        answerDAO.save(new Answer("(3) did", questoes.get(13), false));
        // respostas pergunta 5
        answerDAO.save(new Answer("(1) can't", questoes.get(14), false));
        answerDAO.save(new Answer("(2) couldn't", questoes.get(14), true));
        answerDAO.save(new Answer("(3) wasn't", questoes.get(14), false));
    }

    public List<Answer> listarPorPergunta(Question question) {
        return answerDAO.findByQuestion(question);
    }

    public Answer encontrarRespostaCom(String escolhida, Question questao) {
        return answerDAO.findAnswerWith(escolhida, questao);
    }
}