package com.thinkpower.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {
	@Value("${spring.mvc.view.view-names}")
	String jspViewNames;
	
	@RequestMapping(value= {"","/","index"})
	public String toIndex() {
		return jspViewNames +"/index";
	}
}
