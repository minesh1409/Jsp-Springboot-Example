package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.specta.card.dao.IDocumentDao;
import com.specta.card.model.DocumentModel;

@Service
public class DocumentService implements IDocumentService {

	@Autowired
	IDocumentDao iDocumentDao;

	@Override
	public List<DocumentModel> getAllDocument() {		
		return iDocumentDao.getAllDocument();
	}

	@Override
	public List<DocumentModel> getAllDocumentByUserId(int userId) {		
		return iDocumentDao.getAllDocumentByUserId(userId);
	}

	@Override
	public DocumentModel getDocumentById(int documentId) {
		return iDocumentDao.getDocumentById(documentId);
	}

	@Override
	public boolean addDocument(DocumentModel document, MultipartFile file, MultipartFile file1) {
		iDocumentDao.addDocument(document, file, file1);
		return true;
	}

	@Override
	public void updateDocument(DocumentModel document, MultipartFile file, MultipartFile file1) {
		iDocumentDao.updateDocument(document, file, file1);
	}

	@Override
	public void deleteDocument(int documentId) {
		iDocumentDao.deleteDocument(documentId);
	}
	
}
