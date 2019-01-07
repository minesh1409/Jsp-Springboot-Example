package com.specta.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile_analysis")
public class ProfileAnalyasisModel {
	
	@Id
	@Column(name="prof_id")
	private int id;
	
	@Column(name="pro_mobile")
	private String mobile;
	
	@Column(name="pro_os")
	private String os;
	
	@Column(name="pro_browser")
	private String browser;
	
	@Column(name="pro_ip")
	private String ip;
	
	@Column(name="pro_country")
	private String country;
	
	@Column(name="pro_state")
	private String state;
	
	@Column(name="pro_city")
	private String city;
	
	@Column(name="pro_latitude")
	private String latitude;
	
	@Column(name="pro_longitude")
	private String longitude;
	
	@Column(name="pro_created_at")
	private String createdAt;
	
	@Column(name="pro_card_id")
	private String cardId;
	
	@Column(name="pro_user_id")
	private int userId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public ProfileAnalyasisModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfileAnalyasisModel(int id) {
		super();
		this.id = id;
	}
	public ProfileAnalyasisModel(int id, String mobile, String os, String browser, String ip, String country, String state,
			String city, String latitude, String longitude, String createdAt, String cardId, int userId) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.os = os;
		this.browser = browser;
		this.ip = ip;
		this.country = country;
		this.state = state;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.createdAt = createdAt;
		this.cardId = cardId;
		this.userId = userId;
	}
	
	
	@Override
	public String toString() {
		return "ProfileAnalyasisModel [id=" + id + ", mobile=" + mobile + ", os=" + os + ", browser=" + browser
				+ ", ip=" + ip + ", country=" + country + ", state=" + state + ", city=" + city + ", latitude="
				+ latitude + ", longitude=" + longitude + ", createdAt=" + createdAt + ", cardId=" + cardId
				+ ", userId=" + userId + "]";
	}
	
		
	
	

}
