package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.GroupLayout.*;
import java.awt.*;
import com.englishquiz.controller.UserController;
import com.englishquiz.view.MostrarUserView;

public class LoginView extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UserController userController;
	public LoginView() {
		userController  = new UserController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 105, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel("Welcome to English Quiz!");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		
		JTextPane email = new JTextPane();
		
		JTextPane passwordInput = new JTextPane();
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));

		JLabel warningLabel = new JLabel("");
		warningLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		
		JButton login = new JButton("Login");
		login.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				boolean booli = userController.login(email.getText(), passwordInput.getText());
				if(booli == true) {
					//todo CHAMAR PAGINA HOME
					dispose();
					MostrarUserView mostrarUserView = new MostrarUserView();
					mostrarUserView.setVisible(true);
				}
				else {
					warningLabel.setText("Falha no login, tente novamente");
				}
			}
		});
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("or");
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addComponent(lblNewLabel))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addComponent(email, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(passwordLabel)
					.addGap(44)
					.addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(warningLabel)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addComponent(login)
					.addGap(18)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(registerButton))
		);

		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				
			.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addGap(18)
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(emailLabel)
							
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					
					.addComponent(warningLabel)
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(login)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_3))
						.addComponent(registerButton)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}