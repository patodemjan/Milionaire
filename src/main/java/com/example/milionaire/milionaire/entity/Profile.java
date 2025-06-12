package com.example.milionaire.milionaire.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor	//generate constructors without parameters
@AllArgsConstructor 	//generate constructors with parameters
@Entity					//table in this class
public class Profile {
	
	
	//define private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String field;
	
	private int questionCount;

	public Profile(String field, int questionCount) {
		this.field = field;
		this.questionCount = questionCount;
	}
	
	public Profile() {
		
	}

	//generate getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	
	
}
