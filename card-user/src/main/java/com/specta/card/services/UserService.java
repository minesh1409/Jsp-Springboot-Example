package com.specta.card.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IUserDao;
import com.specta.card.model.User;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userdao;

	@Override
	public boolean createUser(User u) throws ParseException {
		userdao.createUser(u);
		return true;
	}

	@Override
	public User getUserById(int id) {
		return userdao.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}

	@Override
	public void updateUser(User u) {
		userdao.updateUser(u);
	}

	@Override
	public void deleteUser(int UserId) {
		userdao.deleteUser(UserId);
	}

	@Override
	public String doLogin(String name, String pswd) {
		return userdao.doLogin(name, pswd);
		
	}

	@Override
	public User findByUsername(String username) {
		return null;
	}

	@Override
	public boolean UserExists(int cardId) {
		return false;
	}

	@Override
	public boolean checkCardId(String CardId) {
		return userdao.checkCardId(CardId);
	}
	

}
