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
        answerDAO.save(new Answer("(a) it´s", questoes.get(0), false));
        answerDAO.save(new Answer("(b) are", questoes.get(0), false));
        answerDAO.save(new Answer("(c) am", questoes.get(0), true));
        // respostas pergunta 2
        answerDAO.save(new Answer("(a) is", questoes.get(1), true));
        answerDAO.save(new Answer("(b) are", questoes.get(1), false));
        answerDAO.save(new Answer("(c) am", questoes.get(1), false));
        // respostas pergunta 3
        answerDAO.save(new Answer("(a) are", questoes.get(2), false));
        answerDAO.save(new Answer("(b) am", questoes.get(2), false));
        answerDAO.save(new Answer("(c) is", questoes.get(2), true));
        // respostas pergunta 4
        answerDAO.save(new Answer("(a) live", questoes.get(3), true));
        answerDAO.save(new Answer("(b) lives", questoes.get(3), false));
        answerDAO.save(new Answer("(c) living", questoes.get(3), false));
        // respostas pergunta 5
        answerDAO.save(new Answer("(a) They", questoes.get(4), true));
        answerDAO.save(new Answer("(b) Them", questoes.get(4), false));
        answerDAO.save(new Answer("(c) Their", questoes.get(4), false));
    }

    private void salvarRespostasSegundoNivel() {
        // respostas pergunta 1
        answerDAO.save(new Answer("(a) have", questoes.get(5), false));
        answerDAO.save(new Answer("(b) had", questoes.get(5), true));
        answerDAO.save(new Answer("(c) has", questoes.get(5), false));
        // respostas pergunta 2
        answerDAO.save(new Answer("(a) has", questoes.get(6), true));
        answerDAO.save(new Answer("(b) have", questoes.get(6), false));
        answerDAO.save(new Answer("(c) had", questoes.get(6), false));
        // respostas pergunta 3
        answerDAO.save(new Answer("(a) has", questoes.get(7), false));
        answerDAO.save(new Answer("(b) have", questoes.get(7), true));
        answerDAO.save(new Answer("(c) had", questoes.get(7), false));
        // respostas pergunta 4
        answerDAO.save(new Answer("(a) but", questoes.get(8), false));
        answerDAO.save(new Answer("(b) if", questoes.get(8), true));
        answerDAO.save(new Answer("(c) unless", questoes.get(8), false));
        // respostas pergunta 5
        answerDAO.save(new Answer("(a) am", questoes.get(9), false));
        answerDAO.save(new Answer("(b) were", questoes.get(9), true));
        answerDAO.save(new Answer("(c) was", questoes.get(9), false));
    }

    private void salvarRespostasTerceiroNivel() {
        // respostas pergunta 1
        answerDAO.save(new Answer("(a) will have been", questoes.get(10), false));
        answerDAO.save(new Answer("(b) will be", questoes.get(10), true));
        answerDAO.save(new Answer("(c) have been", questoes.get(10), false));
        // respostas pergunta 2
        answerDAO.save(new Answer("(a) did", questoes.get(11), true));
        answerDAO.save(new Answer("(b) does", questoes.get(11), false));
        answerDAO.save(new Answer("(c) has", questoes.get(11), false));
        // respostas pergunta 3
        answerDAO.save(new Answer("(a) return", questoes.get(12), true));
        answerDAO.save(new Answer("(b) returned", questoes.get(12), false));
        answerDAO.save(new Answer("(c) will return", questoes.get(12), false));
        // respostas pergunta 4
        answerDAO.save(new Answer("(a) do", questoes.get(13), false));
        answerDAO.save(new Answer("(b) does", questoes.get(13), true));
        answerDAO.save(new Answer("(c) did", questoes.get(13), false));
        // respostas pergunta 5
        answerDAO.save(new Answer("(a) can't", questoes.get(14), false));
        answerDAO.save(new Answer("(b) couldn't", questoes.get(14), true));
        answerDAO.save(new Answer("(c) wasn't", questoes.get(14), false));
    }

    public List<Answer> listarPorPergunta(Question question) {
        return answerDAO.findByQuestion(question);
    }
}