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
import com.adweb.app.entity.Wanted;
import com.adweb.app.repository.WantedRepository;
import com.adweb.app.service.ItemService;
import com.adweb.app.service.UserService;

@Controller
public class WantedController {
	@Autowired UserService userService;
	
	@Autowired ItemService itemService;
	
	@Autowired WantedRepository wantedRepository;
	
	@RequestMapping(value="/deleteWanted")
	public @ResponseBody void deleteWanted(@RequestBody CollectForm collectForm){
		String username = collectForm.getUsername();
		String itemname = collectForm.getItemname();
		User user = this.userService.findByUsername(username);
		Item item = this.itemService.findByName(itemname);
		
		Wanted wanted = this.wantedRepository.findByItemAndUser(item, user);
		this.wantedRepository.delete(wanted);
	}
}
