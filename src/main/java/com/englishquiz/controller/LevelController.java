package com.englishquiz.controller;

import java.util.Scanner;
import com.englishquiz.model.Level;
import com.englishquiz.view.Text;
import com.englishquiz.service.LevelService;
import com.englishquiz.view.LevelText;

public class LevelController implements Controller {
    private Scanner scanner = new Scanner(System.in);
    private Text text = new Text();
    private LevelText levelText = new LevelText();
    private LevelService levelService = new LevelService();

    @Override
    public void abrirView() {
        text.limparConsole();
        levelText.entrandoNaTrilha();

        int escolhaDeUsuario = scanner.nextInt();
        scanner.nextLine();

        Level nivelEscolhido = null;

        switch (escolhaDeUsuario) {
            case 1: 
                nivelEscolhido = levelService.buscarPorTipo(Level.Types.INICIANTE);
                break;
            case 2:
                nivelEscolhido = levelService.buscarPorTipo(Level.Types.INTERMEDIARIO);
                break;
            case 3:
                nivelEscolhido = levelService.buscarPorTipo(Level.Types.AVANCADO);
                break;
            case 0:
                text.limparConsole();
                MainController mainController = new MainController();
                mainController.abrirView();
                return;
            default:
                abrirView();
                return;
        }

        if (nivelEscolhido != null) {
            new QuestionController().mostrarQuestoesDoNivel(nivelEscolhido);
        } else {
            text.mensagemDeErroGenerico("Nível não encontrado.");
            abrirView();
        }
    }
}
