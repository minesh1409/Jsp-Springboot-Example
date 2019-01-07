package com.specta.card.dao;

import java.util.List;

import com.specta.card.model.ProfileAnalyasisModel;

public interface IProfileAnalysisDao {

	public List<ProfileAnalyasisModel> getAllAnalyasis();

	public List<ProfileAnalyasisModel> getAllAnalyasisByUserId(int userId);

	ProfileAnalyasisModel getAnalyasisById(int analyasisId);

	void addAnalyasis(ProfileAnalyasisModel analyasis);

	void updateAnalyasis(ProfileAnalyasisModel analyasis);

	public void deleteAnalyasis(int analyasisId);

}
