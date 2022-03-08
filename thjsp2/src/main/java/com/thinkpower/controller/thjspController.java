package com.thinkpower.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkpower.model.Student;
import com.thinkpower.service.StudentService;

@Controller
public class thjspController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/th")
	public String toThHome(Model model){
		model.addAttribute("welcome", "這是Thymeleaf網頁");
		model.addAttribute("today",new Date());
		return "th/thhome";
	}	
	@RequestMapping(value="/jsp", method = RequestMethod.GET)
	public String toJspHome(Model model) {
		List<Student> students = studentService.getAll();
		model.addAttribute("students", students);
		model.addAttribute("welcome", "這是Jsp網頁!!!!!!!!!!!!!!!");
		model.addAttribute("today",new Date());
		return "jsp/jsphome";
	}
	
	@GetMapping("getPlayer")
    @ResponseBody
    public Map<Integer, Student> test() {
        Map<Integer, Student> data = new HashMap<>();
        List<Student> students = studentService.getAll();
        for(Student s:students) {
        	data.put(s.getUserId(), s);
        }
        return data;
    }
	
	@RequestMapping("/vue")
	public String toVueHome(Model model) {
		String welcome="Spring框架是 Java 平台的一個開源的全棧（Full-stack）應用程式框架和控制反轉容器實現，一般被直接稱為 Spring";
		model.addAttribute("welcome", welcome);
		model.addAttribute("today",new Date());
		return "vue/thhome";
	}
}
