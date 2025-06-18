package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import com.englishquiz.server.Session;

import java.awt.*;
import java.awt.event.*;

public class MostrarUserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MostrarUserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);

		JLabel titleLabel = new JLabel("Usuário Atual");
		titleLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));

		// Dados do usuário logado
		int id = Session.getInstance().getLoggedUser().getId();
		String email = Session.getInstance().getLoggedUser().getEmail();
		String password = Session.getInstance().getLoggedUser().getPassword();

		// Cabeçalhos da tabela
		String[] columnNames = {"ID", "Email", "Senha"};
		Object[][] data = {
			{ id, email, password }
		};

		JTable table = new JTable(new DefaultTableModel(data, columnNames));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(245, 101, 80));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				PerfilOptionView perfilOptions = new PerfilOptionView();
				perfilOptions.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(titleLabel)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(185)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(titleLabel)
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(btnVoltar)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
