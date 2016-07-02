package com.adweb.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.CollectForm;
import com.adweb.app.entity.Footstep;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;
import com.adweb.app.repository.FootstepRepository;
import com.adweb.app.service.FootstepService;
import com.adweb.app.service.ItemService;
import com.adweb.app.service.UserService;

@Controller
public class FootstepController {
	@Autowired UserService userService;
	
	@Autowired ItemService itemService;
	
	@Autowired FootstepService footstepService;
	
	@Autowired FootstepRepository footstepRepository;
	
	@RequestMapping(value="/deleteFootstep")
	public @ResponseBody void deleteCollect(@RequestBody CollectForm collectForm){
		String username = collectForm.getUsername();
		String itemname = collectForm.getItemname();
		User user = this.userService.findByUsername(username);
		Item item = this.itemService.findByName(itemname);
		
		Footstep footstep = this.footstepRepository.findByItemAndUser(item, user);
		this.footstepRepository.delete(footstep);
	}
}
