package com.specta.card.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card_ids")
public class GenerateCardIdModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="card_id")
	private String cardId;
	
	@Column(name="card_link")
	private String cardLink;
	
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private String createdAt;
	
	@Column(name="updated_at")
	private String updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardLink() {
		return cardLink;
	}

	public void setCardLink(String cardLink) {
		this.cardLink = cardLink;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public GenerateCardIdModel() {
		super();
		
	}

	public GenerateCardIdModel(int id) {
		super();
		this.id = id;
	}

	public GenerateCardIdModel(int id, String cardId, String cardLink, String mobile, String status, String createdAt,
			String updatedAt) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.cardLink = cardLink;
		this.mobile = mobile;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "GenerateCardIdModel [id=" + id + ", cardId=" + cardId + ", cardLink=" + cardLink + ", mobile=" + mobile
				+ ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	

}
