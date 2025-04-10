package com.englishquiz.service;

import java.util.List;

import com.englishquiz.dao.QuestionDAO;
import com.englishquiz.model.Level;
import com.englishquiz.model.Level.Types;
import com.englishquiz.model.Question;

public class QuestionService {
    
    private final QuestionDAO questionDAO = new QuestionDAO();
    private final LevelService levelService = new LevelService();
    
    public void criarQuestoesPadrao() {
        // Só insere se não houver questões no banco
        if (questionDAO.findAll().isEmpty()) {
            Level iniciante = levelService.buscarPorTipo(Types.INICIANTE);
            Level intermediario = levelService.buscarPorTipo(Types.INTERMEDIARIO);
            Level avancado = levelService.buscarPorTipo(Types.AVANCADO);

            if (iniciante == null || intermediario == null || avancado == null) {
                System.out.println("Erro: níveis não encontrados no banco. Inicialize os níveis antes das questões.");
                return;
            }

            // Questões nível iniciante
            questionDAO.save(new Question("I ____ Brazilian and i live in Foz do iguaçu!", iniciante));
            questionDAO.save(new Question("My name ___ Ana. ", iniciante));
            questionDAO.save(new Question("She ___ very happy today.", iniciante));
            questionDAO.save(new Question("We ___ in Brazil. ", iniciante));
            questionDAO.save(new Question("___ are my best friends. ", iniciante));

            // Questões nível intermediário
            questionDAO.save(new Question("If I ___ more time, I would learn to play the piano. ", intermediario));
            questionDAO.save(new Question("She ___ already finished her homework before dinner.", intermediario));
            questionDAO.save(new Question("They ___ seen that movie twice this week. ", intermediario));
            questionDAO.save(new Question("We will go out ___ it stops raining. ", intermediario));
            questionDAO.save(new Question("If I ___ you, I would take that job offer. ", intermediario));

            // Questões nível avançado
            questionDAO.save(new Question("By the end of next year, I ___ working in this company for ten years. ", avancado));
            questionDAO.save(new Question("Not only ___ she finish the project on time, but she also exceeded everyone's expectations.", avancado));
            questionDAO.save(new Question("I will call you as soon as I ___ from the meeting. ", avancado));
            questionDAO.save(new Question("Little ___ he understand the consequences of his decision. ", avancado));
            questionDAO.save(new Question("No matter how hard she tried, she ___ persuade him to change his mind.", avancado));

            System.out.println("Questões padrão criadas com sucesso!");
        }
    }

    public List<Question> listarTodas() {
        return questionDAO.findAll();
    }

    public List<Question> listarPorNivel(Level level) {
        return questionDAO.findByLevel(level);
    }
}

