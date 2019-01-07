package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductModel {

	@Id
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "producr_image_url")
	private String imageUrl;
	
	@Column(name = "product_description")
	private String description;
	
	@Column(name = "product_user_id")
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public ProductModel() {
		super();
	}

	public ProductModel(int id) {
		super();
		this.id = id;
	}

	public ProductModel(int id, String name, String imageUrl, String description, int userId) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", description=" + description
				+ ", userId=" + userId + "]";
	}
	
	
	
	

}
