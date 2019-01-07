package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="social")
public class SocialModel {
	
	@Id
	@Column(name="social_id")
	private int id;
	
	@Column(name="social_name")
	private String socialName;
	
	@Column(name="social_link")
	private String socialLink;
	
	@Column(name="social_user_id")
	private int userId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSocialName() {
		return socialName;
	}
	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}
	public String getSocialLink() {
		return socialLink;
	}
	public void setSocialLink(String socialLink) {
		this.socialLink = socialLink;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public SocialModel() {
		super();
	}
	public SocialModel(int id) {
		super();
		this.id = id;
	}
	public SocialModel(int id, String socialName, String socialLink, int userId) {
		super();
		this.id = id;
		this.socialName = socialName;
		this.socialLink = socialLink;
		this.userId = userId;
	}
	
	

}
