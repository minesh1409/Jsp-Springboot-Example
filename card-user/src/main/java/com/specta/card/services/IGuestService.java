package com.specta.card.services;

public interface IGuestService {
	
	String getGuestCardId(int guestId);
	int getGuestId(String guestCardId); 
	boolean checkCardRegister(String cardId);
}
