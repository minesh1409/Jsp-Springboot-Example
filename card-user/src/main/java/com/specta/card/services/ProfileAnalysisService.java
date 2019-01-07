package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IProfileAnalysisDao;
import com.specta.card.model.ProfileAnalyasisModel;

@Service
public class ProfileAnalysisService implements IProfileAnalysisService {
	
	@Autowired
	IProfileAnalysisDao iProfileAnalysisDao;

	@Override
	public List<ProfileAnalyasisModel> getAllAnalyasis() {
		
		return iProfileAnalysisDao.getAllAnalyasis();
	}

	@Override
	public List<ProfileAnalyasisModel> getAllAnalyasisByUserId(int userId) {
		
		return iProfileAnalysisDao.getAllAnalyasisByUserId(userId);
	}

	@Override
	public ProfileAnalyasisModel getAnalyasisById(int analyasisId) {
		
		return iProfileAnalysisDao.getAnalyasisById(analyasisId);
	}

	@Override
	public boolean addAnalyasis(ProfileAnalyasisModel analyasis) {
		iProfileAnalysisDao.addAnalyasis(analyasis);
		return true;
	}

	@Override
	public void updateAnalyasis(ProfileAnalyasisModel analyasis) {
		iProfileAnalysisDao.updateAnalyasis(analyasis);
	}

	@Override
	public void deleteAnalyasis(int analyasisId) {
		iProfileAnalysisDao.deleteAnalyasis(analyasisId);
	}

}
