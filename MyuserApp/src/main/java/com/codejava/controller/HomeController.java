package com.codejava.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codejava.model.UserDtls;
import com.codejava.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		//System.out.println("hello");
		return "register";
	}
	
	@PostMapping("/createUser")
	public String creteuser(@ModelAttribute UserDtls user,HttpSession session) {
		//System.out.println(user);
		
		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");

		}else {
			UserDtls userDtls=userService.creteUser(user);
			if(userDtls !=null) {
				session.setAttribute("msg","registration successfull");
			}else {
				session.setAttribute("msg","registration faild");
			}
		}
		
		
		
		return "redirect:/register";
	}
}
