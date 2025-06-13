package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.GroupLayout.*;
import java.awt.event.*;

public class DeleteUserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public DeleteUserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_1 = new JLabel("Tem certeza que deseja deletar o usuário permanentemente?");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));

		JLabel lblNewLabel = new JLabel("Ao deletar o usuário atual você será deslogado do sistema.");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));

		JButton btnConfirmar = new JButton("Sim");
		btnConfirmar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnConfirmar.setBackground(new Color(239, 101, 86));
		btnConfirmar.setForeground(new Color(0, 0, 0));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				/*
					Aqui uma função deleteUser deve ser chamada
					essa função deve ser escrita no userController.
					Caso a exclusão do usuário seja bem sucedida,
					basta fechar essa janela e voltar para a janela anterior
				*/
			}
		});

		JButton btnVoltar = new JButton("Não");
		btnVoltar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(239, 101, 86));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				PerfilOption perfilOptions = new PerfilOption();
                perfilOptions.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel_1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addComponent(lblNewLabel_1)
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConfirmar)
						.addComponent(btnVoltar))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
