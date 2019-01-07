package com.specta.card.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.specta.card.model.ProfileAnalyasisModel;
import com.specta.card.model.ProfileDownloadModel;
import com.specta.card.services.IProfileAnalysisService;
import com.specta.card.services.IProfileDownloadService;

@RestController
public class ProfileDashboard {

	@Autowired
	IProfileAnalysisService iProfileAnalysisService;

	@Autowired
	IProfileDownloadService iProfileDownloadService;
	
	@Autowired
	private HttpSession session;
	int uid;

	@GetMapping("user-dashboard")
	public ModelAndView viewPage(ModelAndView modelAndView) {
		uid = (int) session.getAttribute("uid");
		
		List<ProfileAnalyasisModel> profileAnalyasisModels =iProfileAnalysisService.getAllAnalyasisByUserId(uid);
		modelAndView.addObject("analysisList",profileAnalyasisModels);
		
		modelAndView.setViewName("userdashboard");
		return modelAndView;
	}

	
	@GetMapping("/analysischart")
	public List<ProfileAnalyasisModel> viewScan() {
		uid = (int) session.getAttribute("uid");
		
		List<ProfileAnalyasisModel> profileAnalyasisModels =iProfileAnalysisService.getAllAnalyasisByUserId(uid);
		System.out.println("analysischart");
		return profileAnalyasisModels;
	}
	
	@GetMapping("/downloadchart")
	public List<ProfileDownloadModel> viewDownload() {
		uid = (int) session.getAttribute("uid");
		List<ProfileDownloadModel> profileDownloadModels =iProfileDownloadService.getAllDownloadByUserId(uid);
		System.out.println("analysischart");
		return profileDownloadModels;
	}
	
}
