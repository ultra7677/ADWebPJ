package com.adweb.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Location;
import com.adweb.app.model.GetItemListForm;
import com.adweb.app.model.SendItemListForm;
import com.adweb.app.service.ItemService;
import com.adweb.app.service.LocationService;

@Controller
public class ItemController {

	@Autowired ItemService itemService;
	@Autowired LocationService locationService;
	
	@RequestMapping(value = "getItemList/averageRating")
	public @ResponseBody List<SendItemListForm> getItemListWithRating(@RequestBody GetItemListForm getItemListForm){
		Location location = this.locationService.findByName(getItemListForm.getLocationName());
		List<Item> itemList = this.itemService.findByLocation(location);
		return sort(itemList,0);
	}
	
	public List<SendItemListForm> sort(List<Item> itemList,int mode){
		List<SendItemListForm> sendItemListForm = new ArrayList<SendItemListForm>();
		
		for(Item item : itemList){
			SendItemListForm itemForm = new SendItemListForm();
			itemForm.setId(item.getId());
			itemForm.setName(item.getName());
			itemForm.setAverageRating(this.itemService.getAverageRating(item));
			sendItemListForm.add(itemForm);
		}
			
		// 按照AverageRating大小降序排序
		if (mode == 0){
			 for(int i=0;i<sendItemListForm.size();i++){  
		         for(int j=i+1;j<sendItemListForm.size();j++){  
			         if(sendItemListForm.get(i).getAverageRating() < sendItemListForm.get(j).getAverageRating()){  
			             swap(sendItemListForm,i,j);  
			         }  
			     }
			 }
		}
		return sendItemListForm;
	}
	
	public static void swap(List<SendItemListForm> list,int a, int b){
		SendItemListForm objectA = list.get(a);
		list.set(a, list.get(b));
		list.set(b, objectA);
	}
	
}
