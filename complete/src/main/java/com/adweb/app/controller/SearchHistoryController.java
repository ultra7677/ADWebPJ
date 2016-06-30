package com.adweb.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.SearchHistory;
import com.adweb.app.entity.User;
import com.adweb.app.model.HistoryForm;
import com.adweb.app.service.ItemService;
import com.adweb.app.service.SearchHistoryService;
import com.adweb.app.service.UserService;

@Controller
public class SearchHistoryController {
	
	@Autowired SearchHistoryService searchHistoryService;
	
	@Autowired UserService userService;
	
	@Autowired ItemService itemService;
	
	//用户搜索过这个item
	@RequestMapping(value = "/sendSearchHistory")
	public @ResponseBody void sendSearchHistory(@RequestBody HistoryForm historyForm){
		String username = historyForm.getUsername();
		long itemId = historyForm.getItemId();
		
		User user = this.userService.findByUsername(username);
		Item item = this.itemService.findById(itemId);
		
		SearchHistory searchHistory = new SearchHistory();
		searchHistory.setItem(item);
		searchHistory.setUser(user);
		this.searchHistoryService.create(searchHistory);
		
	}
	
	
	
}
