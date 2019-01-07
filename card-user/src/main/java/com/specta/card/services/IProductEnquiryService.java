package com.specta.card.services;

import java.util.List;

import com.specta.card.model.ProductEnquiryModel;

public interface IProductEnquiryService {

	public List<ProductEnquiryModel> getAllEnquiry();
	
	public List<ProductEnquiryModel> getAllEnquiryByUserId(int userId);
	
	ProductEnquiryModel getEnquiryById(int enquiryId);
	
	boolean addEnquiry(ProductEnquiryModel enquiry);
	
	void updateEnquiry(ProductEnquiryModel enquiry);

	public void deleteEnquiry(int enquiryId);
	
}
