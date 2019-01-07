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

import com.specta.card.model.DocumentModel;
import com.specta.card.model.ProductModel;
import com.specta.card.services.IDocumentService;

@RestController
public class DocumentController {

	@Autowired
	IDocumentService iDocumentService;
	
	@Autowired
	private HttpSession session;
	int uid;	
	
	@Autowired
	ServletContext servletContext;
	
	
	@GetMapping("/document")
	ModelAndView getAllDocument(ModelAndView model) {
		
		uid = (int) session.getAttribute("uid");
		List<DocumentModel> documentList = iDocumentService.getAllDocumentByUserId(uid);
		model.addObject("documentList", documentList);
		model.addObject("documentModel", new DocumentModel());
		model.setViewName("document");
		return model;
	}
	
	@PostMapping("/adddocument")
	public ModelAndView addDocument(@ModelAttribute DocumentModel documentModel, @RequestParam("file") MultipartFile file, @RequestParam("file1") MultipartFile file1, HttpServletRequest request) {
		iDocumentService.addDocument(documentModel, file, file1);
		return new ModelAndView("redirect:/document");
		
	}
	
	@GetMapping(value = "/editdocument/{id}")
	public DocumentModel EditDocument(@PathVariable("id") int documentId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		DocumentModel documentModel = new DocumentModel();
		documentModel = iDocumentService.getDocumentById(documentId);
		return documentModel;
	}
	
	@PostMapping(value = "/updatedocument/{id}")
	public ModelAndView updateDocument(@PathVariable("id") int documentId,@ModelAttribute DocumentModel documentModel, @RequestParam("file") MultipartFile file,  @RequestParam("file1") MultipartFile file1) {

		documentModel.setId(documentId);
		iDocumentService.updateDocument(documentModel, file, file1);
		return  new ModelAndView("redirect:/document");
		
	}
	
	@GetMapping("/deletedocument/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int documentId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		iDocumentService.deleteDocument(documentId);;
		return new ModelAndView("redirect:/document");
	}

	
}
