package com.specta.card.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.AchievementModel;

@Repository
@Transactional
public class AchievementDao implements IAchievementDao {
	
	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	private HttpSession session;
	
	int uid;

	@SuppressWarnings("unchecked")
	public List<AchievementModel> getAllAchievement(){
		uid = (int) session.getAttribute("uid");
		String hql= "FROM AchievementModel where userId="+uid;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public AchievementModel getAchievementById(int achId) {
		return entitymanager.find(AchievementModel.class,achId);
	}

	@Override
	public void addAchievement(AchievementModel ach) {
		System.out.println("ACH DAO");
		uid = (int) session.getAttribute("uid");
		ach.setUserId(uid);
		System.out.println("AchId: "+ach.getId());
		System.out.println("Title: "+ach.getTitle());
		System.out.println("Description: "+ach.getDescription());
		System.out.println("USerId: "+ach.getUserId());
		entitymanager.persist(ach);
	}

	@Override
	public void updateAchievement(AchievementModel ach) {
		
		System.out.println("ACH DAO");
		System.out.println("achId: "+ach.getId());
					
		AchievementModel achievementModel= getAchievementById(ach.getId());
		
		achievementModel.setTitle(ach.getTitle());
		achievementModel.setDescription(ach.getDescription());

		entitymanager.flush();
	}

	@Override
	public void deleteAchievement(int achId) {
		AchievementModel achModel = getAchievementById(achId);
		entitymanager.remove(achModel);
	}


}
