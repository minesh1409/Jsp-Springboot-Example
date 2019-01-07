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
import com.specta.card.model.SkillModel;
import com.specta.card.services.ISkillServices;

@RestController
public class SkillController {

	@Autowired
	ISkillServices iSkillServices;

	@Autowired
	private HttpSession session;

	int uid;

	@GetMapping("/profileskill")
	ModelAndView profileSkill(ModelAndView model) {

		List<SkillModel> skillModel = iSkillServices.getAllSkill();
		model.addObject("profileSkillList", skillModel);
		model.addObject("profileSkill", new SkillModel());
		model.setViewName("profileskill");
		return model;
	}

	@PostMapping("addskill")
	public ModelAndView addSkill(@ModelAttribute SkillModel skillModel) {
		System.out.println("ACH Controller");
		iSkillServices.addSkill(skillModel);
		return new ModelAndView("redirect:/profileskill");
	}
	
	
	@GetMapping(value = "/editskill/{id}")
	public SkillModel EditSkill(@PathVariable("id") int skillId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		SkillModel skillModel = new SkillModel();
		skillModel = iSkillServices.getSkillById(skillId);
		return skillModel;
	}
	
	@PostMapping(value = "/updateskill/{id}")
	public ModelAndView UpdateSkill(@PathVariable("id") int skillId,@ModelAttribute SkillModel skillModel, ModelAndView model) {

		skillModel.setId(skillId);
		iSkillServices.updateSkill(skillModel);
		return  new ModelAndView("redirect:/profileskill");
		
	}
	

	@GetMapping("/deleteskill/{id}")
	public ModelAndView deleteSkill(@PathVariable("id") int skillId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		iSkillServices.deleteSkill(skillId);
		return new ModelAndView("redirect:/profileskill");
	}

}
