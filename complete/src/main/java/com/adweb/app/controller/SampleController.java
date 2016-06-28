package com.adweb.app.controller;


import java.util.List;

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
	 
	 @RequestMapping(value = "/passObjectArray")
	 public @ResponseBody List<LoginForm> recieveObjectArray(@RequestBody List<LoginForm> jsonArray) throws Exception
	 {
		 for (LoginForm i:jsonArray)
	         System.out.println(i.getUsername());
          return jsonArray;
	 }
	
}
	