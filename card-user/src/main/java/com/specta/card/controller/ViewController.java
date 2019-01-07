package com.specta.card.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	/*@GetMapping({"/"})
	String profileView() {
		return "login";
	}*/
	@GetMapping("/logout")
	String logout(Model model) {
		return "login";
	}

	/*@GetMapping( "/user-dashboard")
	String userDashboard() {
		return "userdashboard";
	}
	*/
	@GetMapping("/editprofile")
	String editProfile() {
		return "editprofile";
	}

	
}
