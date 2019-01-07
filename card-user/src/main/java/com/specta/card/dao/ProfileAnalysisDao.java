package com.specta.card.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.ProfileAnalyasisModel;

@Repository
@Transactional
public class ProfileAnalysisDao implements IProfileAnalysisDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	private HttpSession session;

	int uid;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfileAnalyasisModel> getAllAnalyasis() {
		String hql = "FROM ProfileAnalyasisModel";
		return entitymanager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfileAnalyasisModel> getAllAnalyasisByUserId(int userId) {
		String hql = "FROM ProfileAnalyasisModel where userId=" + userId;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public ProfileAnalyasisModel getAnalyasisById(int analyasisId) {
		return entitymanager.find(ProfileAnalyasisModel.class, analyasisId);
	}

	@Override
	public void addAnalyasis(ProfileAnalyasisModel analyasis) {
		
		DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		uid = (int) session.getAttribute("uid");
		String cardId = (String) session.getAttribute("ucardid");
		analyasis.setUserId(uid);
		analyasis.setCardId(cardId);
		analyasis.setCreatedAt(dateformate.format(date));
		
		System.out.println("Analyasis: " + analyasis);
		entitymanager.persist(analyasis);
	}

	@Override
	public void updateAnalyasis(ProfileAnalyasisModel analyasis) {

	}

	@Override
	public void deleteAnalyasis(int analyasisId) {
		ProfileAnalyasisModel profileAnalyasisModel = getAnalyasisById(analyasisId);
		entitymanager.remove(profileAnalyasisModel);
	}

}
