package com.adweb.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {
	User findByUsername(String username);
	
}
