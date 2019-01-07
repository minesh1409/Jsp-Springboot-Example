package com.specta.card.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IGuestDao;

@Service
public class GuestService implements IGuestService {

	@Autowired
	IGuestDao iGuestDao;

	@Override
	public String getGuestCardId(int guestId) {
		return iGuestDao.getGuestCardId(guestId);
	}

	@Override
	public int getGuestId(String guestCardId) {
		return iGuestDao.getGuestId(guestCardId);
	}

	@Override
	public boolean checkCardRegister(String cardId) {
		return iGuestDao.checkCardRegister(cardId);
	}

}
