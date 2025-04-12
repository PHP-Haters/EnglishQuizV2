package com.englishquiz.view;

import com.englishquiz.model.Question;
    
public class QuestionText extends Text {
    
    int contador;
    
    public void mostrarQuestao(int contador, Question q) {
        this.contador = contador;
        this.limparConsole();
        System.out.println(" QUESTÕES DO NÍVEL: " + q.getLevel().getNomeLevel().toUpperCase());
        System.out.println("\n---------------------------");
        System.out.println(contador+1 + ". " + q.getText());
        System.out.println("\n---------------------------");
    }

    public void trocarPergunta() {
        if(contador != 0)
            System.out.println("Digite 1 para ver a pergunta anterior.");
        if(contador != 4)
            System.out.println("Digite 2 para ver a próxima pergunta.");
    }
}

    

