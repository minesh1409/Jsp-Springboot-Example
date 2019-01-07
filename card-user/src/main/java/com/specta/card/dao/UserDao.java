package com.specta.card.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.specta.card.model.CardIdModel;
import com.specta.card.model.ExperienceModel;
import com.specta.card.model.User;

@Transactional
@Repository
public class UserDao implements IUserDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	 @Autowired 
	 private HttpSession session;   //store session

	@Override
	public User getUserById(int userId) {
		return entitymanager.find(User.class, userId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User";
		return entitymanager.createQuery(hql).getResultList();
	}
	
	@Override
	public User findByUsername(String username) {
		return entitymanager.find(User.class, username);
	}

	@Override
	public boolean UserExists(int cardId) {
		String hql = "FROM User as u WHERE u.email = ? ";
		int count = entitymanager.createQuery(hql).setParameter(1, cardId).getResultList().size();
		return count > 0 ? true : false;
	}
	
	public boolean checkCardId(String CardId) {
		String hql = "FROM CardIdModel as cm WHERE cm.cardId = ? and cm.status = 'inactive'";
		int count = entitymanager.createQuery(hql).setParameter(0, CardId).getResultList().size();
		return count > 0 ? true : false;
		
	}

	@Override
	public void createUser(User u) throws ParseException {
		//String cardid = u.getCardId();
		
		DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		/*System.out.println("Card Id is :: " + cardid);
		System.out.println("User is :: " + u.getUserName());
		System.out.println("Pass is :: " + u.getPassword());
		System.out.println("Mob is :: " + u.getMobile());*/
		u.setCreated_at(dateformate.format(date));
		/*System.out.println("Create is :: " + u.getCreated_at());
		System.out.println("Role is :: " + u.getRoles());*/
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		System.out.println("Encrypted Password" + bCryptPasswordEncoder.encode(u.getPassword()));
		System.out.println(u);
		updateCardStatus(u.getCardId(),u.getMobile());
		entitymanager.persist(u);
		
	}

	@Override
	public void updateUser(User u) {
		System.out.println("User ID IS ::: " + u.getId());
		User user = getUserById(u.getId());
		user.setUserName(u.getUserName());
		entitymanager.flush();
	}
	
	@SuppressWarnings("null")
	public String doLogin(String name, String pswd) {
		User results = null;
		String msg = null;
		try {
			System.out.println("Login name :: " + name);
			System.out.println("Login Password :: " + pswd);
			TypedQuery<User> qry = entitymanager.createQuery("FROM User as u where u.userName = '"+name +"'",User.class);
			results = qry.getSingleResult();
			String st = results.getPassword();
			
			
			if (bCryptPasswordEncoder.matches(pswd, st)) {
				System.out.println(bCryptPasswordEncoder.matches(pswd, st));
				System.out.println("Password Matches......!!!");
				msg = "Success";
				session.setAttribute("uid", results.getId());
				session.setAttribute("uname", results.getUserName());
				session.setAttribute("ucardid", results.getCardId());
				session.setAttribute("umobile", results.getMobile());				
				//System.out.println("USer id : "+session.getAttribute("uid"));				
			} else {
				System.out.println("User Not Match...");
				msg = "Fail";
			}
		} catch (Exception e) {
			System.out.println("Catch:"+msg);
			msg="Notfound";
			e.printStackTrace();
		}
		return msg;	
	}

	@Override
	public void deleteUser(int userId) {
		User user = getUserById(userId);
		entitymanager.remove(user);

	}
	
	public void updatecardIdStatus() {
		entitymanager.flush();
}
	
	public int getGenCardId(String CardId) {
		System.out.println("CARDID: ");
		CardIdModel results = null;		
		TypedQuery<CardIdModel> qry = entitymanager.createQuery("FROM CardIdModel as cm where cm.cardId ='"+CardId+"'",CardIdModel.class);
		results = qry.getSingleResult();
		int genCardId = results.getId();	
		System.out.println("Generate Card ID: "+genCardId);
		return genCardId;
	}
	
	void updateCardStatus(String CardId,String mobile) {
		DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int genCardId = getGenCardId(CardId);
		System.out.println(genCardId);
		
		CardIdModel cardIdModel = entitymanager.find(CardIdModel.class, genCardId);  
		cardIdModel.setMobile(mobile);
		cardIdModel.setStatus("active");
		cardIdModel.setUpdatedAt(dateformate.format(date));
		System.out.println(cardIdModel);
		entitymanager.flush();
	}

}
