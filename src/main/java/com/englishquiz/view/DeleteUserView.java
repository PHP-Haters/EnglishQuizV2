package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.GroupLayout.*;

public class DeleteUserView {
    public class DeleteUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public DeleteUser() {
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
		
		JButton btnNewButton = new JButton("Sim");
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(239, 101, 86));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Não");
		btnNewButton_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(239, 101, 86));
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
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
}
