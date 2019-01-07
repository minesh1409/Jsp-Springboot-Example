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

import com.specta.card.model.DocumentModel;
import com.specta.card.model.ProductModel;

@Repository
@Transactional
public class DocumentDao implements IDocumentDao{
	
	@Autowired
	private EntityManager entitymanager;

	@Autowired
	ServletContext servletContext;

	@Autowired
	private HttpSession session;
	int uid;

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentModel> getAllDocument() {
		String hql = "FROM DocumentModel";
		return entitymanager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentModel> getAllDocumentByUserId(int userId) {
		String hql = "FROM DocumentModel where userId="+userId ;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public DocumentModel getDocumentById(int documentId) {
		return entitymanager.find(DocumentModel.class, documentId);
	}

	@Override
	public void addDocument(DocumentModel document, MultipartFile file, MultipartFile file1) {
		
		System.out.println("DOCUMENT DAO");
		uid = (int) session.getAttribute("uid");

		if (!file.isEmpty()) {
			String frontImageUrl = ImageUpload(file);
			frontImageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/users/document/" + uid + "/" + frontImageUrl).toUriString();
			document.setFrontImageUrl(frontImageUrl);			
		} else {
			System.out.println("\nFile EMPTY\n");
		}

		if (!file1.isEmpty()) {
			String backImageUrl = ImageUpload(file1);
			backImageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/users/document/" + uid + "/" + backImageUrl).toUriString();
			document.setBackImageUrl(backImageUrl);			
		} else {
			System.out.println("\nFile EMPTY\n");
		}
		
		
		document.setUserId(uid);
		System.out.println("ADD PRODUCT: " + document.toString());
		entitymanager.persist(document);
		
		
	}

	@Override
	public void updateDocument(DocumentModel document, MultipartFile file, MultipartFile file1) {
		System.out.println("DocumentModel DAO UPDATE");
		
		uid = (int) session.getAttribute("uid");
		
		DocumentModel documentModel = getDocumentById(document.getId());
		
		documentModel.setName(document.getName());
		
		if (!file.isEmpty()) {
			String frontImageUrl = ImageUpload(file);
			frontImageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/users/document/" + uid + "/" + frontImageUrl).toUriString();
			documentModel.setFrontImageUrl(frontImageUrl);			
		} else {
			System.out.println("\nFile EMPTY\n");
		}

		if (!file1.isEmpty()) {
			String backImageUrl = ImageUpload(file1);
			backImageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/users/document/" + uid + "/" + backImageUrl).toUriString();
			documentModel.setBackImageUrl(backImageUrl);			
		} else {
			System.out.println("\nFile EMPTY\n");
		}
				
		document.setUserId(uid);
		
		entitymanager.flush();
		
	}

	@Override
	public void deleteDocument(int documentId) {		
		DocumentModel documentModel = getDocumentById(documentId);
		entitymanager.remove(documentModel);
	}
	
	
	public String ImageUpload(MultipartFile file) {

		System.out.println("CALL IMAGE UPLOAD");

		String fileName = null;
		// String UPLOAD_FOLDER = "C:/test/user/profile/";
		int uid = (int) session.getAttribute("uid");

		String UPLOAD_FOLDER = servletContext.getRealPath("/images/users/document/" + uid + "/");

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
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
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
