package com.thinkpower.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jsp")
public class jspController {		
	@Value("${spring.mvc.view.view-names}")
	String jspViewNames;	
	@RequestMapping(value={"","/","/jsphome"})
	public String toJspHome(Model model) {		
		model.addAttribute("today", new Date());
		model.addAttribute("welcome", "這是JSP網頁 jsphome");
		return jspViewNames+"/jsphome";
	}	
	@RequestMapping(value={"/i"})
	public String toIndex(Model model) {	
		
		model.addAttribute("today", new Date());
		model.addAttribute("welcome", "這是JSP網頁 /i");
		return "redirect:ths/thhome";
	}	
	@RequestMapping(value={"/thhome"})
	public String toThHome(Model model) {			
		model.addAttribute("today", new Date());
		model.addAttribute("welcome", "這是JSP網頁 /thhome");
		return "jsp/thhome";
	}
	@RequestMapping(value={"/ths/thhome"})
	public String toThsThHome(Model model) {			
		model.addAttribute("today", new Date());
		model.addAttribute("welcome", "這是JSP網頁 /ths/thhome");
		return "jsp/ths/thhome";
	}	
}
