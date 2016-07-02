package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;
import com.adweb.app.entity.Wanted;

public interface WantedRepository extends CrudRepository<Wanted,Long> {
	List<Wanted> findByItem(Item item);
	List<Wanted> findByUser(User user);
	
	Wanted findByItemAndUser(Item item,User user);
}
