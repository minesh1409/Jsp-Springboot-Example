package com.specta.card.dao;

import java.util.List;

import com.specta.card.model.ExperienceModel;

public interface IExperienceDao {

	public List<ExperienceModel> getAllExperience();

	ExperienceModel getExperienceById(int expId);

	void addExperience(ExperienceModel exp);

	void updateExperience(ExperienceModel exp);

	public void deleteExperience(int expId);

}
