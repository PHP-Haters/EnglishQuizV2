package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.englishquiz.controller.UserController;


public class UserOptions extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public UserOptions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 499, 306);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Escolha uma opção:");
        lblTitle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));

        JLabel lblUserInfo = createClickableLabel("Informações do usuário", "blue");
        JLabel lblLevels = createClickableLabel("Níveis", "blue");
        JLabel lblExit = createClickableLabel("Deslogar", "red");

        lblUserInfo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Informações do usuário selecionado");
            }
        });

        lblLevels.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Níveis selecionado");
            }
        });

        lblExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
				//Todo: Limpar sessao e voltar para tela de login
				UserController userController = new UserController();
				userController.logout();
                dispose(); // Fecha a janela
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(28)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitle)
                        .addComponent(lblUserInfo)
                        .addComponent(lblLevels)
                        .addComponent(lblExit))
                    .addContainerGap(200, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(21)
                    .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblUserInfo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblLevels, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

    private JLabel createClickableLabel(String text, String color) {
        JLabel label = new JLabel("<html><span style='color:" + color + "; text-decoration:underline;'>" + text + "</span></html>");
        label.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return label;
    }
}
