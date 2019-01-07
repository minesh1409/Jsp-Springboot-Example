package com.specta.card.admin.dao;

import java.util.List;

import com.specta.card.admin.model.GenerateCardIdModel;

public interface IGenerateCardIdDao {
	
	List<GenerateCardIdModel> getAllCardId();

	List<GenerateCardIdModel> getAllCardIdByUserId(int userId);

	GenerateCardIdModel getCardIdById(int cId);

	void addCardId(GenerateCardIdModel cardIdModel);
	void addCardId(GenerateCardIdModel cardIdModel, int num);

	void updateCardID(GenerateCardIdModel cardIdModel);

	void deleteCardId(int cId);
	void deleteNullCardId();

}
