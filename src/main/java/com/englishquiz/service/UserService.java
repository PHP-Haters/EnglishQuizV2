package com.englishquiz.service;

import com.englishquiz.model.User;
import com.englishquiz.server.Session;
import com.englishquiz.dao.UserDAO;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void criarUserPadrao() {
        User user = userDAO.getUserByEmail("admin@gmail.com");

        if(user != null) {
            return;
        }
        else {
            userDAO.save(new User("admin@gmail.com", "admin"));
        }
    }

    //* Verificação para saber se está certo ou não
    public User verificacaoDeEmail(String email) {
        if (!email.contains("@")) {
            return null;
        }

        User user = userDAO.getUserByEmail(email);
        return user;
    }

    public boolean verificacaoDeSenha(User userToCompare, String password) {
        if(userToCompare.getPassword().compareTo(password) == 0)
            return true;

        return false;
    }

    //* Verificação para a criação
    public boolean confirmarSeEmailEstaCorreto(String newEmail) {
        if(newEmail.contains("@"))
            return true;
        else
            return false;
    }

    public boolean confirmarSeSenhaTemNumeros(String newPassword) {
        int contadorNum = 0;
        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for(int i=0; i < newPassword.length(); i++){
            char c = newPassword.charAt(i);
            
            for(int j=0; j < numeros.length; j++){
                if(c == numeros[j]) {
                    contadorNum ++;
                }
            }
        }

        if(contadorNum >= 2) return true;
        
        else {
            return false;
        }
    }

    public boolean confirmarSeSenhaEstaCorreto(String newPassword) {
        if(newPassword.length() >= 8 && confirmarSeSenhaTemNumeros(newPassword))
            return true;

        else {
            return false;
        }
    }

    //* Completa o registramento
    public boolean completarRegistro(User newUser) {

        newUser.setType(User.Type.USER);
        userDAO.save(newUser);
        
        return true;
    }

    public boolean pedirSenha(String password) {
        if(password.compareTo(Session.getInstance().getLoggedUser().getPassword()) == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void mudarEmail(String email) {
        User user = Session.getInstance().getLoggedUser();
        user.setEmail(email);
        Session.getInstance().setLoggedUser(user);
        userDAO.update(user);
    }
    public void mudarSenha(String senha) {
        User user = Session.getInstance().getLoggedUser();
        user.setPassword(senha);
        Session.getInstance().setLoggedUser(user);
        userDAO.update(user);
    }

    public void deletarUsuario() {
        userDAO.delete(Session.getInstance().getLoggedUser());
    }
}
