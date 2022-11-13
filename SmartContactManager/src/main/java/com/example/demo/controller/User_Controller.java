package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/user")
public class User_Controller {
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		
		return"normal/user_dashboard";
	}
	
	

}
