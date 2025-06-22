package com.englishquiz.view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import com.englishquiz.controller.LevelController;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import com.englishquiz.model.UserLevel;


public class LevelsView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    List<UserLevel> levels;




    public void startView() {
        LevelController levelController = new LevelController();
        levels = levelController.getLevels();


        createView();
        setVisible(true);
    }


    private void createView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);


        contentPane = new JPanel();
        contentPane.setBackground(new Color(16, 0, 36));
        setContentPane(contentPane);


        JLabel titleLabel = new JLabel("English Quiz");
        titleLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(12, 156, 117));


        JButton backButton = new JButton("Voltar");
        backButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        backButton.setBackground(new Color(12, 156, 117));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenuView initialScreen = new MainMenuView();
                initialScreen.setVisible(true);
            }
        });


        // Criar os botões dinamicamente com base nos levels
        java.util.List<JButton> levelButtons = new java.util.ArrayList<>();


        for (UserLevel level : levels) {
            JButton btn = new JButton(level.getLevel().getNomeLevel()); // assumindo que Level tem getNomeLevel()
            if(level.getIsComplete() == true) {
            btn.setBackground(new Color(12, 156, 117));
            }
            else {
                btn.setBackground(new Color(255, 255, 255));
            }
            btn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
            btn.setPreferredSize(new Dimension(373, 50));


            // Aqui você pode adicionar o ActionListener para cada botão, se quiser
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Código para abrir o nível selecionado
                    QuestionView questionView = new QuestionView();
                    questionView.startView(level);
                    dispose();
                }
            });


            levelButtons.add(btn);
        }


        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);


        // Criando grupos horizontais
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup()
            .addGap(26);


        GroupLayout.ParallelGroup hParallelGroup = layout.createParallelGroup(Alignment.LEADING)
            .addComponent(titleLabel);


        for (JButton btn : levelButtons) {
            hParallelGroup.addComponent(btn, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE);
        }
        hParallelGroup.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE);


        hGroup.addGroup(hParallelGroup);
        hGroup.addGap(27);


        layout.setHorizontalGroup(hGroup);


        // Criando grupos verticais
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(titleLabel)
            .addGap(18);


        for (int i = 0; i < levelButtons.size(); i++) {
            vGroup.addComponent(levelButtons.get(i), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE);
            if (i < levelButtons.size() - 1) {
                vGroup.addGap(18);
            }
        }
        vGroup.addGap(18);
        vGroup.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(15, Short.MAX_VALUE);


        layout.setVerticalGroup(vGroup);
    }


}
