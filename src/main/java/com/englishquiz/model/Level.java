package com.englishquiz.model;

import javax.persistence.*;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeLevel;

    @Enumerated(EnumType.STRING) 
    private Types types;

    public enum Types {
        INICIANTE,
        INTERMEDIARIO,
        AVANCADO
    }

    public Level() {}
    
    public Level(int id, String nomeLevel, Types types) {
        this.id = id;
        this.nomeLevel = nomeLevel;
        this.types = types;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNomeLevel(String nomeLevel) {
        this.nomeLevel = nomeLevel;
    }

    public String getNomeLevel() {
        return nomeLevel;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Types getTypes() {
        return types;
    }
}
