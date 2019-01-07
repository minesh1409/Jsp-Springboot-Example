package com.specta.card.dao;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.specta.card.model.ProductModel;

@Repository
@Transactional
public class ProductDao implements IProductDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	ServletContext servletContext;

	@Autowired
	private HttpSession session;
	int uid;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> getAllProduct() {
		uid = (int) session.getAttribute("uid");
		String hql = "FROM ProductModel  where userId="+uid;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public ProductModel getProductById(int productId) {
		return entitymanager.find(ProductModel.class, productId);
	}

	@Override
	public void addProduct(ProductModel product, MultipartFile file) {
		System.out.println("PRODUCT DAO");
		uid = (int) session.getAttribute("uid");

		if (!file.isEmpty()) {
			String imgUrl = ImageUpload(file);
			imgUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/users/product/" + uid + "/" + imgUrl).toUriString();
			
			product.setImageUrl(imgUrl);
			
		} else {
			System.out.println("\nFile EMPTY\n");
		}

		product.setUserId(uid);

		System.out.println("ADD PRODUCT: " + product.toString());
		entitymanager.persist(product);
	}

	@Override
	public void updateProduct(ProductModel product, MultipartFile file) {
		uid = (int) session.getAttribute("uid");
		System.out.println("PRODUCT DAO");
		System.out.println("Update ProductId: " + product.getId());

		ProductModel productModel = getProductById(product.getId());

		productModel.setName(product.getName());
		
		if (!file.isEmpty()) {
			System.out.println("\nFile Not EMPTY\n");
			String imgUrl = ImageUpload(file);
			imgUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/users/product/" + uid + "/" + imgUrl).toUriString();
			System.out.println("update imgUrl: "+imgUrl);
			productModel.setImageUrl(imgUrl);
		} else {System.out.println("\nFile EMPTY\n");}
		
		productModel.setDescription(product.getDescription());
		product.setUserId(uid);
		System.out.println("UPDATE PRODUCT: " + product.toString());
		
		entitymanager.flush();

	}

	@Override
	public void deleteProduct(int productId) {
		ProductModel productModel = getProductById(productId);
		entitymanager.remove(productModel);
	}

	public String ImageUpload(MultipartFile file) {

		System.out.println("CALL IMAGE UPLOAD");

		String fileName = null;
		// String UPLOAD_FOLDER = "C:/test/user/profile/";
		int uid = (int) session.getAttribute("uid");

		String UPLOAD_FOLDER = servletContext.getRealPath("/images/users/product/" + uid + "/");

		// for directory create
		File destinationPath = new File(UPLOAD_FOLDER);
		if (!destinationPath.exists()) {

			if (destinationPath.mkdirs()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		} // directory create end

		try {

			if (!file.isEmpty()) {
				// for imagename
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				fileName = sdf.format(timestamp) + ".jpg";
				// System.out.println("filenasme:"+fileName);
				// end

				// file write
				byte[] bytes = file.getBytes();
				Path path = Paths.get(UPLOAD_FOLDER + fileName);
				Files.write(path, bytes); // file write end
				System.out.println("Image is stored at " + path);
			}

		} catch (Exception e) {
			System.out.println("Exception occured : " + e.getMessage());
		}

		System.out.println("CALLED IMAGE UPLOADED");
		
		return fileName;
	}

}
