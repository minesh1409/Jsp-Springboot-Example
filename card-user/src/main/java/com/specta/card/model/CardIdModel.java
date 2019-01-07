package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card_ids")
public class CardIdModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="card_id")
	private String cardId;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="status")
	private String status;
	
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

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CardIdModel() {
		super();
	}

	public CardIdModel(int id) {
		super();
		this.id = id;
	}

	public CardIdModel(int id, String cardId, String mobile, String status, String updatedAt) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.mobile = mobile;
		this.status = status;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "CheckCardIdModel [id=" + id + ", cardId=" + cardId + ", mobile=" + mobile + ", status=" + status
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	

}
