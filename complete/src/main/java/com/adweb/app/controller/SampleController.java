package com.adweb.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.adweb.app.model.LoginForm;


@Controller 
public class SampleController 
{
	
	 
	 @RequestMapping(value = "/login.html")
	 public String loadLoginPage() 
	 {
		   	return "templates/index.html";
	 }
	 
	 
	 @RequestMapping(value = "/login")
	 public @ResponseBody Boolean loginRequest(@RequestBody LoginForm loginForm)
	 {
		System.out.println(loginForm.getUsername());
		System.out.println(loginForm.getPassword());
		// handle method
		return true;
	 }
		
}
	