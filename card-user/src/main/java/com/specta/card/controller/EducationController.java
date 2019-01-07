package com.specta.card.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.specta.card.model.EducationModel;
import com.specta.card.model.ProfileBasicModel;
import com.specta.card.services.IEducationSecvice;


@RestController
public class EducationController {
	
	@Autowired
	IEducationSecvice iEducationSecvice;	
	
	@Autowired
	private HttpSession session;
	
	int uid;
	
	@GetMapping("/profileeducation")
	public ModelAndView profileEducation(ModelAndView model) {
		uid = (int) session.getAttribute("uid");
		List<EducationModel> educationModel = iEducationSecvice.getAllEducation();
		model.addObject("profileEducationList",educationModel);
		model.addObject("profileEducation",new EducationModel());
		model.setViewName("profileeducation");
		return model;
	}
	
	@PostMapping("/addeducation")
	public ModelAndView addEducation(@ModelAttribute EducationModel educationModel) {
		System.out.println("EDU Controller");
		ModelAndView modelAndView = new ModelAndView();
		iEducationSecvice.createEducation(educationModel);
		return new ModelAndView("redirect:/profileeducation");
	}
	
	/*@GetMapping(value = "/editeducation/{id}")
	public ModelAndView editEducation(@PathVariable("id") int eduId, ModelAndView model) {

		System.out.println("\n:::CONTROLLER:::");
		EducationModel educationModel = new EducationModel();
		educationModel = iEducationSecvice.getEducationById(eduId);
		model.addObject("profileEducation",educationModel);
		//model.setViewName("forward:/profileeducation");
		return model;
	}*/
	
	@GetMapping(value = "/editeducation/{id}")
	public EducationModel editEducation(@PathVariable("id") int eduId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		EducationModel educationModel = new EducationModel();
		educationModel = iEducationSecvice.getEducationById(eduId);
		//model.addObject("profileEducation",educationModel);
		//model.setViewName("forward:/profileeducation");
		return educationModel;
	}
	
	
	@PostMapping(value = "/updateeducation/{id}")
	public ModelAndView profilebasicPage(@PathVariable("id") int eduId,@ModelAttribute EducationModel educationModel, ModelAndView model) {

		educationModel.setId(eduId);
		iEducationSecvice.updateEducation(educationModel);
		return  new ModelAndView("redirect:/profileeducation");
		
	}
	
	
	@GetMapping(value = "/deleteeducation/{id}")
	public ModelAndView deleteEducation(@PathVariable("id") int eduId, ModelAndView model) {
		
		System.out.println("\n:::CONTROLLER:::");
		iEducationSecvice.deleteEducation(eduId);
		return  new ModelAndView("redirect:/profileeducation");
	}
	
}
