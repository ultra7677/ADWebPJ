package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Comment;
import com.adweb.app.entity.Image;
import com.adweb.app.entity.Item;
import com.adweb.app.repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired ImageRepository itemRepository;
	
	public Image create(Image image){
		this.itemRepository.save(image);
		return image;
	}
	
	public Image findByFilename(String filename){
		return this.itemRepository.findByFilename(filename);
	}
	
	public List<Image> findByItem(Item item){
		return this.itemRepository.findByItem(item);
	}
	


}
