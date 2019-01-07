package com.specta.card.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.specta.card.admin.model.AdminModel;
import com.specta.card.admin.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService iAdminService;

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		if (session.getAttribute("admin") != null) {
			System.out.println("session: " + session.getAttribute("admin"));
			session.invalidate();
			System.out.println("session removed.");
			modelAndView.addObject("success", "Logout Successfully");
		}
		AdminModel adminModel = new AdminModel();
		modelAndView.addObject("adminLogin", adminModel);
		modelAndView.setViewName("login");
		return modelAndView;

	}
	
	// login page
	@GetMapping({"/", "/login" })
	public ModelAndView loginPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if (session.getAttribute("admin") != null) {
			System.out.println("session: " + session.getAttribute("admin"));
			session.invalidate();
			System.out.println("session removed.");
			modelAndView.addObject("success", "Logout Successfully");
		}
		AdminModel adminModel = new AdminModel();
		modelAndView.addObject("adminLogin", adminModel);
		modelAndView.setViewName("login");
		return modelAndView;

	}

	// do login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute("userName") AdminModel adminLogin, HttpServletRequest request,
			HttpSession session) {

		System.out.println("Requested URL::" + request.getRequestURL());

		String msg = iAdminService.doLogin(adminLogin.getUserName(), adminLogin.getPassword());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("adminLogin", adminLogin);

		if (msg == "Fail") {
			modelAndView.addObject("error", "Enter valid Admin Password");
			modelAndView.setViewName("/login");
			return modelAndView;
		} else if (msg == "Notfound") {
			modelAndView.addObject("error", "Enter valid Admin Username and Password");
			modelAndView.setViewName("/login");
			return modelAndView;
		} else {
			if(msg == "Success") {
			session.setAttribute("admin", adminLogin.getUserName());
			}
			return new ModelAndView("redirect:/admin/gencardid");

		}
	}
	
}
