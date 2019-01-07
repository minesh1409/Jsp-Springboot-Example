package com.specta.card.dao;

import java.util.List;

import com.specta.card.model.SocialModel;

public interface ISocialDao {

	public List<SocialModel> getAllSocial();

	SocialModel getSocialById(int socialId);

	void addSocial(SocialModel social);

	void updateSocial(SocialModel social);

	public void deleteSocial(int socialId);

}
