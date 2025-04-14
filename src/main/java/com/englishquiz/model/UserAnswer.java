package com.englishquiz.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario_resposta")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_resposta")
    private Answer answer;

    public UserAnswer() {}

    public UserAnswer(User user, Answer answer) {
        this.user = user;
        this.answer = answer;
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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
