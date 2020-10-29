package com.wipro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Assessment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assessmentId;
	
	@Column
	private String assessmentName;
	
	@Transient
	private List<Question> questions;
	
	public Assessment() {}

	public Assessment(String assessmentName, List<Question> questions) {
		super();
		this.assessmentName = assessmentName;
		this.questions = questions;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	

}
