package com.specta.card.services;

import java.util.List;

import com.specta.card.model.ExperienceModel;

public interface IExperienceService {

	List<ExperienceModel> getAllExperience();

	ExperienceModel getExperienceById(int expId);

	boolean addExperience(ExperienceModel exp);

	void updateExperience(ExperienceModel exp);

	public void deleteExperience(int expId);
}
