package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "experience")
public class ExperienceModel {

	@Id
	@Column(name = "exp_id")
	private int id;

	@Column(name = "exp_designation")
	private String expDesignation;

	@Column(name = "exp_company")
	private String expCompany;

	@Column(name = "exp_duration")
	private String expDuration;

	@Column(name = "exp_user_id")
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpDesignation() {
		return expDesignation;
	}

	public void setExpDesignation(String expDesignation) {
		this.expDesignation = expDesignation;
	}

	public String getExpCompany() {
		return expCompany;
	}

	public void setExpCompany(String expCompany) {
		this.expCompany = expCompany;
	}

	public String getExpDuration() {
		return expDuration;
	}

	public void setExpDuration(String expDuration) {
		this.expDuration = expDuration;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ExperienceModel() {
		super();
	}

	public ExperienceModel(int id) {
		super();
		this.id = id;
	}

	public ExperienceModel(int id, String expDesignation, String expCompany, String expDuration, int userId) {
		super();
		this.id = id;
		this.expDesignation = expDesignation;
		this.expCompany = expCompany;
		this.expDuration = expDuration;
		this.userId = userId;
	}

}
