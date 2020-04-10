package com.thinkpower.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class thjspController {
	@RequestMapping("/th")
	public String toThHome(Model model){
		model.addAttribute("welcome", "這是Thymeleaf網頁");
		model.addAttribute("today",new Date());
		return "th/thhome";
	}	
	@RequestMapping("/jsp")
	public String toJspHome(Model model) {
		model.addAttribute("welcome", "這是Jsp網頁");
		model.addAttribute("today",new Date());
		return "jsp/jsphome";
	}
	@RequestMapping("/vue")
	public String toVueHome(Model model) {
		String welcome="Spring框架是 Java 平台的一個開源的全棧（Full-stack）應用程式框架和控制反轉容器實現，一般被直接稱為 Spring";
		model.addAttribute("welcome", welcome);
		model.addAttribute("today",new Date());
		return "vue/thhome";
	}
}
