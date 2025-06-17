package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.GroupLayout.*;

public class PerfilOptionView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PerfilOptionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 106, 82));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnUserInfos = new JButton("Mostrar usuário");
		btnUserInfos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnUserInfos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MostrarUserView userInfos = new MostrarUserView();
				userInfos.setVisible(true);
			}
		});

		JButton btnEditarEmail = new JButton("Editar email");
		btnEditarEmail.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnEditarEmail.setForeground(new Color(0, 0, 0));
		btnEditarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				EditEmailView editEmailView = new EditEmailView();
				editEmailView.setVisible(true);
			}
		});

		JButton btnEditarSenha = new JButton("Editar senha");
		btnEditarSenha.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnEditarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				EditPasswordView editPasswordView = new EditPasswordView();
				editPasswordView.setVisible(true);
			}
		});

		JButton btnDelUser = new JButton("Deletar usuário");
		btnDelUser.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnDelUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				DeleteUserView delUserView = new DeleteUserView();
				delUserView.setVisible(true);
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				MainMenuView initalScreen = new MainMenuView();
				initalScreen.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnUserInfos)
							.addGap(40)
							.addComponent(btnEditarEmail, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEditarSenha, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btnDelUser))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addGap(61))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUserInfos)
						.addComponent(btnEditarEmail))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditarSenha)
						.addComponent(btnDelUser))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVoltar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
