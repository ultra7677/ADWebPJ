package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Collect;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;
import com.adweb.app.repository.CollectRepository;

@Service
public class CollectService {
	@Autowired CollectRepository collectRepository;
	
	public Collect create(Collect collect){
		this.collectRepository.save(collect);
		return collect;
	}
	
	public List<Collect> findByUser(User user){
		return this.collectRepository.findByUser(user);
	}
	
	public List<Collect> findByItem(Item item){
		return this.collectRepository.findByItem(item);
	}
	
}
