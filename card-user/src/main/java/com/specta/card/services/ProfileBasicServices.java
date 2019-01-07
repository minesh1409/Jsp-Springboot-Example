package com.specta.card.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.specta.card.dao.IProfileBasicDao;
import com.specta.card.model.ProfileBasicModel;

@Service
public class ProfileBasicServices implements IProfileBasicServices {
	
	@Autowired
	private IProfileBasicDao iProfileBasicDao;

	@Override
	public void addBasicInfo(ProfileBasicModel profileBasicModel) {
		iProfileBasicDao.addBasicInfo(profileBasicModel);
	}

	@Override
	public void deleteBasicInfo(Integer userid) {
		
	}

	@Override
	public ProfileBasicModel updateBasicInfo(ProfileBasicModel profileBasicModel, MultipartFile file) {
		return iProfileBasicDao.updateBasicInfo(profileBasicModel, file);
	}
	
	@Override
	public ProfileBasicModel updateContactInfo(ProfileBasicModel profileBasicmodel) {
		return iProfileBasicDao.updateContactInfo(profileBasicmodel);
	}

	@Override
	public ProfileBasicModel getBasicInfo(int userid) {
		return iProfileBasicDao.getBasicInfo(userid);
	}

	@Override
	public boolean existUserByUserId(int userId) {
		return iProfileBasicDao.existUserByUserId(userId);
	}

	@Override
	public ProfileBasicModel getUserByUserId(int userId) {
		return iProfileBasicDao.getUserByUserId(userId);
	}

}
