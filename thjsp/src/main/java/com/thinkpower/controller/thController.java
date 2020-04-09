package com.thinkpower.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/th")
public class thController {
	@Value("${spring.mvc.view.view-names}")
	String jspViewNames;
	@Value("${spring.thymeleaf.view-names}")
	String thymeleafViewNames;
	
	@RequestMapping(value={"","/"})
	public String toThHome(Model model) {
		model.addAttribute("today", new Date());
		model.addAttribute("welcome", "這是thymeleaf網頁");
		return thymeleafViewNames+"/thhome";
	}
	@RequestMapping(value={"/jsps"})
	public String tojspindex(Model model) {
		model.addAttribute("today", new Date());
		model.addAttribute("welcome", "這是thymeleaf網頁");
		return thymeleafViewNames+"/index";
	}
}
