package com.englishquiz.view;

public class Text {
    
    //* Funções genéricas relacionadas a printar texto
    public void limparConsole() {
        System.out.print("\033[H\033[2J");
    }

    public void mensagemDeErroGenerico(String message) {
        System.out.println("\n");
        System.out.println("-----------------");

        if(message != ""){
            System.out.println(message);
        } else {
            System.out.println("Algo deu errado!");
        }

        System.out.println("-----------------");
        System.out.println("\n");
    }

    public void mainMenu() {
        System.err.println("1. Informações do Usuário");
        System.err.println("2. Trilha");
        System.err.println("0. Log out");
    }
}
