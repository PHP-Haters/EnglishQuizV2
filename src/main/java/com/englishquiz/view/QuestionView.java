package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;

import com.englishquiz.model.Question;
import com.englishquiz.controller.AnswerController;
import com.englishquiz.controller.QuestionController;
import com.englishquiz.model.Answer;
import com.englishquiz.model.Level;

import java.awt.*;
import javax.swing.GroupLayout.*;
import java.awt.event.*;

import java.util.List;
public class QuestionView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List<Question> questions;
	List<Answer> answersOfQuestion;
	int currentQuestion = 0;

	public void startView(Level level) {
		defineQuestions(level);
	
		createView();
		setVisible(true);
	}

	private void defineQuestions(Level level) {
		QuestionController questionController = new QuestionController();
		questions = questionController.getQuestionsOfLevel(level);
	}
	private void defineAnswers() {
		AnswerController answerController = new AnswerController();
		answersOfQuestion = answerController.getAnswersOfQuestion(questions.get(currentQuestion));
	}

	private void getAnswersReady() {
		//TODO aqui vai lidar com as respostas da pergunta atual;
		//TODO aumentar o currentQuestion para pegar as respostas da pergunta atual e pegar a pergunta atual
		
		currentQuestion = 0;
		defineAnswers();
	}

	private void createView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 103, 83));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("I ___ Brazillian and I live in Foz do Iguaçu!");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("a) it´s");
		rdbtnNewRadioButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("b) are");
		rdbtnNewRadioButton_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("c) am");
		rdbtnNewRadioButton_2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		
		JButton backButton = new JButton("Voltar");
		backButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // fecha a QuestionView atual
				LevelsView levelsView = new LevelsView();
				levelsView.startView(); // abre a tela de níveis novamente
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(200) // espaçamento entre Voltar e Next
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_2)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(backButton)
						.addComponent(btnNext)))
		);
		contentPane.setLayout(gl_contentPane);
	}


}