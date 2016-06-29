package com.adweb.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.User;
import com.adweb.app.model.LoginForm;
import com.adweb.app.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public @ResponseBody void loginRequest(@RequestBody LoginForm loginForm)
	{
		
	}
}
