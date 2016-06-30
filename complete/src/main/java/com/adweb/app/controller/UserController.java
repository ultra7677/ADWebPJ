package com.adweb.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.adweb.app.entity.User;
import com.adweb.app.model.LoginForm;
import com.adweb.app.model.SendLoginForm;
import com.adweb.app.service.UserService;

@Controller

public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	public @ResponseBody SendLoginForm loginRequest(@RequestBody LoginForm loginForm){
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		SendLoginForm sendLoginForm = new SendLoginForm();
		
		if (!this.userService.exist(username)){
			sendLoginForm.setStatus(0);
			return sendLoginForm;
		}
			
		User user = this.userService.findByUsername(username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(password, user.getPassword())){
			sendLoginForm.setStatus(1);
		}else sendLoginForm.setStatus(-1);
		
		return sendLoginForm;
	}
	
	@RequestMapping(value="/register")
	public @ResponseBody SendLoginForm registerRequest(@RequestBody LoginForm registerForm){
		String username = registerForm.getUsername();
		String password = registerForm.getPassword();
		SendLoginForm sendRegisterForm = new SendLoginForm();
		
		if(this.userService.exist(username)){
			sendRegisterForm.setStatus(-1);
			return sendRegisterForm;
		}
		
		User user = new User();
		user.setUsername(username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(password));
		
		this.userService.create(user);
		
		sendRegisterForm.setStatus(1);
	    return sendRegisterForm;
	}
}
