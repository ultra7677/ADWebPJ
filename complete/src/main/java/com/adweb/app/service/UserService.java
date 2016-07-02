package com.adweb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.User;
import com.adweb.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired UserRepository userRepository;
	
	public User create(User user){
		this.userRepository.save(user);
		return user;
	}
		
	public boolean exist(String username){
		return this.userRepository.findByUsername(username) != null;
	}
	
	public Iterable<User> findAll(){
		return this.userRepository.findAll();
	}
	
	public User findByUsername(String username){
		return this.userRepository.findByUsername(username);
	}
	
}
