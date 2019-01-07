package com.specta.card.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.specta.card.model.AchievementModel;
import com.specta.card.model.EducationModel;
import com.specta.card.model.ExperienceModel;
import com.specta.card.model.ProductEnquiryModel;
import com.specta.card.model.ProductModel;
import com.specta.card.model.ProfileAnalyasisModel;
import com.specta.card.model.ProfileBasicModel;
import com.specta.card.model.ProfileDownloadModel;
import com.specta.card.model.SkillModel;
import com.specta.card.model.SocialModel;
import com.specta.card.services.IAchievementservice;
import com.specta.card.services.IEducationSecvice;
import com.specta.card.services.IExperienceService;
import com.specta.card.services.IGuestService;
import com.specta.card.services.IProductEnquiryService;
import com.specta.card.services.IProductServices;
import com.specta.card.services.IProfileAnalysisService;
import com.specta.card.services.IProfileBasicServices;
import com.specta.card.services.IProfileDownloadService;
import com.specta.card.services.ISkillServices;
import com.specta.card.services.ISocialService;

@RestController
public class GuestController {

	@Autowired
	IGuestService iGuestService;

	@Autowired
	IProductEnquiryService iProductEnquiryService;

	@Autowired
	private HttpSession session;
	
	int uid;

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
	IProfileDownloadService iProfileDownloadService;

	@Autowired
	IProfileAnalysisService iProfileAnalysisService;
	
	@Autowired
	ServletContext servletContext;

	@GetMapping("/{cardId}")
	public ModelAndView registerPage(@PathVariable("cardId") String guestCardId, ModelAndView modelAndView) throws Exception {
		
		if(iGuestService.checkCardRegister(guestCardId)) {		
		System.out.println("GUEST CONTROLLER");
		System.out.println("guestCardId" + guestCardId);
		
		int guestId = iGuestService.getGuestId(guestCardId);
		System.out.println("Controller GuestId" + guestId);

		session.setAttribute("uid", guestId);		
		session.setAttribute("ucardid", guestCardId);
		session.setAttribute("gid", guestId);
		session.setAttribute("gcardid", guestCardId);
		
		uid = (int) session.getAttribute("uid");		
		
		ProfileBasicModel profileBasicModel = iProfileBasicServices.getBasicInfo(uid);
		List<SocialModel> socialList = iSocialService.getAllSocial();
		List<EducationModel> educationList = iEducationSecvice.getAllEducation();
		List<ExperienceModel> experienceList = iExperienceService.getAllExperience();
		List<AchievementModel> achievementList = iAchievementservice.getAllAchievement();
		List<SkillModel> skillList = iSkillServices.getAllSkill();
		List<ProductModel> productList = iProductServices.getAllProduct();
				
		modelAndView.addObject("basicInfo", profileBasicModel);
		modelAndView.addObject("socialList", socialList);
		modelAndView.addObject("educationList", educationList);
		modelAndView.addObject("experienceList", experienceList);
		modelAndView.addObject("achievementList", achievementList);
		modelAndView.addObject("skillList", skillList);
		modelAndView.addObject("productList", productList);

		String vcf = vcfDownload(profileBasicModel);
		modelAndView.addObject("contactFile", vcf);
		modelAndView.setViewName("viewcard");
		return modelAndView;
		}else {			
			return new ModelAndView("redirect:/register");
		}
	}

	@GetMapping(value = "/getproduct/{id}")
	public ProductModel GetProduct(@PathVariable("id") int productId, ModelAndView model) {
		System.out.println("\n:::CONTROLLER:::");
		ProductModel productModel = new ProductModel();
		productModel = iProductServices.getProductById(productId);
		return productModel;
	}

	@PostMapping("/addenquiry")
	public String AddEnquiry(@ModelAttribute ProductEnquiryModel productEnquiryModel) {
		System.out.println("Enquiry Controller");
		iProductEnquiryService.addEnquiry(productEnquiryModel);
		return "success";
	}

	@PostMapping("/addanalysis")
	public String addAnalysis(@ModelAttribute ProfileAnalyasisModel profileAnalyasisModel) {

		iProfileAnalysisService.addAnalyasis(profileAnalyasisModel);

		session.removeAttribute("uid");
		session.removeAttribute("ucardid");
		return "Data analyzed";
	}
	
	@PostMapping("/vcfdownload")
	public String addVcfDownload(@ModelAttribute ProfileDownloadModel profileDownloadModel) {
		
		iProfileDownloadService.addDownload(profileDownloadModel);
		return "Vcf analyzed";
	}
	


	public String vcfDownload(ProfileBasicModel profileBasicModel) throws Exception {

		String UPLOAD_FOLDER = servletContext.getRealPath("/vcf/");
		// for directory create
		File destinationPath = new File(UPLOAD_FOLDER);
		if (!destinationPath.exists()) {

			if (destinationPath.mkdirs()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		} // directory create end

		File f = new File(UPLOAD_FOLDER+"contact.vcf");
		FileOutputStream fop = new FileOutputStream(f);

		if (f.exists()) {
			String str = "BEGIN:VCARD\n" + "VERSION:4.0\n" + "N:Gump;"+profileBasicModel.getFirst_name()+";;;\n" + "FN:"+profileBasicModel.getFirst_name()+"\n"
					+ "ORG:\n" + "TITLE:"+profileBasicModel.getProfession()+"\n"
					+ "TEL;TYPE=work,voice;VALUE=uri:tel:"+profileBasicModel.getMobile()+"\n"
					+ "TEL;TYPE=home,voice;VALUE=uri:tel:"+profileBasicModel.getMobile()+"\n" + "EMAIL:"+profileBasicModel.getEmail()+"\n"
					+ "REV:20080424T195243Z\n" + "END:VCARD";
			fop.write(str.getBytes());
			// Now read the content of the vCard after writing data into it
			BufferedReader br = null;
			String sCurrentLine;
			br = new BufferedReader(new FileReader(UPLOAD_FOLDER+"contact.vcf"));
			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
			}
			// close the output stream and buffer reader
			fop.flush();
			fop.close();
			System.out.println("The data has been written");
		}

		else {
			System.out.println("This file does not exist");
		}
		
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/vcf/contact.vcf").toUriString();
	}

}
