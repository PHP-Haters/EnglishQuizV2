package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;

import com.englishquiz.controller.UserController;

import java.awt.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.*;
import java.awt.event.*;

public class EditEmailView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Confirme sua senha para prosseguir:");
	private JPasswordField passwordField;
	private JTextField textField;

	public EditEmailView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));

		passwordField = new JPasswordField();

		JLabel lblNewLabel_1 = new JLabel("Digite um novo email:");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(241, 96, 80));
		btnConfirmar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				UserController userController = new UserController();
				boolean booli = userController.editarEmail(passwordField.getPassword(), textField.getText());
				if(booli == true) {
					dispose();
					MostrarUserView mostrarUserView = new MostrarUserView();
					mostrarUserView.setVisible(true);
				}
				else{
						//todo PRECISAMOS DE MENSAGEM DE AVISO AQUI PARA AVISAR QUE ELE FEZ ALGO ERRAOD PORRA
				}
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(241, 96, 80));
		btnVoltar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				PerfilOption perfilOptions = new PerfilOption();
                perfilOptions.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		// GRUPO HORIZONTAL
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnConfirmar)
							.addGap(18) // Espaço entre os botões
							.addComponent(btnVoltar)
						)
					)
				)
		);

		// GRUPO VERTICAL
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnVoltar)
					)
				)
		);
		contentPane.setLayout(gl_contentPane);
	}
}

