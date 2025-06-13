package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;

import com.englishquiz.server.Session;

import java.awt.*;
import java.awt.event.*;

import javax.swing.GroupLayout.*;

public class MostrarUserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MostrarUserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Usuário atual");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(new Color(244, 94, 72));
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));

		JLabel lblNewLabel_2 = new JLabel("Email: ");
		lblNewLabel_2.setForeground(new Color(244, 94, 72));
		lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));

		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setForeground(new Color(244, 94, 72));
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));

		JLabel lblNewLabel_4 = new JLabel(String.valueOf(Session.getInstance().getLoggedUser().getId()));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_5 = new JLabel(Session.getInstance().getLoggedUser().getEmail());
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_6 = new JLabel(Session.getInstance().getLoggedUser().getPassword());
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnvoltar.setBackground(new Color(245, 101, 80));
		btnvoltar.addActionListener(new ActionListener() {
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
					.addGap(23)
					.addComponent(lblNewLabel))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(182)
					.addComponent(btnvoltar))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1))
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_6)))
					.addGap(25)
					.addComponent(btnvoltar))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
