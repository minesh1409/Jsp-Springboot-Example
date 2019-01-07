package com.specta.card.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.SkillModel;

@Repository
@Transactional
public class SkillDao implements ISkillDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	private HttpSession session;

	int uid;

	@SuppressWarnings("unchecked")
	@Override
	public List<SkillModel> getAllSkill() {
		uid = (int) session.getAttribute("uid");
		String hql = "FROM SkillModel  where userId="+uid;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public SkillModel getSkillById(int skillId) {
		return entitymanager.find(SkillModel.class, skillId);
	}

	@Override
	public void addSkill(SkillModel skill) {
		System.out.println("SKILL DAO");
		uid = (int) session.getAttribute("uid");
		skill.setUserId(uid);
		System.out.println("AchId: " + skill.getId());
		System.out.println("Title: " + skill.getSkillName());
		System.out.println("Description: " + skill.getSkillValue());
		System.out.println("USerId: " + skill.getUserId());
		entitymanager.persist(skill);
	}

	@Override
	public void updateSkill(SkillModel skill) {
		
		System.out.println("SKILL DAO");
		System.out.println("skillId: "+skill.getId());
					
		SkillModel skillModel= getSkillById(skill.getId());
		
		skillModel.setSkillName(skill.getSkillName());
		skillModel.setSkillValue(skill.getSkillValue());
				
		entitymanager.flush();
	}

	@Override
	public void deleteSkill(int skillId) {
		SkillModel skillModel = getSkillById(skillId);
		entitymanager.remove(skillModel);
	}

}
