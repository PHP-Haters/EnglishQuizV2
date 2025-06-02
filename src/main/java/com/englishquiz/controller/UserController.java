package com.englishquiz.controller;

import java.util.Scanner;

import com.englishquiz.server.Session;
import com.englishquiz.dao.UserDAO;
import com.englishquiz.model.User;
import com.englishquiz.service.UserService;
import com.englishquiz.view.HomeView;
import com.englishquiz.view.Profile;
//import com.englishquiz.controller.MainController;

public class UserController implements Controller {
    HomeView homeView;
    Profile profileScreen;
    UserService userService;
    Scanner scanner;
    int escolhaDeUsuario;

    public UserController() {
        homeView = new HomeView();
        profileScreen = new Profile();
        userService = new UserService();
        scanner = new Scanner(System.in);
    }

    private UserDAO userDAO = new UserDAO();

    @Override
    public void abrirView() {
        homeView.setVisible(true);
    }

    //*Funções do login
    private void inputDoEmailLogin() {
        String userEmail = emailInput();

        if(retornarPaginaLogin(userEmail))
            return;

        User usuarioEncontrado = userService.verificacaoDeEmail(userEmail);
        if(usuarioEncontrado == null) {
            //loginText.mensagemDeErroGenerico("Email incorreto ou usuário inexistente");
            inputDoEmailLogin();
            
            return;
        }
        inputDaSenhaLogin(usuarioEncontrado);
    }

    private void inputDaSenhaLogin(User usuarioEncontrado) {
        String senhaDoUsuario = senhaInput();

        if(retornarPaginaLogin(senhaDoUsuario))
            return;

        if(userService.verificacaoDeSenha(usuarioEncontrado, senhaDoUsuario)) {
            Session.getInstance().setLoggedUser(usuarioEncontrado);
            //loginText.limparConsole();

            if(Session.getInstance().getLoggedUser() != null) {
                MainController mainController = new MainController();
                mainController.abrirView();
            }
        }
        else {
            //loginText.mensagemDeErroGenerico("Senha incorreta!");
            inputDaSenhaLogin(usuarioEncontrado);
        }
        
    }

    //* Funções de registro
    private void registerEmailInput() {
        String newUserEmail = emailInput();
        if(retornarPaginaLogin(newUserEmail))
            return;

        User usuarioEncontrado = userService.verificacaoDeEmail(newUserEmail);
        if(usuarioEncontrado != null) {
            //loginText.jaExiste();
            registerEmailInput();
            
            return;
        }

        boolean IsEmailCorrect = userService.confirmarSeEmailEstaCorreto(newUserEmail);
        if(!IsEmailCorrect) {
            //loginText.mensagemDeErroGenerico("O email deve conter @");
            registerEmailInput();
            
            return;
        }
        User newUser = new User(newUserEmail, "");
        registerSenhaInput(newUser);
    }
    private void registerSenhaInput(User newUser) {
        //loginText.senhaPrecisa();
        String newPassword = senhaInput();

        boolean IsPasswordCorrect = userService.confirmarSeSenhaEstaCorreto(newPassword);
        if(!IsPasswordCorrect) {
            //loginText.mensagemDeErroGenerico("Senha invalida");
            registerSenhaInput(newUser);
            
            return;
        }

        newUser.setPassword(newPassword);

        userService.completarRegistro(newUser);
        //comecarLoginOuRegister();
    }

    private boolean retornarPaginaLogin(String newInput) {
        if(newInput.compareTo("0") == 0) {
            //loginText.limparConsole();
            //comecarLoginOuRegister();
            
            return true;
        }
        return false;
    }

    //*Funções do sistema interno
    protected void iniciarSistemaInterno() {
        profileScreen.telaDoUsuario();
        setarEscolhaNumerica();
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
        setarEscolhaNumerica();
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

    protected void logout(){
        profileScreen.limparConsole();

        System.out.println("Deseja realmente fazer logout? (s/n)");
        String res = scanner.nextLine();

        if(res.equals("s")){
            finalizarSessao();
        } else {
            profileScreen.limparConsole();
            iniciarSistemaInterno();
        }
    }

    private void finalizarSessao(){
        Session.getInstance().setLoggedUser(null);
        profileScreen.limparConsole();
        //comecarLoginOuRegister();
    }

    //* funções pequenas de suporte
    protected void setarEscolhaNumerica() {
        try {
            this.escolhaDeUsuario = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            //loginText.mensagemDeErroGenerico("Escolha uma opção valida");
        }
    }
    protected String emailInput() {
        //loginText.pedirEmail();
        return scanner.nextLine();
    }
    protected String senhaInput() {
        //loginText.pedirSenha();
        return scanner.nextLine();
    }
}
