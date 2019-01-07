package com.specta.card.services;

import java.util.List;

import com.specta.card.model.SocialModel;

public interface ISocialService {

	List<SocialModel> getAllSocial();

	SocialModel getSocialById(int socialId);

	boolean addSocial(SocialModel social);

	void updateSocial(SocialModel social);

	public void deleteSocial(int socialId);

}
