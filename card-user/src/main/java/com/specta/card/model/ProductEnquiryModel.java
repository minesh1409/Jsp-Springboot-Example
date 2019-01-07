package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_enquiry")
public class ProductEnquiryModel {

	@Id
	@Column(name = "enquiry_id")
	private int id;

	@Column(name = "enquiry_user_name")
	private String guestName;

	@Column(name = "enquiry_email")
	private String email;

	@Column(name = "enquiry_contact")
	private String contact;

	@Column(name = "enquiry_message")
	private String message;

	@Column(name = "enquiry_product_id")
	private int productId;

	@Column(name = "product_enquiry_user_id")
	private int userId;

	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ProductEnquiryModel() {
		super();
	}

	public ProductEnquiryModel(int id) {
		super();
		this.id = id;
	}

	public ProductEnquiryModel(int id, String email, String contact, String message, String guestName, int productId,
			int userId) {
		super();
		this.id = id;
		this.email = email;
		this.contact = contact;
		this.message = message;
		this.guestName = guestName;
		this.productId = productId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProductEnquiryModel [id=" + id + ", email=" + email + ", contact=" + contact + ", message=" + message
				+ ", guestName=" + guestName + ", productId=" + productId + ", userId=" + userId + "]";
	}

}
