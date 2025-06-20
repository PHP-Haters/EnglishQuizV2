package com.englishquiz.view;

import javax.swing.*;
import javax.swing.border.*;

import com.englishquiz.model.Question;
import com.englishquiz.model.UserLevel;
import com.englishquiz.controller.AnswerController;
import com.englishquiz.controller.LevelController;
import com.englishquiz.controller.QuestionController;
import com.englishquiz.model.Answer;

import java.awt.*;
import javax.swing.GroupLayout.*;
import java.awt.event.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;
public class QuestionView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	UserLevel currentLevel;
	List<Question> questions;
	List<Answer> answersOfQuestion;
	int currentQuestion = 0;
	List<Question> answeredQuestions = new ArrayList<>();
	int quantityOfQuestions;

	JLabel questionLabel;
	JRadioButton firstAnswer;
	JRadioButton secondAnswer;
	JRadioButton thirdAnswer;
	ButtonGroup group;

	public void startView(UserLevel level) {
		currentLevel = level;
		defineQuestions();

		createView();
		findIfAnswerWasAnswered();
		setVisible(true);
	}

	private void defineQuestions() {
		QuestionController questionController = new QuestionController();
		questions = questionController.getQuestionsOfLevel(currentLevel.getLevel());
		quantityOfQuestions = questions.size();
		defineAnswers();
	}
	private void defineAnswers() {

		AnswerController answerController = new AnswerController();
		answersOfQuestion = answerController.getAnswersOfQuestion(questions.get(currentQuestion));
	}


	private void createView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 103, 83));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		questionLabel = new JLabel(questions.get(currentQuestion).getText());
		questionLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		questionLabel.setName(Integer.toString(questions.get(currentQuestion).getId()));

		firstAnswer = new JRadioButton(answersOfQuestion.get(0).getContent());
		firstAnswer.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		firstAnswer.setName(Integer.toString(0));

		secondAnswer = new JRadioButton(answersOfQuestion.get(1).getContent());
		secondAnswer.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		secondAnswer.setName(Integer.toString(1));

		thirdAnswer = new JRadioButton(answersOfQuestion.get(2).getContent());
		thirdAnswer.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		thirdAnswer.setName(Integer.toString(2));

		group = new ButtonGroup();
        group.add(firstAnswer);
        group.add(secondAnswer);
        group.add(thirdAnswer);

		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se o usuário selecionou alguma opção
				if (group.getSelection() == null) {
					JOptionPane.showMessageDialog(
						QuestionView.this,
						"Você precisa selecionar uma resposta antes de continuar.",
						"Nenhuma resposta selecionada",
						JOptionPane.WARNING_MESSAGE
					);
					return; // impede o avanço
				}

				createUserAnswer();
				currentQuestion++;
				if (currentQuestion == quantityOfQuestions-1) {
					btnNext.setText("Send");
				}
				if (currentQuestion == quantityOfQuestions) {
					

					Object[] options = {"Enviar respostas", "Cancelar"};
					int choice = JOptionPane.showOptionDialog(
						QuestionView.this,
						"Tem certeza que deseja enviar suas respostas?\nVocê não poderá alterá-las depois.",
						"Confirmar envio",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[0]
					);

					if (choice == JOptionPane.YES_OPTION) {
						createLevelUser();
						closeQuestions(); // Vai para LevelsView
					} else {
						currentQuestion--; // Fica na mesma pergunta
					}
				} else if (currentQuestion < quantityOfQuestions) {
					setQuestionAndAnswers();
					findIfAnswerWasAnswered();
				}
			}
		});


		JButton backButton = new JButton("Voltar");
		backButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentQuestion == 0) {
					closeQuestions();
				}
				else {
					btnNext.setText("Next");
					currentQuestion--;
					setQuestionAndAnswers();
					findIfAnswerWasAnswered();
				}
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(questionLabel))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(firstAnswer, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(secondAnswer, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(thirdAnswer, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(questionLabel)
					.addGap(18)
					.addComponent(firstAnswer)
					.addGap(18)
					.addComponent(secondAnswer)
					.addGap(18)
					.addComponent(thirdAnswer)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(backButton)
						.addComponent(btnNext)))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void setQuestionAndAnswers() {
		defineAnswers();
		group.clearSelection();
		questionLabel.setText(questions.get(currentQuestion).getText());
		firstAnswer.setText(answersOfQuestion.get(0).getContent());
		secondAnswer.setText(answersOfQuestion.get(1).getContent());
		thirdAnswer.setText(answersOfQuestion.get(2).getContent());

	}

	private void closeQuestions() {
		dispose();
		LevelsView levelsView = new LevelsView();
		levelsView.startView();
	}

	public int getSelectedButtonText() {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
				int foo = Integer.parseInt(button.getName());
				return foo;
        	};
		}
		return 5;
	}

	private void createUserAnswer() {
		int selectedAnswer = getSelectedButtonText();
		if(selectedAnswer != 5 && !answeredQuestions.contains(questions.get(currentQuestion))) {
			AnswerController answerController = new AnswerController();
			answerController.setUserAnswer(answersOfQuestion.get(selectedAnswer));
			answeredQuestions.add(questions.get(currentQuestion));
		}
	}

	private void findIfAnswerWasAnswered() {
		AnswerController answerController = new AnswerController();
		for(int i = 0; i<answersOfQuestion.size(); i++) {
			boolean wasItAnswered = answerController.findIfAnswerWasAnswered(answersOfQuestion.get(i));
			if(wasItAnswered == true) {
				deactivatedAnswer(i);
				break;
			}
			else {
				activateAnswer();
			}
		}
	}

	private void deactivatedAnswer(int i) {
		int f = 0;
		for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

			if(answersOfQuestion.get(f).getIsRight() == true) {
				button.setBackground(new Color(0,255,68));
			}

			if(Integer.parseInt(button.getName()) == i) {
				button.setSelected(true);
				button.setBackground(new Color(255,0,0));
			}
			f++;
			button.setEnabled(false);
		}
	}
	private void activateAnswer() {
		for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
			button.setSelected(false);
			button.setEnabled(true);
		}
	}

	private void createLevelUser() {
		System.err.println(answeredQuestions.size());
		System.err.println(questions.size());
		if(answeredQuestions.size() == questions.size()) {
			
			LevelController levelController = new LevelController();
			levelController.completeUserLevel(currentLevel);
		}
	}
}