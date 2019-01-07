package com.specta.card.admin.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.admin.model.GenerateCardIdModel;

@Repository
@Transactional
public class GenerateCardIdDao implements IGenerateCardIdDao {

	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<GenerateCardIdModel> getAllCardId() {
		String hql = "FROM GenerateCardIdModel";
		return entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GenerateCardIdModel> getAllCardIdByUserId(int userId) {
		String hql = "FROM GenerateCardIdModel where id=" + userId;
		return entityManager.createQuery(hql).getResultList();
	}

	@Override
	public GenerateCardIdModel getCardIdById(int cId) {
		return entityManager.find(GenerateCardIdModel.class, cId);
	}

	@Override
	@Transactional
	public void addCardId(GenerateCardIdModel cardIdModel) {
		DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		RandomString gen = new RandomString(6, ThreadLocalRandom.current());
		String cardId = String.valueOf(gen);
		
		cardIdModel.setCardId(cardId);
		cardIdModel.setCardLink("http://localhost:8080/" + cardId);
		cardIdModel.setStatus("inactive");
		cardIdModel.setCreatedAt(dateformate.format(date));
		System.out.println("Card id: " + cardIdModel);

		if(!checkCardId(cardId)) {
			entityManager.persist(cardIdModel);
		}else{
			System.out.println("Not Insert");
		}
		
	}

	@Override
	public void addCardId(GenerateCardIdModel cardIdModel, int num) {
		System.out.println("Card id: " + num);
		// entityManager.persist(cardIdModel);
	}

	@Override
	public void updateCardID(GenerateCardIdModel cardIdModel) {
	}

	@Override
	public void deleteCardId(int cId) {
		GenerateCardIdModel cardIdModel = getCardIdById(cId);
		entityManager.remove(cardIdModel);
	}

	public boolean checkCardId(String CardId) {
		String hql = "FROM GenerateCardIdModel as g WHERE g.cardId = ? ";
		int count = entityManager.createQuery(hql).setParameter(0, CardId).getResultList().size();
		return count > 0 ? true : false;
		
	}
	
	public void deleteNullCardId() {
		int deletedCount = entityManager.createQuery("DELETE FROM GenerateCardIdModel where cardId="+null).executeUpdate();
		//System.out.println("Del Count" + deletedCount);
	}

}
