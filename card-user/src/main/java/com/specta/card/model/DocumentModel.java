package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="document")
public class DocumentModel {
	
	@Id
	@Column(name = "doc_id")
	private int id;

	@Column(name = "doc_name")
	private String name;
	
	@Column(name = "doc_front_img")
	private String frontImageUrl;
	
	@Column(name = "doc_back_img")
	private String backImageUrl;
	
	@Column(name = "doc_user_id")
	private int userId;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrontImageUrl() {
		return frontImageUrl;
	}

	public void setFrontImageUrl(String frontImageUrl) {
		this.frontImageUrl = frontImageUrl;
	}

	public String getBackImageUrl() {
		return backImageUrl;
	}

	public void setBackImageUrl(String backImageUrl) {
		this.backImageUrl = backImageUrl;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public DocumentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentModel(int id) {
		super();
		this.id = id;
	}

	public DocumentModel(int id, String name, String frontImageUrl, String backImageUrl, int userId) {
		super();
		this.id = id;
		this.name = name;
		this.frontImageUrl = frontImageUrl;
		this.backImageUrl = backImageUrl;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "DocumentModel [id=" + id + ", name=" + name + ", frontImageUrl=" + frontImageUrl + ", backImageUrl="
				+ backImageUrl + ", userId=" + userId + "]";
	}
	
	
}
