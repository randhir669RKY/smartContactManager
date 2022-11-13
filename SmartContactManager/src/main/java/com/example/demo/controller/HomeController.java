package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepo;
import com.example.demo.entity.User;
import com.example.demo.helper.Message;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userrepo;
	
	
	@RequestMapping("/server")
	public String serverport() {
		
		return  "";
	}

	@RequestMapping("/")
	public String base() {
		
		return  "base";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user",new User());
		return  "signup";
	}
	
	
	@PostMapping("/do_register")
	public String register(@ModelAttribute("user") User user, Model model,HttpSession session) {
		
		try {
			
			user.setRole("Role_User");
			user.setEnabled(true);
			user.setImageurl("default.png");
			user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		    User result= this.userrepo.save(user);
			System.out.println("User"+result);
			model.addAttribute("user", new User());
			session.setAttribute("message",new Message("Sucessfully Registered!!","alert-success"));
			
		}catch(Exception e) {
			
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something Went Wrong!!"+e.getMessage(),"alert-error"));
			
		}
		
		return  "signup";
	}
}
