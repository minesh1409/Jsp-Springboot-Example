package com.specta.card.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.specta.card.admin.model.GenerateCardIdModel;
import com.specta.card.admin.service.IGenerateCardIdService;

@RestController
@RequestMapping("/admin")
public class GenerateCardIdController {

	@Autowired
	IGenerateCardIdService iGenerateCardIdService;

	@GetMapping("/gencardid")
	public ModelAndView genCardIdPage() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<GenerateCardIdModel> cardIdList = iGenerateCardIdService.getAllCardId();
		
		modelAndView.addObject("cardIdList",cardIdList);
		modelAndView.setViewName("cardid");
		return modelAndView;

	}

	@PostMapping("/gencardid")
	public ModelAndView genCardId(@RequestParam("GenNo") int genNum) {
		
		for (int i = 0; i < genNum; i++) {
			iGenerateCardIdService.addCardId(new GenerateCardIdModel());
		}
		
		return new ModelAndView("redirect:/admin/gencardid");

	}

}
