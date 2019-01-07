package com.specta.card.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.specta.card.model.EducationModel;
import com.specta.card.model.ExperienceModel;
import com.specta.card.services.IExperienceService;

@RestController
public class ExperienceController {
	
	@Autowired
	IExperienceService iExperienceService;

	@Autowired
	private HttpSession session;
	
	int uid;
	
	@GetMapping("/profileexperience")
	public ModelAndView ProfileExperience(ModelAndView model) {
		
		uid = (int) session.getAttribute("uid");	
		
		List<ExperienceModel> experienceModels = iExperienceService.getAllExperience();
		
		model.addObject("profileExperienceList", experienceModels);
		model.addObject("profileExperience", new ExperienceModel());
		model.setViewName("profileexperience");
		return model;
	}
	
	@PostMapping("/addexperience")
	public ModelAndView AddExperience(@ModelAttribute ExperienceModel experienceModel) {
		System.out.println("Exp Controller");
		iExperienceService.addExperience(experienceModel);
		return new ModelAndView("redirect:/profileexperience");
	}
	
	@GetMapping(value = "/editexperience/{id}")
	public ExperienceModel EditExperience(@PathVariable("id") int expId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		ExperienceModel experienceModel = new ExperienceModel();
		experienceModel = iExperienceService.getExperienceById(expId);
		return experienceModel;
	}
	
	@PostMapping(value = "/updateexperience/{id}")
	public ModelAndView UpdateExperience(@PathVariable("id") int eduId,@ModelAttribute ExperienceModel experienceModel, ModelAndView model) {

		experienceModel.setId(eduId);
		iExperienceService.updateExperience(experienceModel);
		return  new ModelAndView("redirect:/profileexperience");
		
	}
	
	
	@GetMapping("/deleteexperience/{id}")
	public ModelAndView deleteAchievement(@PathVariable("id") int expId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		iExperienceService.deleteExperience(expId);
		return new ModelAndView("redirect:/profileexperience");
	}
	
	
}
