package com.thinkpower.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class jspController {		
	@Value("${spring.mvc.view.view-names}")
	String jspViewNames;	
	@RequestMapping(value={"","/","jsphome"})
	public String toJspHome(Model model) {		
		model.addAttribute("today", new Date());
		model.addAttribute("welcome", "這是JSP網頁");
		return jspViewNames+"/jsphome";
	}	
}
