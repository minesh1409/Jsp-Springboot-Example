package com.specta.card.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.EducationModel;

@Transactional
@Repository
public class EducationDao implements IEducationDao {
	
	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	private HttpSession session;
	
	int uid;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EducationModel> getAllEducation() {
		uid = (int) session.getAttribute("uid");
		String hql = "FROM EducationModel where userId="+uid ;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public EducationModel getEducationById(int eduId) {
		return entitymanager.find(EducationModel.class, eduId);
	}
	

	@Override
	public void createEducation(EducationModel edu) {
		System.out.println("EDU DAO");
		uid = (int) session.getAttribute("uid");
		edu.setUserId(uid);
		System.out.println("eduId: "+edu.getId());
		System.out.println("Degree: "+edu.getDegree());
		System.out.println("University: "+edu.getUniversity());
		System.out.println("Passingyear: "+edu.getPassingYear());
		System.out.println("USerId: "+edu.getUserId());
		entitymanager.persist(edu);
	}
	
	@Override
	public void updateEducation(EducationModel edu) {
		System.out.println("EDU DAO");
		System.out.println("eduId: "+edu.getId());
		
		DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		EducationModel educationModel= getEducationById(edu.getId());
		
		educationModel.setDegree(edu.getDegree());
		educationModel.setUniversity(edu.getUniversity());
		educationModel.setPassingYear(edu.getPassingYear());
		
		entitymanager.flush();
	}

	@Override
	public void deleteEducation(int eduId) {
		EducationModel eduModel = getEducationById(eduId);
		entitymanager.remove(eduModel);
	}
	
	
	/*String hql = "select u FROM Advertisement as u ORDER BY u.listing_id DESC";
	System.out.println(hql);
	TypedQuery<Advertisement> qry = entitymanager.createQuery(hql, Advertisement.class);
	result = qry.setMaxResults(1).getSingleResult();
	System.out.println("Listing id :: " + result.getListing_id());*/

}
