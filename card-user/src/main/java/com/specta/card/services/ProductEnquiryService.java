package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IProductEnquiryDao;
import com.specta.card.model.ProductEnquiryModel;

@Service
public class ProductEnquiryService implements IProductEnquiryService{
	
	@Autowired
	IProductEnquiryDao iProductEnquiryDao;

	@Override
	public List<ProductEnquiryModel> getAllEnquiry() {
		return iProductEnquiryDao.getAllEnquiry();
	}

	@Override
	public List<ProductEnquiryModel> getAllEnquiryByUserId(int userId) {
		return iProductEnquiryDao.getAllEnquiryByUserId(userId);
	}

	@Override
	public ProductEnquiryModel getEnquiryById(int enquiryId) {
		return iProductEnquiryDao.getEnquiryById(enquiryId);
	}

	@Override
	public boolean addEnquiry(ProductEnquiryModel enquiry) {
		iProductEnquiryDao.addEnquiry(enquiry);
		return true;
	}

	@Override
	public void updateEnquiry(ProductEnquiryModel enquiry) {
		iProductEnquiryDao.updateEnquiry(enquiry);
	}

	@Override
	public void deleteEnquiry(int enquiryId) {
		iProductEnquiryDao.deleteEnquiry(enquiryId);
	}
	

}
