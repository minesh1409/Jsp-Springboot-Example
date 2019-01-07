package com.specta.card.dao;

public interface IGuestDao {
	
	String getGuestCardId(int guestId); 
	int getGuestId(String guestCardId);
	boolean checkCardRegister(String cardId);

}
