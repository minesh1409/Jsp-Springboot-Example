package com.specta.card.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.SocialModel;

@Repository
@Transactional
public class SocialDao implements ISocialDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	private HttpSession session;

	int uid;

	@SuppressWarnings("unchecked")
	@Override
	public List<SocialModel> getAllSocial() {
		uid = (int) session.getAttribute("uid");
		String hql = "FROM SocialModel where userId="+uid;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public SocialModel getSocialById(int socialId) {
		return entitymanager.find(SocialModel.class, socialId);
	}

	@Override
	public void addSocial(SocialModel social) {
		System.out.println("SOCIAL DAO");
		uid = (int) session.getAttribute("uid");
		social.setUserId(uid);
		System.out.println("SocialId: "+social.getId());
		System.out.println("Social Name: "+social.getSocialName());
		System.out.println("Social Url: "+social.getSocialLink());
		System.out.println("USerId: "+social.getUserId());
		entitymanager.persist(social);

	}

	@Override
	public void updateSocial(SocialModel social) {
		System.out.println("Social DAO");
		System.out.println("socialId: "+social.getId());
					
		SocialModel socialModel= getSocialById(social.getId());
		
		socialModel.setSocialName(social.getSocialName());
		socialModel.setSocialLink(social.getSocialLink());
				
		entitymanager.flush();
	}

	@Override
	public void deleteSocial(int socialId) {
		SocialModel socialModel = getSocialById(socialId);
		entitymanager.remove(socialModel);
	}

}
