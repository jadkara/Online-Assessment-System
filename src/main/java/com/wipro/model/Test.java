package com.wipro.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long testId;
	
	@Column
	private Date testTakenDate;
	
	@Column
	private int score;
	
	@Column
	private int totalMark;
	
	@Column
	private String result;
	
	@Column
	private String assessmentName;
	
	private String email;

	public Test() {
		super();
	}

	public Test(Date testTakenDate, int score, int totalMark, String result, String assessmentName , String email) {
		super();
		this.testTakenDate = testTakenDate;
		this.score = score;
		this.totalMark = totalMark;
		this.result = result;
		this.assessmentName = assessmentName;
		this.email = email;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Date getTestTakenDate() {
		return testTakenDate;
	}

	public void setTestTakenDate(Date testTakenDate) {
		this.testTakenDate = testTakenDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
