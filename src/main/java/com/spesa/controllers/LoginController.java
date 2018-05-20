package com.spesa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spesa.form.LoginForm;
import com.spesa.master.service.LoginService;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	

	@RequestMapping("/login")
	public String getLoginPage(@ModelAttribute("loginForm") LoginForm loginForm) {
		logger.info("Start of getLoginPage login service {}",loginService);
		return "login";
	}
	
	@RequestMapping(value="/submitLogin", method=RequestMethod.POST)
	public String postLoginPage(@ModelAttribute("loginForm") LoginForm loginForm) {
		logger.info("Start of postLoginPage");
		return "login";
	}
	
	
}
