package com.englishquiz.view;

import java.util.List;

import com.englishquiz.model.Answer;
    
public class AnswerText extends Text {
    
    public void mostrarRespostasDaPergunta(List<Answer> respostas) {
        for (Answer answer : respostas) {
            System.err.println(answer.getContent());
        }
        
    }
}

    

