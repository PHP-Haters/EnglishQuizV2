package com.englishquiz.view;

import com.englishquiz.model.Question;
import java.util.List;
    
public class QuestionText {

    public void mostrarQuestoesDoNivel(String nomeDoNivel, List<Question> questoes) {
        System.out.println("\n---------------------------");
        System.out.println(" QUESTÕES DO NÍVEL: " + nomeDoNivel.toUpperCase());
        System.out.println("---------------------------");

        if (questoes.isEmpty()) {
            System.out.println("Nenhuma questão disponível para este nível.");
        } else {
            int contador = 1;
            for (Question q : questoes) {
                System.out.println(contador + ". " + q.getText());
                contador++;
            }
        }

        System.out.println("\n(Pressione 0 para voltar ao menu)");
    }
}

    

