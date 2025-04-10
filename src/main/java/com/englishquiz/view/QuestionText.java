package com.englishquiz.view;

import com.englishquiz.model.Question;
    
public class QuestionText extends Text {
    
    public void mostrarQuestao(int contador, Question q) {
        this.limparConsole();
        System.out.println(" QUESTÕES DO NÍVEL: " + q.getLevel().getNomeLevel().toUpperCase());
        System.out.println("\n---------------------------");
        System.out.println(contador+1 + ". " + q.getText());
        if(contador != 0)
            System.out.println("Digite 1 para ver a pergunta anterior.");
        if(contador != 4)
            System.out.println("Digite 2 para ver a próxima pergunta.");
        System.out.println("\n---------------------------");
    }
}

    

