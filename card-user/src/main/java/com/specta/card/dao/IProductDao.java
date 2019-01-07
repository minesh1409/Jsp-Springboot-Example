package com.specta.card.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.specta.card.model.ProductModel;

public interface IProductDao {

	public List<ProductModel> getAllProduct();

	ProductModel getProductById(int productId);

	void addProduct(ProductModel product, MultipartFile file);

	void updateProduct(ProductModel product, MultipartFile file);

	public void deleteProduct(int productId);
	
}
