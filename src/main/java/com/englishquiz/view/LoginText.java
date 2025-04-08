package com.englishquiz.view;

public class LoginText extends Text {

    //* Texto relacionado ao login.
    public void entrandoNoSistema() {
        System.out.println("-----------------");
        System.out.println("1. Login");
        System.out.println("2. Registrar");
        System.out.println("3. Fechar o sistema");
        System.out.println("-----------------");
    }
    public void pedirEmail() {
        System.out.println("-----------------");
        System.out.println("Escreva seu email. Para voltar, digite 0.");
        System.out.println("Email:");
    }
    public void pedirSenha() {
        System.out.println("-----------------");
        System.out.println("Escreva sua senha. Para voltar, digite 0.");
        System.out.println("Senha:");
    }
    public void senhaPrecisa() {
        System.out.println("-----------------");
        System.out.println("A senha precisa de pelo menos 8 carateres e 2 números.");
    }

    public void jaExiste() {
        System.out.println("-----------------");
        System.out.println("Usuário já existe.");
        System.out.println("-----------------");
        System.out.println("\n");
    }
}