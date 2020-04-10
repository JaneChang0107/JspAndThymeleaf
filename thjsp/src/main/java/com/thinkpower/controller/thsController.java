package com.thinkpower.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ths")
public class thsController {

	@RequestMapping(value={"","/"})
	public ModelAndView toThHome() {	
		ModelAndView model = new ModelAndView("ths/thhome");
		model.addObject("today", new Date());
		model.addObject("welcome", "這是thymeleaf-thhome網頁");
		return model;
	
	}
}
