package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Footstep;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;

public interface FootstepRepository extends CrudRepository<Footstep,Long>{
	List<Footstep> findByItem(Item item);
	List<Footstep> findByUser(User user);
	
	Footstep findByItemAndUser(Item item,User user);
}
