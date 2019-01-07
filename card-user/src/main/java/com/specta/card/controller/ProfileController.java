package com.specta.card.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.specta.card.model.AchievementModel;
import com.specta.card.model.EducationModel;
import com.specta.card.model.ExperienceModel;
import com.specta.card.model.ProductModel;
import com.specta.card.model.ProfileBasicModel;
import com.specta.card.model.SkillModel;
import com.specta.card.model.SocialModel;
import com.specta.card.services.IAchievementservice;
import com.specta.card.services.IEducationSecvice;
import com.specta.card.services.IExperienceService;
import com.specta.card.services.IProductServices;
import com.specta.card.services.IProfileBasicServices;
import com.specta.card.services.ISkillServices;
import com.specta.card.services.ISocialService;

@RestController
public class ProfileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	IProfileBasicServices iProfileBasicServices;
	
	@Autowired
	ISocialService iSocialService;
	
	@Autowired
	IEducationSecvice iEducationSecvice;
	
	@Autowired
	IExperienceService iExperienceService;
	
	@Autowired
	IAchievementservice iAchievementservice;
	
	@Autowired
	ISkillServices iSkillServices;
	
	@Autowired
	IProductServices iProductServices;
	
	@Autowired
	private HttpSession session;
	int uid;
	
	@GetMapping("/profile-view")
	public ModelAndView viewPage(ModelAndView modelAndView) {
		uid = (int) session.getAttribute("uid");
		
		ProfileBasicModel profileBasicModel= iProfileBasicServices.getBasicInfo(uid);
		List<SocialModel> socialList =iSocialService.getAllSocial();
		List<EducationModel> educationList =iEducationSecvice.getAllEducation();
		List<ExperienceModel> experienceList = iExperienceService.getAllExperience();
		List<AchievementModel> achievementList = iAchievementservice.getAllAchievement();
		List<SkillModel> skillList = iSkillServices.getAllSkill();
		List<ProductModel> productList = iProductServices.getAllProduct();
		
		modelAndView.addObject("profileBasicInfo",profileBasicModel);
		modelAndView.addObject("profileSocialList",socialList);
		modelAndView.addObject("profileEducationList",educationList);
		modelAndView.addObject("profileExperienceList",experienceList);
		modelAndView.addObject("profileAchievementList",achievementList);
		modelAndView.addObject("profileSkillList",skillList);
		modelAndView.addObject("productList",productList);
		
		modelAndView.setViewName("profileview");
		return modelAndView;
	}

}
