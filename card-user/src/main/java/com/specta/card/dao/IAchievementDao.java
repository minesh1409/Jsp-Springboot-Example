package com.specta.card.dao;

import java.util.List;

import com.specta.card.model.AchievementModel;

public interface IAchievementDao {
	
	public List<AchievementModel> getAllAchievement();
	
	AchievementModel getAchievementById(int achId);
	
	void addAchievement(AchievementModel ach);
	
	void updateAchievement(AchievementModel ach);

	public void deleteAchievement(int achId);

}
