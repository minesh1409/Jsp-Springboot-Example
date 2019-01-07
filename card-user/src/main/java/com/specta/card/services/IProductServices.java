package com.specta.card.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.specta.card.model.ProductModel;

public interface IProductServices {
	
	List<ProductModel> getAllProduct();

	ProductModel getProductById(int productId);

	boolean addProduct(ProductModel product,MultipartFile file);

	void updateProduct(ProductModel product, MultipartFile file);

	public void deleteProduct(int productId);
}
