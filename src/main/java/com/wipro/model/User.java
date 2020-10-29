package com.wipro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@Column(unique=true)
	private String email;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column	
	private String password;
	
	@Column
	@Transient
	private String userType;
	
	@Column
	private String userTypeValue;
	
	
	public User() {
		
	}


	public User(String email, String firstName, String lastName, String password, String userType, String userTypeValue) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userType = userType;
		this.userTypeValue = userTypeValue;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getUserTypeValue() {
		return userTypeValue;
	}


	public void setUserTypeValue(String userTypeValue) {
		this.userTypeValue = userTypeValue;
	}


	@Override
	public String toString() {
		return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
