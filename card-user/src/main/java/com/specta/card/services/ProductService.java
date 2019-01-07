package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.specta.card.dao.IProductDao;
import com.specta.card.model.ProductModel;

@Service
public class ProductService implements IProductServices{
	
	@Autowired
	IProductDao iProductDao;

	@Override
	public List<ProductModel> getAllProduct() {
		return iProductDao.getAllProduct();
	}

	@Override
	public ProductModel getProductById(int productId) {
		return iProductDao.getProductById(productId);
	}

	@Override
	public boolean addProduct(ProductModel product, MultipartFile file) {
		iProductDao.addProduct(product,file);
		return true;
	}

	@Override
	public void updateProduct(ProductModel product, MultipartFile file) {
		iProductDao.updateProduct(product,file);
	}

	@Override
	public void deleteProduct(int productId) {
		iProductDao.deleteProduct(productId);
	}
	
	

}
