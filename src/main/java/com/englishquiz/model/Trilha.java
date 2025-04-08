package com.englishquiz.model;

import java.util.ArrayList;

public class Trilha {
    private int id;
    private String nomeTrilha;
    private ArrayList<Level> levels;

    public Trilha(int id, String nomeTrilha, ArrayList<Level> levels) {
        this.id = id;
        this.nomeTrilha = nomeTrilha;
        
        if (levels == null) {
            this.levels = new ArrayList<>();
        } else {
            this.levels = levels;
        }
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int setId() {
        return id;
    }

    public void setNomeTrilha(String nomeTrilha) {
        this.nomeTrilha = nomeTrilha;
    }

    public String getNomeTrilha() {
        return nomeTrilha;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

    public void addLevel(Level level) {
        this.levels.add(level);
    }
}
