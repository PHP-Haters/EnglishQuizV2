package com.englishquiz.service;

import com.englishquiz.dao.QuestionDAO;
import com.englishquiz.model.Level;
import com.englishquiz.model.Question;
import com.englishquiz.model.Level.Types;

import java.util.List;

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
            questionDAO.save(new Question("What is your name?", iniciante));
            questionDAO.save(new Question("Where do you live?", iniciante));
            questionDAO.save(new Question("Do you like pizza?", iniciante));
            questionDAO.save(new Question("How old are you?", iniciante));
            questionDAO.save(new Question("What is your favorite color?", iniciante));

            // Questões nível intermediário
            questionDAO.save(new Question("What are you doing?", intermediario));
            questionDAO.save(new Question("Can you help me with this problem?", intermediario));
            questionDAO.save(new Question("What did you do last weekend?", intermediario));
            questionDAO.save(new Question("How often do you go to the gym?", intermediario));
            questionDAO.save(new Question("What kind of music do you usually listen to?", intermediario));

            // Questões nível avançado
            questionDAO.save(new Question("Have you ever been abroad?", avancado));
            questionDAO.save(new Question("What would you have done differently?", avancado));
            questionDAO.save(new Question("If you could travel anywhere in the world, where would you go and why?", avancado));
            questionDAO.save(new Question("What are the pros and cons of working remotely?", avancado));
            questionDAO.save(new Question("How do you think technology is affecting human relationships?", avancado));

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

