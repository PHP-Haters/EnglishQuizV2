package com.englishquiz.service;


import com.englishquiz.dao.LevelDAO;
import com.englishquiz.model.Level;
import com.englishquiz.model.Level.Types;

import java.util.List;

public class LevelService {
    
    private LevelDAO levelDAO = new LevelDAO();

    // Cria e salva níveis padrão caso ainda não existam
    public void inicializarNiveisPadrao() {
        List<Level> niveis = levelDAO.findAll();

        if (niveis == null || niveis.isEmpty()) {
            Level iniciante = new Level(0, "Iniciante", Types.INICIANTE);
            Level intermediario = new Level(0, "Intermediário", Types.INTERMEDIARIO);
            Level avancado = new Level(0, "Avançado", Types.AVANCADO);

            levelDAO.save(iniciante);
            levelDAO.save(intermediario);
            levelDAO.save(avancado);

            System.out.println("Níveis padrão criados com sucesso!");
        } else {
            System.out.println("Níveis já existentes no banco de dados.");
        }
    }

    public List<Level> listarTodosNiveis() {
        return levelDAO.findAll();
    }

    public Level buscarPorId(int id) {
        return levelDAO.findById(id);
    }

    public void salvarNivel(Level level) {
        levelDAO.save(level);
    }

    public Level buscarPorTipo(Level.Types type) {
        return levelDAO.findByType(type);
    }
}
