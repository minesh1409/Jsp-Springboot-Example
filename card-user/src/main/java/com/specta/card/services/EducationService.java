package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IEducationDao;
import com.specta.card.model.EducationModel;

@Service
public class EducationService implements IEducationSecvice{

	@Autowired
	IEducationDao iEducationDao;

	@Override
	public List<EducationModel> getAllEducation() {
		return iEducationDao.getAllEducation();
	}
	
	@Override
	public EducationModel getEducationById(int eduId) {
		return iEducationDao.getEducationById(eduId);
	}

	@Override
	public boolean createEducation(EducationModel edu) {
		iEducationDao.createEducation(edu);
		return true;
	}
	
	@Override
	public void updateEducation(EducationModel edu) {
		iEducationDao.updateEducation(edu);		
	}


	@Override
	public void deleteEducation(int eduId) {
		iEducationDao.deleteEducation(eduId);		
	}

}
