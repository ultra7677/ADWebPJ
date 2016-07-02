package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Footstep;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;
import com.adweb.app.repository.FootstepRepository;

@Service
public class FootstepService {
	@Autowired FootstepRepository footstepRepository;
	
	public Footstep create(Footstep footstep){
		this.footstepRepository.save(footstep);
		return footstep;
	}
	
	public List<Footstep> findByUser(User user){
		return this.footstepRepository.findByUser(user);
	}
	
	public List<Footstep> findByItem(Item item){
		return this.footstepRepository.findByItem(item);
	}
	
}
