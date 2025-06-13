package com.englishquiz.controller;

import java.util.Scanner;

import com.englishquiz.server.Session;
// import com.englishquiz.dao.UserDAO;
import com.englishquiz.model.User;
import com.englishquiz.service.UserService;

//import com.englishquiz.controller.MainController;

public class UserController{
    UserService userService;
    Scanner scanner;
    int escolhaDeUsuario;

    public UserController() {
        userService = new UserService();
        scanner = new Scanner(System.in);
    }

    // private UserDAO userDAO = new UserDAO();

//*Funções do login
    public boolean login(String email, String password) {
        return validarEmail(email, password);
    }

    private boolean validarEmail(String email, String password) {
        User usuarioEncontrado = userService.verificacaoDeEmail(email);
        if(usuarioEncontrado == null) {
            return false;
        }
        return validarSenha(usuarioEncontrado, password);
    }
    private boolean validarSenha(User usuarioEncontrado, String password) {
        if(userService.verificacaoDeSenha(usuarioEncontrado, password)) {
            Session.getInstance().setLoggedUser(usuarioEncontrado);

            if(Session.getInstance().getLoggedUser() != null) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }


//* Funções de registro
    public boolean register(String email, String password) {
        return registrarEmail(email, password);
    }
    private boolean registrarEmail(String email, String password) {
        User usuarioEncontrado = userService.verificacaoDeEmail(email);
        if(usuarioEncontrado != null) {
            return false;
        }

        boolean IsEmailCorrect = userService.confirmarSeEmailEstaCorreto(email);
        if(!IsEmailCorrect) {
            return false;
        }

        User newUser = new User(email, "");
        return registrarSenha(newUser, password);
    }
    private boolean registrarSenha(User newUser, String newPassword) {
        boolean IsPasswordCorrect = userService.confirmarSeSenhaEstaCorreto(newPassword);
        if(!IsPasswordCorrect) {
            return false;
        }

        newUser.setPassword(newPassword);
        return userService.completarRegistro(newUser);
    }

//*Funcoes para editar usuario
    public boolean editarEmail(char[] receivedPassword, String email) {
        String password = String.valueOf(receivedPassword);
        boolean senhaEstaCerta = userService.pedirSenha(password);
        boolean emailEstaCerto = userService.confirmarSeEmailEstaCorreto(email);

        if(senhaEstaCerta == true && emailEstaCerto == true) {
            userService.mudarEmail(email);
            return true;
        }
        else
            return false;
    }
    public boolean editarSenha(char[] password, char[] newPassword) {
        String senha = String.valueOf(password);
        String senhaNova = String.valueOf(newPassword);
        boolean senhaEstaCerta = userService.pedirSenha(senha);
        boolean senhaNovaEstaCorreta = userService.confirmarSeSenhaEstaCorreto(senhaNova);

        if(senhaEstaCerta == true && senhaNovaEstaCorreta == true) {
            userService.mudarSenha(senhaNova);
            return true;
        }
        else
            return false;
    }


    public void logout(){
        finalizarSessao();
    }

    private void finalizarSessao(){
        Session.getInstance().setLoggedUser(null);
    }
}
