package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Share;
import com.adweb.app.entity.User;
import com.adweb.app.repository.ShareRepository;

@Service
public class ShareService {
	
	@Autowired ShareRepository shareRepository;
	
	public Share create(Share share){
		this.shareRepository.save(share);
		return share;
	}
	
	public List<Share> findByUser(User user){
		return this.shareRepository.findByUser(user);
	}
	
	public List<Share> findByItem(Item item){
		return this.shareRepository.findByItem(item);
	}
}
