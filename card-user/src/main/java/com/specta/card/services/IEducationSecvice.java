package com.specta.card.services;

import java.util.List;

import com.specta.card.model.EducationModel;

public interface IEducationSecvice {
	
	boolean createEducation(EducationModel edu);

	List<EducationModel> getAllEducation();

	void updateEducation(EducationModel edu);

	EducationModel getEducationById(int eduId);
	
	public void deleteEducation(int eduId);

}
