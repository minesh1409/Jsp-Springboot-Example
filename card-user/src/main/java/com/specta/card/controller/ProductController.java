package com.specta.card.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.specta.card.model.ProductModel;
import com.specta.card.model.ProfileBasicModel;
import com.specta.card.model.SocialModel;
import com.specta.card.services.IProductServices;

@RestController
public class ProductController {
	
	@Autowired
	IProductServices iProductServices;
	
	@Autowired
	private HttpSession session;
	int uid;	
	
	@Autowired
	ServletContext servletContext;
	
	
	@GetMapping("/product")
	ModelAndView getAllProduct(ModelAndView model) {

		List<ProductModel> productList = iProductServices.getAllProduct();
		model.addObject("productList", productList);
		model.addObject("productModel", new ProductModel());
		model.setViewName("product");
		return model;
	}
	
	@PostMapping("/addproduct")
	public ModelAndView addProduct(@ModelAttribute ProductModel productModel,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		iProductServices.addProduct(productModel ,file);
		
		return new ModelAndView("redirect:/product");
		
	}
	
	@GetMapping(value = "/editproduct/{id}")
	public ProductModel EditProduct(@PathVariable("id") int productId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		ProductModel productModel = new ProductModel();
		productModel = iProductServices.getProductById(productId);
		return productModel;
	}
	@PostMapping(value = "/updateproduct/{id}")
	public ModelAndView updateProduct(@PathVariable("id") int productId,@ModelAttribute ProductModel productModel, @RequestParam("file") MultipartFile file) {

		productModel.setId(productId);
		iProductServices.updateProduct(productModel ,file);
		return  new ModelAndView("redirect:/product");
		
	}
	
	@GetMapping("/deleteproduct/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int productId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		iProductServices.deleteProduct(productId);;
		return new ModelAndView("redirect:/product");
	}

}
