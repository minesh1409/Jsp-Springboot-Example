package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="achievement")
public class AchievementModel {
	
	@Id
	@Column(name="ach_id")
	private int id;
	
	@Column(name="ach_title")
	private String title;
	
	@Column(name="ach_description")
	private String description;
	
	@Column(name="ach_user_id")
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public AchievementModel() {
		super();
	}

	public AchievementModel(int id) {
		super();
		this.id = id;
	}

	public AchievementModel(int id, String title, String description, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.userId = userId;
	}
	
	

}
