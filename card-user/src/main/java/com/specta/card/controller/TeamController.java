package com.specta.card.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TeamController {
	
	@Autowired
	private HttpSession session;
	
	int uid;
	int memid;
	

	@GetMapping("/team-dashboard")
	public ModelAndView teamPage(ModelAndView modelAndView) {
		modelAndView.setViewName("teamdashboard");
		return modelAndView;
	}
	
}
