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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		
		JButton btnNewButton_2 = new JButton("Primeiro Nível");
		btnNewButton_2.setBackground(new Color(245, 115, 82));
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("Segundo Nível");
		btnNewButton_1.setBackground(new Color(248, 128, 92));
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Terceiro Nível");
		btnNewButton.setBackground(new Color(248, 128, 92));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("English Quiz");
		lblNewLabel.setBackground(new Color(248, 128, 92));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				MainMenuView initalScreen = new MainMenuView();
				initalScreen.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE).addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
							.addGap(27))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}