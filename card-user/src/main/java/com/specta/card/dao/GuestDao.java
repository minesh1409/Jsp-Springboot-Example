package com.specta.card.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.User;

@Repository
@Transactional
public class GuestDao implements IGuestDao{
	
	@Autowired
	private EntityManager entitymanager;

	@Override
	public String getGuestCardId(int guestId) {	
		System.out.println("");
		System.out.println("GUESt DAO");
		System.out.println("DAO GUEST ID: "+guestId);
		User results = null;		
		TypedQuery<User> qry = entitymanager.createQuery("FROM User as u where u.id ="+guestId,User.class);
		results = qry.getSingleResult();
		String cardId = results.getCardId();	
		
		System.out.println("DAO GUEST CARDID: "+cardId);
		return cardId;
	}

	@Override
	public int getGuestId(String guestCardId) {
		
		System.out.println("");
		System.out.println("GUESt DAO");
		System.out.println("DAO GUEST CARDID: "+guestCardId);
		User results = null;		
		TypedQuery<User> qry = entitymanager.createQuery("FROM User as u where u.cardId ='"+guestCardId+"'",User.class);
		results = qry.getSingleResult();
		int guestId = results.getId();	
		System.out.println("DAO GUEST ID: "+guestId);
		
		return guestId;
	}
	

	@Override
	public boolean checkCardRegister(String cardId) {
		String hql = "FROM CardIdModel as cm WHERE cm.cardId = ? and cm.status = 'active'";
		int count = entitymanager.createQuery(hql).setParameter(0, cardId).getResultList().size();
		return count > 0 ? true : false;
	}

	
}
