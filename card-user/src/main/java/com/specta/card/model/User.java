package com.specta.card.model;


import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
@Scope("session")
public class User implements Serializable {
	
    private int id;
    //private int cardId;
    private String cardId;
    private String userName;
    private String password;
    //private long mobile;
    private String mobile;
    private String created_at;
    private String updated_at;
    private Set<Role> roles;
    
/*    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private ProfileBasicModel profileBasicModel;
       

    public ProfileBasicModel getProfileBasicModel() {
		return profileBasicModel;
	}

	public void setProfileBasicModel(ProfileBasicModel profileBasicModel) {
		this.profileBasicModel = profileBasicModel;
	}*/

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    /*public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}*/
    
    public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /*public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}*/
    
    public String getMobile() {
		return mobile;
	}
    public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	@ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public User() {
		super();
	}

	public User(int id) {
		super();
		this.id = id;
	}

/*	public User(int id, int cardId, String userName, String password, long mobile, String created_at, String updated_at,
			Set<Role> roles) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.roles = roles;
	}*/
	
	public User(int id, String cardId, String userName, String password, String mobile, String created_at, String updated_at,
			Set<Role> roles) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.roles = roles;
	}
	

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", cardId=" + cardId + ", userName=" + userName + ", password=" + password
				+ ", mobile=" + mobile + ", created_at=" + created_at + ", updated_at=" + updated_at + ", roles="
				+ roles + "]";
	}

	
}
