package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.ISocialDao;
import com.specta.card.model.SocialModel;

@Service
public class SocialService implements ISocialService {
	
	@Autowired
	ISocialDao iSocialDao;

	@Override
	public List<SocialModel> getAllSocial() {
		return iSocialDao.getAllSocial();
	}

	@Override
	public SocialModel getSocialById(int socialId) {
		return iSocialDao.getSocialById(socialId);
	}

	@Override
	public boolean addSocial(SocialModel social) {
		iSocialDao.addSocial(social);
		return true;
	}

	@Override
	public void updateSocial(SocialModel social) {
		iSocialDao.updateSocial(social);
	}

	@Override
	public void deleteSocial(int socialId) {
		iSocialDao.deleteSocial(socialId);
	}

}
