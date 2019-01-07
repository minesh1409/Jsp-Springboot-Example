package com.specta.card.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.specta.card.model.ProfileBasicModel;
import com.specta.card.services.IProfileBasicServices;

@RestController
public class ProfileBaiscController {

	@Autowired
	IProfileBasicServices iProfileBasicServices;

	@Autowired
	private HttpSession session;

	@Autowired
	ServletContext servletContext;

	/*
	 * @GetMapping("/profilebasic") String profileBasic() { return "profilebasic"; }
	 */
	
	// user are alredi added when login
	// only updatation the information of basic and contact
	
	
	@RequestMapping(value = "/profilebasic", method = RequestMethod.GET)
	public ModelAndView profilebasicPage(ModelAndView model) {

		int uid = (int) session.getAttribute("uid");

		System.out.println("\n:::CONTROLLER:::");

		ProfileBasicModel profileBasic = new ProfileBasicModel();
		profileBasic = iProfileBasicServices.getUserByUserId(uid);
		System.out.println("\ncard id Controller : " + profileBasic.getCard_id());
		// System.out.println("\n Profile id :"+profileBasic.getProfile_user_id());
		model.addObject("profilepic", profileBasic.getUser_pic());
		//session.setAttribute("upic", profileBasic.getUser_pic());
		model.addObject("profileBasic", profileBasic);
		model.setViewName("profilebasic");
		return model;
	}

	@RequestMapping(value = "/profilebasic", method = RequestMethod.POST)
	public ModelAndView profileBasic(@ModelAttribute ProfileBasicModel profileBasicmodel,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		ProfileBasicModel profileBasic = null;

		int uid = (int) session.getAttribute("uid");

		String webappRoot = servletContext.getRealPath("/images/users/profile");
		String webappRoot1 = getClass().getClassLoader().getResource("").getPath();
		String webappRoot2 = request.getServletPath();
		URL webappRoot3 = this.getClass().getProtectionDomain().getCodeSource().getLocation();
		System.out.println("webRoot : " + webappRoot);
		System.out.println("webRoot1 : " + webappRoot1);
		System.out.println("webRoot2 : " + webappRoot2);
		System.out.println("webRoot3 : " + webappRoot3);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/images/users/profile/" + uid + "/").toUriString();
		System.out.println(fileDownloadUri);
		
		
		profileBasic = iProfileBasicServices.updateBasicInfo(profileBasicmodel, file);

		//modelAndView.addObject("profileBasic", profileBasic);
		//modelAndView.addObject("profilepic", profileBasic.getUser_pic());
		//session.setAttribute("upic", profileBasic.getUser_pic());
		//modelAndView.setViewName("profilebasic");
		//return modelAndView;
		return new ModelAndView("redirect:/profilebasic");
	}

	
	@RequestMapping(value = "/profilecontact", method = RequestMethod.GET)
	public ModelAndView profilecontactPage(ModelAndView model) {

		int uid = (int) session.getAttribute("uid");
		ProfileBasicModel profileBasic = new ProfileBasicModel();
		profileBasic = iProfileBasicServices.getUserByUserId(uid);				
		model.addObject("profileContact", profileBasic);
		model.setViewName("profilecontact");
		return model;
	}
	
	
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public ModelAndView profileContact(@ModelAttribute ProfileBasicModel profileBasicmodel,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		ProfileBasicModel profileBasic = null;
		
		System.out.println(":C:N:C:"+profileBasicmodel.getFirst_name());

		profileBasic = iProfileBasicServices.updateContactInfo(profileBasicmodel);

		modelAndView.addObject("profileContact", profileBasic);
		modelAndView.setViewName("profilecontact");
		return modelAndView;
	}

}
