package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vcf_download_count")
public class ProfileDownloadModel {
	
	@Id
	@Column(name="vcf_id")
	private int id;

	@Column(name="vcf_card_id")
	private String cardId;
	
	@Column(name="vcf_downloaded_at")
	private String createdAt;
	
	@Column(name="vcf_user_id")
	private int userId;
	
	
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public ProfileDownloadModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfileDownloadModel(int id) {
		super();
		this.id = id;
	}
	public ProfileDownloadModel(int id, String cardId, String createdAt, int userId) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.createdAt = createdAt;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ProfileDownloadModel [id=" + id + ", cardId=" + cardId + ", createdAt=" + createdAt + ", userId="
				+ userId + "]";
	}
	
	
}
