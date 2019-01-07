package com.specta.card.services;

import java.util.List;

import com.specta.card.model.AchievementModel;

public interface IAchievementservice {

	List<AchievementModel> getAllAchievement();
	
	AchievementModel getAchievementById(int achId);
	
	boolean addAchievement(AchievementModel ach);
	
	void updateAchievement(AchievementModel ach);

	public void deleteAchievement(int achId);

	
}
