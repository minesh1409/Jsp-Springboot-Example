package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IExperienceDao;
import com.specta.card.model.ExperienceModel;

@Service
public class ExperienceService implements IExperienceService {
	
	@Autowired
	IExperienceDao iExperienceDao;

	@Override
	public List<ExperienceModel> getAllExperience() {
		return iExperienceDao.getAllExperience();
	}

	@Override
	public ExperienceModel getExperienceById(int expId) {
		return iExperienceDao.getExperienceById(expId);
	}

	@Override
	public boolean addExperience(ExperienceModel exp) {
		iExperienceDao.addExperience(exp);
		return true;
	}

	@Override
	public void updateExperience(ExperienceModel exp) {
		iExperienceDao.updateExperience(exp);
	}

	@Override
	public void deleteExperience(int expId) {
		iExperienceDao.deleteExperience(expId);
	}
	
	

}
