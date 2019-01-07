package com.specta.card.services;

import java.text.ParseException;
import java.util.List;

import com.specta.card.model.User;

public interface IUserService {
	
	User findByUsername(String username);
	User getUserById(int userId);
	//User getUserByEmail(String email);
	//User getUserByMobile(String mobile);
	//void createUser(User u) throws ParseException;
	boolean createUser(User u) throws ParseException;
	List<User> getAllUsers();
	//boolean UserExists(String email);
	boolean UserExists(int cardId);
	boolean checkCardId(String CardId);
	
	void updateUser(User u);
	String doLogin(String name, String pswd);
	public void deleteUser(int UserId);
	/*User getActiveUser(String UserName);
	 boolean UserExists(int id);*/


}
