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

import com.specta.card.model.AchievementModel;
import com.specta.card.services.IAchievementservice;

@RestController
public class AchievementController {

	@Autowired
	IAchievementservice iAchievementservice;
	
	@Autowired
	private HttpSession session;
	
	int uid;
	
	@GetMapping("/profileachievement")
	public ModelAndView profileAchievement(ModelAndView model) {
		uid = (int) session.getAttribute("uid");
		
		List<AchievementModel> achievementModel = iAchievementservice.getAllAchievement();
		
		model.addObject("profileAchievementList",achievementModel);
		model.addObject("profileAchievement",new AchievementModel());
		model.setViewName("profileachievement");
		return model;
	}
	
	@PostMapping("/addachievement")
	public ModelAndView addAchievement(@ModelAttribute AchievementModel achievementModel) {
		System.out.println("ACH Controller");
		iAchievementservice.addAchievement(achievementModel);
		return new ModelAndView("redirect:/profileachievement");
	}
	
	
	@GetMapping(value = "/editachievement/{id}")
	public AchievementModel EditAchievement(@PathVariable("id") int achId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		AchievementModel achievementModel = new AchievementModel();
		achievementModel = iAchievementservice.getAchievementById(achId);
		return achievementModel;
	}
	
	@PostMapping(value = "/updateachievement/{id}")
	public ModelAndView UpdateAchievement(@PathVariable("id") int eduId,@ModelAttribute AchievementModel achievementModel, ModelAndView model) {

		achievementModel.setId(eduId);
		iAchievementservice.updateAchievement(achievementModel);
		return  new ModelAndView("redirect:/profileachievement");
		
	}
	
	
	@GetMapping("/deleteachievement/{id}")
	public ModelAndView deleteAchievement(@PathVariable("id") int achId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		iAchievementservice.deleteAchievement(achId);
		return new ModelAndView("redirect:/profileachievement");
	}
}
