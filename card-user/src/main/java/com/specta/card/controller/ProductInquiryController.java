package com.specta.card.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.specta.card.model.ProductEnquiryModel;
import com.specta.card.model.ProductModel;
import com.specta.card.services.IProductEnquiryService;
import com.specta.card.services.IProductServices;

@RestController
public class ProductInquiryController {

	@Autowired
	IProductEnquiryService iProductEnquiryService;

	@Autowired
	IProductServices iProductService;

	@Autowired
	private HttpSession session;

	int uid;

	@GetMapping("/productinquiry")
	ModelAndView profileSkill(ModelAndView model) {

		uid = (int) session.getAttribute("uid");
		List<ProductModel> productList = iProductService.getAllProduct();
		List<ProductEnquiryModel> productEnquiryList = iProductEnquiryService.getAllEnquiryByUserId(uid);
		for (ProductEnquiryModel pe : productEnquiryList) {
			//System.out.println("ENQUIRY P ID : "+pe.getProductId());
			for (ProductModel p : productList) {
				if (pe.getProductId() == p.getId()) {
					//System.out.println("P NAME : "+p.getName());
					pe.setProductName(p.getName());
				}
			}
		}
		
		model.addObject("productEnquiryList", productEnquiryList);
		model.setViewName("productenquiry");
		return model;
	}

}
