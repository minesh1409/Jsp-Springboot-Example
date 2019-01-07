package com.specta.card.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.EducationModel;
import com.specta.card.model.ProductEnquiryModel;

@Repository
@Transactional
public class ProductEnquiryDao  implements IProductEnquiryDao{
	
	@Autowired
	EntityManager entitymanager;
	
	@Autowired
	private HttpSession session;
	
	int uid;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEnquiryModel> getAllEnquiry() {
		
		String hql = "FROM ProductEnquiryModel";
		return entitymanager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEnquiryModel> getAllEnquiryByUserId(int userId) {
		
		String hql = "FROM ProductEnquiryModel where userId="+userId ;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public ProductEnquiryModel getEnquiryById(int enquiryId) {
		return entitymanager.find(ProductEnquiryModel.class, enquiryId);
	}

	@Override
	public void addEnquiry(ProductEnquiryModel enquiry) {
		
		System.out.println("Enquery: "+enquiry);
		
		entitymanager.persist(enquiry);
	}

	@Override
	public void updateEnquiry(ProductEnquiryModel enquiry) {
		
	}

	@Override
	public void deleteEnquiry(int enquiryId) {
		ProductEnquiryModel productEnquiryModel = getEnquiryById(enquiryId);
		entitymanager.remove(productEnquiryModel);
	}

}
