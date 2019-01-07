package com.specta.card.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.admin.dao.IAdminDao;
import com.specta.card.admin.model.AdminModel;

@Service
public class AdminService implements IAdminService{

	@Autowired
	IAdminDao iAdminDao;
	
	@Override
	public AdminModel findByUsername(String username) {
		return iAdminDao.findByUsername(username);
	}

	@Override
	public AdminModel getUserById(int userId) {
		return iAdminDao.getUserById(userId);
	}

	@Override
	public List<AdminModel> getAllUsers() {
		return iAdminDao.getAllUsers();
	}

	@Override
	public boolean UserExists(String userName) {		
		return iAdminDao.UserExists(userName);
	}

	@Override
	public void updateUser(AdminModel u) {	
		iAdminDao.updateUser(u);
	}

	@Override
	public String doLogin(String name, String pswd) {
		return iAdminDao.doLogin(name, pswd);
	}

	@Override
	public void deleteUser(int UserId) {	
		iAdminDao.deleteUser(UserId);
	}

}
