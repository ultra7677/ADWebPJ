package com.adweb.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class MainController {
	 @RequestMapping(value = "/")
	 public String loadMainPage() 
	 {
		   	return "templates/scenepage.html";
	 }
	 
}
