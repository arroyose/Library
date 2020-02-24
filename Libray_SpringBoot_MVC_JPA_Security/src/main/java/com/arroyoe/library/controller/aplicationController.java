package com.arroyoe.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arroyoe.library.model.Book;
import com.arroyoe.library.security.users.UserDetailsServiceImpl;

@Controller
public class aplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(aplicationController.class);
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		logger.info("-- Start App in / point");
		return new ModelAndView("redirect:/index");	
	}	
	
	
	@GetMapping({"/login"})
	public String login() {
		return "login";
	}
	
	/*
	@RequestMapping(value = "/adminIndex", method = RequestMethod.POST)
	public String adminIndex() {
		return "adminIndex";
	}*/
	
}
