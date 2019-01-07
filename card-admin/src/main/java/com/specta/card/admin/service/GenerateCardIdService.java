package com.specta.card.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.admin.dao.IGenerateCardIdDao;
import com.specta.card.admin.model.GenerateCardIdModel;

@Service
public class GenerateCardIdService implements IGenerateCardIdService {

	@Autowired
	IGenerateCardIdDao iGenerateCardIdDao;

	@Override
	public List<GenerateCardIdModel> getAllCardId() {		
		return iGenerateCardIdDao.getAllCardId();
	}

	@Override
	public List<GenerateCardIdModel> getAllCardIdByUserId(int userId) {
		return iGenerateCardIdDao.getAllCardIdByUserId(userId);
	}

	@Override
	public GenerateCardIdModel getCardIdById(int cId) {
		return iGenerateCardIdDao.getCardIdById(cId);
	}

	@Override
	public boolean addCardId(GenerateCardIdModel cardIdModel) {
		iGenerateCardIdDao.addCardId(cardIdModel);
		return false;
	}
	@Override
	public boolean addCardId(GenerateCardIdModel cardIdModel, int num) {
		iGenerateCardIdDao.addCardId(cardIdModel, num);
		return false;
	}

	@Override
	public void updateCardID(GenerateCardIdModel cardIdModel) {
		iGenerateCardIdDao.updateCardID(cardIdModel);
	}

	@Override
	public void deleteCardId(int cardId) {
		iGenerateCardIdDao.deleteCardId(cardId);
	}

	@Override
	public void deleteNullCardId() {
		iGenerateCardIdDao.deleteNullCardId();
	}
	
}
