package com.specta.card.admin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name="admin_profile")
/*@Scope("session")*/
public class AdminModel {
		
		@Id
	 	private int id;
	    private String userName;
	    private String password;
	    private String mobile;
	    private String created_at;
	    private String updated_at;
	    
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
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
		
		
		
		public AdminModel() {
			super();
		}
		
		public AdminModel(int id) {
			super();
			this.id = id;
		}
		
		public AdminModel(int id, String userName, String password, String mobile, String created_at,
				String updated_at) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.mobile = mobile;
			this.created_at = created_at;
			this.updated_at = updated_at;
		}
		
		
		@Override
		public String toString() {
			return "AdminModel [id=" + id + ", userName=" + userName + ", password=" + password + ", mobile=" + mobile
					+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
		}
	    
	
}
