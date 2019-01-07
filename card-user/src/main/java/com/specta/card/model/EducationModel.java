package com.specta.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class EducationModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="edu_id")
	private int id;
	
	@Column(name="edu_degree")
	private String degree;
	
	@Column(name="edu_university")
	private String university;
	
	@Column(name="passing_year")
	private String passingYear;
	
	@Column(name="edu_user_id")
	private int userId;

	// Getter Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// Constructor
	public EducationModel() {
		super();
	}

	public EducationModel(int id) {
		super();
		this.id = id;
	}

	public EducationModel(int id, String degree, String university, String passingYear, int userId) {
		super();
		this.id = id;
		this.degree = degree;
		this.university = university;
		this.passingYear = passingYear;
		this.userId = userId;
	}

}
