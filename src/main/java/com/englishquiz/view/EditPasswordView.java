package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;

import com.englishquiz.controller.UserController;

import java.awt.*;
import java.awt.event.*;

public class EditPasswordView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnConfirmar;
	private JButton btnVoltar;

	public EditPasswordView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Confirme sua senha atual para prosseguir:");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));

		passwordField = new JPasswordField();

		JLabel lblNewLabel_1 = new JLabel("Digite sua nova senha:");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));

		passwordField_1 = new JPasswordField();

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(241, 104, 84));
		btnConfirmar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserController userController = new UserController();
				boolean booli = userController.editarSenha(passwordField.getPassword(), passwordField_1.getPassword());
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



		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(241, 104, 84));
		btnVoltar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PerfilOption perfilOptions = new PerfilOption();
				perfilOptions.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnConfirmar)
							.addGap(18)
							.addComponent(btnVoltar)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblNewLabel_1)
					.addGap(6)
					.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnVoltar))
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
