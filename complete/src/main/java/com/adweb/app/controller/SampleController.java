package com.adweb.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 
public class SampleController {
	
	 
	 @RequestMapping(value = "/")
	 public String loadLoginPage() {
		   	return "templates/index.html";
	 }
	 
	 
		
}
