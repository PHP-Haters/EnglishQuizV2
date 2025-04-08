package com.englishquiz.controller;

import java.util.Scanner;
import com.englishquiz.view.Text;

public class MainController implements Controller {
    private Text text;
    Scanner scanner = new Scanner(System.in);
    

    public MainController() {
        text = new Text();
    }

    @Override
    public void abrirView() {
        text.mainMenu();
        int escolha = Integer.parseInt(scanner.nextLine());
        
        UserController userController = new UserController();
        LevelController levelController = new LevelController();
        Text text = new Text();

        switch (escolha) {
            case 1:
                text.limparConsole();
                userController.iniciarSistemaInterno();
                break;
            case 2:
                text.limparConsole();
                levelController.abrirView();
                break;
            case 0:
                text.limparConsole();
                userController.logout();
                break;
            default:
                abrirView();
                break;
        }
    }
}
