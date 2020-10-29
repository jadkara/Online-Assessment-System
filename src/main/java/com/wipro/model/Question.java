package com.wipro.model;

import org.springframework.stereotype.Component;

@Component
public class Question {
	
	private Long questionId;
	
	private String questionValue;
	
	private String[] answerOption;
	
	
	private int correctAnswer;

	public Question(Long questionId, String questionValue, String[] answerOption, int correctAnswer) {
		super();
		this.questionId = questionId;
		this.questionValue = questionValue;
		this.answerOption = answerOption;
		this.correctAnswer = correctAnswer;
	}

	public Question() {
		super();
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	public String[] getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(String[] answerOption) {
		this.answerOption = answerOption;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	

}
