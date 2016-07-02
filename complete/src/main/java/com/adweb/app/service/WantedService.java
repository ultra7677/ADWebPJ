package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;
import com.adweb.app.entity.Wanted;
import com.adweb.app.repository.WantedRepository;

@Service
public class WantedService {
	@Autowired WantedRepository wantedRepository;
	
	public Wanted create(Wanted wanted){
		this.wantedRepository.save(wanted);
		return wanted;
	}
	
	public List<Wanted> findByUser(User user){
		return this.wantedRepository.findByUser(user);
	}
	
	public List<Wanted> findByItem(Item item){
		return this.wantedRepository.findByItem(item);
	}
	
}
