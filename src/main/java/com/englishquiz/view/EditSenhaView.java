package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.GroupLayout.*;

public class EditSenhaView {
    public class EditPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnNewButton;

	public EditPassword() {
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
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.setBackground(new Color(241, 104, 84));
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
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
					.addComponent(btnNewButton)
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);
	}

}

}
