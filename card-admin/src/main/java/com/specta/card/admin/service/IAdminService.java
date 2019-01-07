package com.specta.card.admin.service;

import java.util.List;

import com.specta.card.admin.model.AdminModel;

public interface IAdminService {
	
	AdminModel findByUsername(String username);
	AdminModel getUserById(int userId);
	List<AdminModel> getAllUsers();
	boolean UserExists(String userName);
	void updateUser(AdminModel u);
	String doLogin(String name, String pswd);
	void deleteUser(int UserId);

}
