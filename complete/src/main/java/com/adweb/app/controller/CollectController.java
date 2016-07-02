package com.adweb.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.Collect;
import com.adweb.app.entity.CollectForm;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;
import com.adweb.app.repository.CollectRepository;
import com.adweb.app.service.CollectService;
import com.adweb.app.service.ItemService;
import com.adweb.app.service.UserService;

@Controller
public class CollectController {
	
	@Autowired CollectService collectService;
	
	@Autowired UserService userService;
	
	@Autowired ItemService itemService;
	
	@Autowired CollectRepository collectRepository;
	
	@RequestMapping(value="/deleteCollect")
	public @ResponseBody void deleteCollect(@RequestBody CollectForm collectForm){
		String username = collectForm.getUsername();
		String itemname = collectForm.getItemname();
		User user = this.userService.findByUsername(username);
		Item item = this.itemService.findByName(itemname);
		
		Collect collect = this.collectRepository.findByItemAndUser(item, user);
		this.collectRepository.delete(collect);
	}
}
