package com.englishquiz.view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.*;

public class LevelsView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public void startView() {
        createView();
        setVisible(true);
    }

    private void createView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);

        JLabel titleLabel = new JLabel("English Quiz");
        titleLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));

        JButton firstLevelButton = new JButton("Primeiro Nível");
        firstLevelButton.setBackground(new Color(245, 115, 82));
        firstLevelButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

        JButton secondLevelButton = new JButton("Segundo Nível");
        secondLevelButton.setBackground(new Color(248, 128, 92));
        secondLevelButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

        JButton thirdLevelButton = new JButton("Terceiro Nível");
        thirdLevelButton.setBackground(new Color(248, 128, 92));
        thirdLevelButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

        JButton backButton = new JButton("Voltar");
        backButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenuView initialScreen = new MainMenuView();
                initialScreen.setVisible(true);
            }
        });

        // Layout Configuration
        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(titleLabel)
                        .addComponent(firstLevelButton, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                        .addComponent(secondLevelButton, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                        .addComponent(thirdLevelButton, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addGap(27))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titleLabel)
                    .addGap(18)
                    .addComponent(firstLevelButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(secondLevelButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(thirdLevelButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE))
        );
    }
}
