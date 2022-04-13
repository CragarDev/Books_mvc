package com.cragardev.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	private String index() {
		// TODO Auto-generated method stub
		
		return "index.jsp";

	}
	
	@RequestMapping("/home")
	private String home() {
		// TODO Auto-generated method stub
		
		return "index.jsp";
		
	}
}
