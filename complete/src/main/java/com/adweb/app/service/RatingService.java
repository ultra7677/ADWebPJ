package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Rating;
import com.adweb.app.entity.User;
import com.adweb.app.repository.RatingRepository;

@Service
public class RatingService {
	
	@Autowired RatingRepository ratingRepository;
	
	public Rating create(Rating rating){
		this.ratingRepository.save(rating);
		return rating;
	}
	
	public List<Rating> findByUser(User user){
		return this.ratingRepository.findByUser(user);
	}
	
	public List<Rating> findByItem(Item item){
		return this.ratingRepository.findByItem(item);
	}
	
	public List<Rating> findAll(){
		return this.ratingRepository.findAll();
	}
	
	public float calculateAverageRatingForItem(Item item){
		int sum = 0;
		int totalNum = 0;
		for (Rating rating : this.ratingRepository.findByItem(item)){
			sum += rating.getRatingvalue();
			totalNum ++;
		}
		return (float)sum/totalNum;
	}
	
	public int calculateFiveStarCountForItem(Item item){
		int totalNum = 0;
		for (Rating rating : this.ratingRepository.findByItem(item))
			if (rating.getRatingvalue() == 5)	totalNum ++;	
		return totalNum;
	}
	
	public int calculateFourStarCountForItem(Item item){
		int totalNum = 0;
		for (Rating rating : this.ratingRepository.findByItem(item))
			if (rating.getRatingvalue() == 4)	totalNum ++;	
		return totalNum;
	}
	
	public int calculateThreeStarCountForItem(Item item){
		int totalNum = 0;
		for (Rating rating : this.ratingRepository.findByItem(item))
			if (rating.getRatingvalue() == 3)	totalNum ++;	
		return totalNum;
	}
	
	public int calculateTwoStarCountForItem(Item item){
		int totalNum = 0;
		for (Rating rating : this.ratingRepository.findByItem(item))
			if (rating.getRatingvalue() == 2)	totalNum ++;	
		return totalNum;
	}
	
	public int calculateOneStarCountForItem(Item item){
		int totalNum = 0;
		for (Rating rating : this.ratingRepository.findByItem(item))
			if (rating.getRatingvalue() == 1)	totalNum ++;	
		return totalNum;
	}
}
