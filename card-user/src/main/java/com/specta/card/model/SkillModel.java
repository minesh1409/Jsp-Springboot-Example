package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class SkillModel {
	
	@Id
	@Column(name="skill_id")
	private int id;
	
	@Column(name="skill_name")
	private String skillName;
	
	@Column(name="skill_value")
	private int skillValue;
	
	@Column(name="skill_user_id")
	private int userId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getSkillValue() {
		return skillValue;
	}
	public void setSkillValue(int skillValue) {
		this.skillValue = skillValue;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public SkillModel() {
		super();
	}
	public SkillModel(int id) {
		super();
		this.id = id;
	}
	public SkillModel(int id, String skillName, int skillValue, int userId) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.skillValue = skillValue;
		this.userId = userId;
	}
	
	
	
	
	
}
