package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Tag;
import com.adweb.app.repository.TagRepository;

@Service
public class TagService {
	@Autowired TagRepository tagRepository;
	
	public Tag create(Tag tag){
		this.tagRepository.save(tag);
		return tag;
	}
	
	public List<Tag> findByItem(Item item){
		return this.tagRepository.findByItem(item);
	}
	
}
