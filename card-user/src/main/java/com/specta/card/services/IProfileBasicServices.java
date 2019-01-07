package com.specta.card.services;

import org.springframework.web.multipart.MultipartFile;

import com.specta.card.model.ProfileBasicModel;

public interface IProfileBasicServices {
	
	public void addBasicInfo(ProfileBasicModel profileBasicModel);

	public void deleteBasicInfo(Integer userid);

	public ProfileBasicModel updateBasicInfo(ProfileBasicModel profileBasicModel, MultipartFile file);

	public ProfileBasicModel getBasicInfo(int userid);
	
	ProfileBasicModel getUserByUserId(int userId);
	
	boolean existUserByUserId(int userId);

	public ProfileBasicModel updateContactInfo(ProfileBasicModel profileBasicmodel);
}
