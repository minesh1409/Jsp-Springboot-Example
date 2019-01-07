package com.specta.card.dao;

import java.util.List;

import com.specta.card.model.ProductEnquiryModel;

public interface IProductEnquiryDao {
	
	public List<ProductEnquiryModel> getAllEnquiry();
	
	public List<ProductEnquiryModel> getAllEnquiryByUserId(int userId);
	
	ProductEnquiryModel getEnquiryById(int enquiryId);
	
	void addEnquiry(ProductEnquiryModel enquiry);
	
	void updateEnquiry(ProductEnquiryModel enquiry);

	public void deleteEnquiry(int enquiryId);

}
