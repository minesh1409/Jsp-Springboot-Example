package com.specta.card.admin.service;

import java.util.List;

import com.specta.card.admin.model.GenerateCardIdModel;

public interface IGenerateCardIdService {

	List<GenerateCardIdModel> getAllCardId();

	List<GenerateCardIdModel> getAllCardIdByUserId(int userId);

	GenerateCardIdModel getCardIdById(int cId);

	boolean addCardId(GenerateCardIdModel cardIdModel);
	boolean addCardId(GenerateCardIdModel cardIdModel,int num);

	void updateCardID(GenerateCardIdModel cardIdModel);

	void deleteCardId(int cardId);
	void deleteNullCardId();

}
