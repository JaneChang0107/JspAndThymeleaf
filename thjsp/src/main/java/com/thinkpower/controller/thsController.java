package com.thinkpower.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ths")
public class thsController {

	@RequestMapping(value={"","/"})
	public String toThHome() {	
		return "ths/thhome";
	}
}
