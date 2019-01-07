package com.specta.card.services;

import java.util.List;

import com.specta.card.model.ProfileAnalyasisModel;

public interface IProfileAnalysisService {

	public List<ProfileAnalyasisModel> getAllAnalyasis();

	public List<ProfileAnalyasisModel> getAllAnalyasisByUserId(int userId);

	ProfileAnalyasisModel getAnalyasisById(int analyasisId);

	boolean addAnalyasis(ProfileAnalyasisModel analyasis);

	void updateAnalyasis(ProfileAnalyasisModel analyasis);

	public void deleteAnalyasis(int analyasisId);

}
