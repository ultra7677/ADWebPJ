package com.adweb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Location;
import com.adweb.app.entity.User;
import com.adweb.app.service.ItemService;
import com.adweb.app.service.LocationService;
import com.adweb.app.service.UserService;

@Controller 
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired 
	private LocationService locationService;
	
	 @RequestMapping(value = "/test")
	 public String test() 
	 {
		   	System.out.println("This is for test");
		   	
		   	for (User user : this.userService.findAll()){
				System.out.println(user.getUsername());
			}
		   	
		    User user = this.userService.findByUsername("Razor");
		    System.out.println(user.getId());
		    
		    Item item = this.itemService.findByName("1933老杨坊");
		   	System.out.println(item.getId());
		   	System.out.println(this.itemService.getAverageRating(item));
		   	
		   	Location location = this.locationService.findByName("上海工业遗址");
		   	List<Item> itemList = this.itemService.findByLocation(location);
		   	for(Item itemObject : itemList){
		   		System.out.println(itemObject.getName());
		   	}
		   	
		   	return "This is for test";
	 }
}
