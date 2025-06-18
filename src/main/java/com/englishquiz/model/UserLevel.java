package com.englishquiz.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario_level")
public class UserLevel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_level")
    private Level level;

    private boolean is_complete;

    public UserLevel() {}

    public UserLevel(User user, Level level) {
        this.user = user;
        this.level = level;
        this.is_complete = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean getIsComplete() {
        return is_complete;
    }

    public void setIsComplete(boolean is_complete) {
        this.is_complete = is_complete;
    }
}
