package com.adweb.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Tag;
import com.adweb.app.model.GetTagForm;
import com.adweb.app.model.TagForm;
import com.adweb.app.service.ItemService;
import com.adweb.app.service.TagService;

@Controller
public class TagController {
	@Autowired TagService tagService;
	@Autowired ItemService itemService;
	
	//前端传来tag信息，存储到数据库
	@RequestMapping(value="/sendTag")
	public @ResponseBody void sendTag(@RequestBody TagForm tagForm){
		
		Item item = this.itemService.findById(tagForm.getItemid());
		
		Tag tagObj = new Tag();
		tagObj.setTop(tagForm.getTop());
		tagObj.setTag(tagForm.getTag());
		tagObj.setLeft(tagForm.getLeft());
		tagObj.setKind(tagForm.getKind());
		tagObj.setItem(item);
		tagObj.setType(tagForm.getType());
		this.tagService.create(tagObj);
	}
	
	//根据kind生成tagList
	@RequestMapping(value="/receiveTags/{itemid}")
	public @ResponseBody List<TagForm> getTagListByKind(@PathVariable long itemid){
		Item item = this.itemService.findById(itemid);
		List<Tag> tagList = this.tagService.findByItem(item);
		List<TagForm> sendTagList= new ArrayList<TagForm>();
		
		for(Tag tag : tagList){
			TagForm tagForm = new TagForm();
			tagForm.setItemid(tag.getId());
			tagForm.setKind(tagForm.getKind());
			tagForm.setLeft(tag.getLeft());
			tagForm.setTop(tag.getTop());
			tagForm.setType(tag.getType());
			tagForm.setTag(tag.getTag());
			sendTagList.add(tagForm);
		}
		
		return sendTagList;
	}
	
}
