package com.specta.card.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.specta.card.admin.model.AdminModel;

@Repository
@Transactional
public class AdminDao implements IAdminDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private HttpSession session;

	@Override
	public AdminModel findByUsername(String username) {
		return entitymanager.find(AdminModel.class, username);
	}

	@Override
	public AdminModel getUserById(int userId) {
		return entitymanager.find(AdminModel.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminModel> getAllUsers() {
		String hql = "FROM AdminModel";
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public boolean UserExists(String userName) {
		String hql = "FROM AdminModel as u WHERE u.name = ? ";
		int count = entitymanager.createQuery(hql).setParameter(1, userName).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public void updateUser(AdminModel u) {
		AdminModel adminModel = getUserById(u.getId());
		adminModel.setUserName(u.getUserName());
		adminModel.setUserName(u.getPassword());
		entitymanager.flush();
	}

	@Override
	public String doLogin(String name, String pswd) {
		AdminModel results = null;
		String msg = null;
		try {

			TypedQuery<AdminModel> qry = entitymanager
					.createQuery("FROM AdminModel as u where u.userName = '" + name + "'", AdminModel.class);
			results = qry.getSingleResult();
			String st = results.getPassword();

			if (bCryptPasswordEncoder.matches(pswd, st)) {
				System.out.println(bCryptPasswordEncoder.matches(pswd, st));
				System.out.println("User Match...");
				msg = "Success";

			} else {
				System.out.println("User Not Match...");
				msg = "Fail";
			}
		} catch (Exception e) {
			System.out.println("Catch:" + msg);
			msg = "Notfound";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public void deleteUser(int UserId) {
		AdminModel adminModel = getUserById(UserId);
		entitymanager.remove(adminModel);
	}

}
