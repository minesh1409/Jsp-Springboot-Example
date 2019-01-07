package com.specta.card.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.ExperienceModel;

@Repository
@Transactional
public class ExperienceDao implements IExperienceDao {

	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	private HttpSession session;
	
	int uid;
	
	@SuppressWarnings("unchecked")
	public List<ExperienceModel> getAllExperience(){
		uid = (int) session.getAttribute("uid");
		String hql= "FROM ExperienceModel  where userId="+uid;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public ExperienceModel getExperienceById(int expId) {
		return entitymanager.find(ExperienceModel.class, expId);
	}

	@Override
	public void addExperience(ExperienceModel exp) {
		
		System.out.println("EXP DAO");
		uid = (int) session.getAttribute("uid");
		exp.setUserId(uid);
		System.out.println("ExpId: "+exp.getId());
		System.out.println("Designation: "+exp.getExpDesignation());
		System.out.println("Company: "+exp.getExpCompany());
		System.out.println("Duration: "+exp.getExpDuration());
		System.out.println("USerId: "+exp.getUserId());
		entitymanager.persist(exp);
		
	}

	@Override
	public void updateExperience(ExperienceModel exp) {

			System.out.println("EXP DAO");
			System.out.println("expId: "+exp.getId());
						
			ExperienceModel experienceModel= getExperienceById(exp.getId());
			
			experienceModel.setExpDesignation(exp.getExpDesignation());
			experienceModel.setExpCompany(exp.getExpCompany());
			experienceModel.setExpDuration(exp.getExpDuration());
			
			entitymanager.flush();

	}

	@Override
	public void deleteExperience(int expId) {
			ExperienceModel expModel = getExperienceById(expId);
			entitymanager.remove(expModel);
	}
	
}
