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

import com.specta.card.model.ExperienceModel;
import com.specta.card.model.SocialModel;
import com.specta.card.services.ISocialService;

@RestController
public class SocialController {

	@Autowired
	ISocialService iSocialService;
	
	@Autowired
	private HttpSession session;
	
	int uid;
	
	@GetMapping("/profilesocial")
	public ModelAndView profileSociall(ModelAndView model) {
		
		uid = (int) session.getAttribute("uid");
		
		List<SocialModel> socialModels = iSocialService.getAllSocial();
		
		model.addObject("profileSocialList", socialModels);
		model.addObject("profileSocial",new SocialModel());
		model.setViewName("profilesocial");
		return model;
	}
	
	@PostMapping("/addsocial")
	public ModelAndView addSocial(@ModelAttribute SocialModel socialModel) {
		System.out.println("Social Controller");
		iSocialService.addSocial(socialModel);
		return new ModelAndView("redirect:/profilesocial");
	}
	
	
	@GetMapping(value = "/editsocial/{id}")
	public SocialModel EditSocial(@PathVariable("id") int socialId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		SocialModel socialModel = new SocialModel();
		socialModel = iSocialService.getSocialById(socialId);
		return socialModel;
	}
	
	@PostMapping(value = "/updatesocial/{id}")
	public ModelAndView UpdateSocial(@PathVariable("id") int socialId,@ModelAttribute SocialModel socialModel, ModelAndView model) {

		socialModel.setId(socialId);
		iSocialService.updateSocial(socialModel);
		return  new ModelAndView("redirect:/profilesocial");
		
	}
	
	
	@GetMapping("/deletesocial/{id}")
	public ModelAndView deleteSocial(@PathVariable("id") int socialId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		iSocialService.deleteSocial(socialId);
		return new ModelAndView("redirect:/profilesocial");
	}
	
}
