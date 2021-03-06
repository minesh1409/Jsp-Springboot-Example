package com.specta.card.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.specta.card.model.DocumentModel;

public interface IDocumentService {
	
	public List<DocumentModel> getAllDocument();
	
	public List<DocumentModel> getAllDocumentByUserId(int userId);

	DocumentModel getDocumentById(int documentId);

	boolean addDocument(DocumentModel document, MultipartFile file, MultipartFile file1);

	void updateDocument(DocumentModel document, MultipartFile file, MultipartFile file1);

	public void deleteDocument(int documentId);


}

