package com.englishquiz.controller;

import java.util.Scanner;

import com.englishquiz.server.Session;
import com.englishquiz.dao.UserDAO;
import com.englishquiz.model.User;
import com.englishquiz.service.UserService;

import com.englishquiz.view.Profile;
//import com.englishquiz.controller.MainController;

public class UserController implements Controller {
    
    Profile profileScreen;
    UserService userService;
    Scanner scanner;
    int escolhaDeUsuario;

    public UserController() {
        
        profileScreen = new Profile();
        userService = new UserService();
        scanner = new Scanner(System.in);
    }

    private UserDAO userDAO = new UserDAO();

    @Override
    public void abrirView() {
        
    }

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


    //! tem que apagar eventualmente
    protected void iniciarSistemaInterno() {
        profileScreen.telaDoUsuario();
        switch (escolhaDeUsuario) {
            case 1:
                listarUsuarioAtual();
                break;
            case 2:
                editarEmail();
                break;
            case 3:
                editarSenha();
                break;
            case 4:
                deletarUsuario();
                break;
            case 5:
                logout();
                break;
            case 0:
                profileScreen.limparConsole();
                MainController mainController = new MainController();
                mainController.abrirView();
                break;
            default:
                iniciarSistemaInterno();
                break;
        }
    }

    private void listarUsuarioAtual(){
        profileScreen.limparConsole();
        profileScreen.mostrarUsuario();

        System.out.println("\nDigite zero(0) para voltar...");

        if (escolhaDeUsuario == 0) {
            profileScreen.limparConsole();
            iniciarSistemaInterno();
        } else {
            listarUsuarioAtual();
        }
    }

    private boolean confirmarSenha(){
        String senhaAtual = Session.getInstance().getLoggedUser().getPassword();

        System.out.println("Confirme sua senha para prosseguir: ");
        String senhaDigitada = scanner.nextLine();

        if(senhaDigitada.equals(senhaAtual)){
            return true;
        } else {
            System.out.println("Senha incorreta!");
            return false;
        }
    }

    private boolean editarEmail(){
        User usuarioAtual = Session.getInstance().getLoggedUser();

        profileScreen.limparConsole();

        boolean senhaConfirmada = confirmarSenha();
        if(senhaConfirmada ==  false){
            iniciarSistemaInterno();
            return false;
        }

        System.out.println("Digite um novo email: ");
        String newEmail = scanner.nextLine();

        if(newEmail.contains("@") == false) {
            profileScreen.mensagemDeErroGenerico("Email inválido, vamos tentar de novo...");
            editarEmail();
        } else {
            usuarioAtual.setEmail(newEmail);
            finalizarUpdate(usuarioAtual);
        }

        return true;
    }

    private boolean editarSenha(){
        User usuarioAtual = Session.getInstance().getLoggedUser();


        profileScreen.limparConsole();

        boolean senhaConfirmada = confirmarSenha();
        if(senhaConfirmada ==  false){
            iniciarSistemaInterno();
            return false;
        }

        System.out.println("Digite uma nova senha: ");
        String newPassword = scanner.nextLine();

        if(newPassword.length() < 8){
            profileScreen.mensagemDeErroGenerico("A senha deve ter mais de 8 caracteres e ao menos 2 numeros.");
            editarSenha();
        } else {
            usuarioAtual.setPassword(newPassword);
            finalizarUpdate(usuarioAtual);
        }

        return true;
    }

    private void finalizarUpdate(User updatedUser){
        userDAO.update(updatedUser);
        profileScreen.limparConsole();
        iniciarSistemaInterno();
    }

    private void deletarUsuario(){
        User usuarioAtual = Session.getInstance().getLoggedUser();

        profileScreen.limparConsole();
        System.out.println("Ao deletar o usuário atual você será deslogado do sistema.");
        System.out.println("Tem certeza que deseja deletar o usuário permanentemente? (s/n) ");
        String res = scanner.nextLine();


        if(res.equals("s")){
            userDAO.delete(usuarioAtual);
            System.out.println("Usuário deletado com sucesso");
            finalizarSessao();
        } else {
            profileScreen.limparConsole();
            iniciarSistemaInterno();
        }
    }

    public void logout(){
        finalizarSessao();
    }

    private void finalizarSessao(){
        Session.getInstance().setLoggedUser(null);
        profileScreen.limparConsole();
        //comecarLoginOuRegister();
    }
}
