package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Location;
import com.adweb.app.repository.ItemRepository;
import com.adweb.app.repository.RatingRepository;

@Service
public class ItemService {
	@Autowired ItemRepository itemRepository;
	@Autowired RatingService ratingService;
	
	public Item create(Item item){
		this.itemRepository.save(item);
		return item;
	}
	
	public Item findById(long id){
		return this.itemRepository.findById(id);
	}
	
	public Item findByName(String name){
		return this.itemRepository.findByName(name);
	}
	
	public List<Item> findByLocation(Location location){
		return this.itemRepository.findByLocation(location);
	}
	
	public float getAverageRating(Item item){
		return this.ratingService.calculateAverageRatingForItem(item);
	}
	
	public List<Item> findAll(){
		return this.itemRepository.findAll();
	}
}
