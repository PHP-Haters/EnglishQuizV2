package com.englishquiz.controller;

import java.util.List;

import com.englishquiz.model.Level;
import com.englishquiz.service.LevelService;

public class LevelController {
    LevelService levelService = new LevelService();

    public List<Level> getLevels() {
        List<Level> levels = levelService.listarTodosNiveis();
        return levels;
    }
}
