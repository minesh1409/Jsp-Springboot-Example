package com.specta.card.dao;

import java.util.List;

import com.specta.card.model.EducationModel;

public interface IEducationDao {
	
	void createEducation(EducationModel edu);

	List<EducationModel> getAllEducation();

	void updateEducation(EducationModel edu);

	EducationModel getEducationById(int eduId);
	
	public void deleteEducation(int eduId);

}
