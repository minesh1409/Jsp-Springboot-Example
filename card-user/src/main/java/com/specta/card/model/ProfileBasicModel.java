package com.specta.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class ProfileBasicModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "card_id")
	private String card_id;
	
	@Column(name = "share_id")
	private String shareId;
	
	@Id
	@Column(name = "profile_user_id")
	private int profile_user_id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "web")
	private String web;

	@Column(name = "user_pic")
	private String user_pic;

	@Column(name = "birthday")
	private String birthday;

	@Column(name = "gender")
	private String gender;

	@Column(name = "profession")
	private String profession;

	@Column(name = "home_address")
	private String home_address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;

	@Column(name = "work_address")
	private String work_address;

	@Column(name = "created_at")
	private String created_at;

	@Column(name = "update_at")
	private String update_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProfile_user_id() {
		return profile_user_id;
	}

	public void setProfile_user_id(int profile_user_id) {
		this.profile_user_id = profile_user_id;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}	

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getUser_pic() {
		return user_pic;
	}

	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWork_address() {
		return work_address;
	}

	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}

//	constructor

	public ProfileBasicModel() {
		super();
	}

	public ProfileBasicModel(int id) {
		super();
		this.id = id;
	}

	public ProfileBasicModel(int id, String card_id, String shareId, int profile_user_id, String first_name, String last_name,
			String mobile, String email, String web, String user_pic, String birthday, String gender, String profession,
			String home_address, String city, String state, String country, String work_address, String created_at,
			String update_at) {
		super();
		this.id = id;
		this.card_id = card_id;
		this.shareId = shareId;
		this.profile_user_id = profile_user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.email = email;
		this.web = web;
		this.user_pic = user_pic;
		this.birthday = birthday;
		this.gender = gender;
		this.profession = profession;
		this.home_address = home_address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.work_address = work_address;
		this.created_at = created_at;
		this.update_at = update_at;
	}

	@Override
	public String toString() {
		return "ProfileBasicModel [id=" + id + ", card_id=" + card_id + ", shareId=" + shareId + ", profile_user_id="
				+ profile_user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", mobile=" + mobile
				+ ", email=" + email + ", web=" + web + ", user_pic=" + user_pic + ", birthday=" + birthday
				+ ", gender=" + gender + ", profession=" + profession + ", home_address=" + home_address + ", city="
				+ city + ", state=" + state + ", country=" + country + ", work_address=" + work_address
				+ ", created_at=" + created_at + ", update_at=" + update_at + "]";
	}

	

	
}
