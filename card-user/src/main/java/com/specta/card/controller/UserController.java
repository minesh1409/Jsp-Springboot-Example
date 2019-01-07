package com.specta.card.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.specta.card.model.ProfileBasicModel;
import com.specta.card.model.User;
import com.specta.card.services.IProfileBasicServices;
import com.specta.card.services.IUserService;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userservice;

	@Autowired
	private IProfileBasicServices iProfileBasicServices;

	//registration page
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage(ModelAndView model) {
		User user = new User();
		model.addObject("userReg", user);
		model.setViewName("register");
		return model;
	}
	
	//registration process
	@RequestMapping(value = "/registeration", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User userReg, @RequestParam("otptxt") int otpTxt,
			HttpSession session) throws ParseException {

		ModelAndView modelAndView = new ModelAndView(); // 33-11-2018

		// int otp = (int) session.getAttribute("otp");

		session.invalidate();

		System.out.println("otp match");
		boolean flag = userservice.createUser(userReg);
		if (flag == false) {
			modelAndView.addObject("regMessage", "Register Fail!");
			modelAndView.setViewName("register");
			return modelAndView; // 33-11-2018
			// return new ModelAndView("redirect:/register");
		} else {
			LOGGER.info("User REGISTER");
			modelAndView.addObject("regMessage", "Register Successful Ꝅ");
			modelAndView.addObject("userLogin",new User());
			modelAndView.setViewName("login");
			return modelAndView; // 33-11-2018
			// return new ModelAndView("redirect:/login");
		}

	}

	// login page
	@GetMapping({"/","/login"})
	public ModelAndView loginPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if (session.getAttribute("uname") != null) {
			System.out.println("session: " + session.getAttribute("uname"));
			System.out.println("session: " + session.getAttribute("uid"));
			session.invalidate();
			System.out.println("session removed.");
			modelAndView.addObject("success", "Logout Successfully");
		}
		User user = new User();
		modelAndView.addObject("userLogin", user);
		modelAndView.setViewName("login");
		return modelAndView;

	}

	// do login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute("userName") User userLogin, HttpServletRequest request,
			HttpSession session) {
		
		//System.out.println("Requested URL::" + request.getRequestURL());

		String msg = userservice.doLogin(userLogin.getUserName(), userLogin.getPassword());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userLogin", userLogin);
		
		if (msg == "Fail") {
			modelAndView.addObject("error", "Enter valid Password");
			modelAndView.setViewName("login");
			return modelAndView;
		} else if (msg == "Notfound") {
			modelAndView.addObject("error", "Enter valid Username and Password");
			modelAndView.setViewName("login");
			return modelAndView;
		} else {
			LOGGER.info("User Login");
			//session.setAttribute("uname", userLogin.getUserName());			
			iProfileBasicServices.addBasicInfo(new ProfileBasicModel());
			return new ModelAndView("redirect:/user-dashboard");

		}
	}

	// get mobile and send otp
	@RequestMapping(value = "/getotp/{contact}", method = RequestMethod.GET)
	public RedirectView sendOtp(@PathVariable("contact") long contact, HttpSession session) {
		System.out.println("otp contact : " + contact);

		int randomOTP = (int) (Math.random() * 999999) + 111111;
		session.setAttribute("otp", randomOTP);

		String message = "Your OTP for Digital Identity is " + randomOTP;
		System.out.println("Sending: "+message);
		
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("http://msg.noblewebstudio.com/api/sendhttp.php?authkey=123456789&mobiles=" + contact
				+ "&message=" + message + ".&sender=CONNECT&route=4");//
		return rv;
		
	}
	
	@RequestMapping(value = "/otp", method = RequestMethod.GET)
	public int getOtp(HttpSession session) {
		int randomOTP = (int) session.getAttribute("otp");
		session.invalidate();
		return randomOTP;
		
	}

	@GetMapping("/checkcardid/{cardId}")
	boolean checkCardId(@PathVariable("cardId") String cardId) {
		return userservice.checkCardId(cardId);
	}
	
}
