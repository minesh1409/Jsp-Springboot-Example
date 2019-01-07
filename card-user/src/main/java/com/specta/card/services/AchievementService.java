package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IAchievementDao;
import com.specta.card.model.AchievementModel;

@Service
public class AchievementService implements IAchievementservice {
	
	@Autowired
	IAchievementDao iAchievementDao;

	@Override
	public List<AchievementModel> getAllAchievement() {
		return iAchievementDao.getAllAchievement();
	}

	@Override
	public AchievementModel getAchievementById(int achId) {
		return iAchievementDao.getAchievementById(achId) ;
	}

	@Override
	public boolean addAchievement(AchievementModel ach) {
		iAchievementDao.addAchievement(ach);
		return true;
	}

	@Override
	public void updateAchievement(AchievementModel ach) {
		iAchievementDao.updateAchievement(ach);
	}

	@Override
	public void deleteAchievement(int achId) {
		iAchievementDao.deleteAchievement(achId);		
	}
	
}
