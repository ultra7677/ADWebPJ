package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.Location;

public interface ItemRepository  extends CrudRepository<Item,Long> {
	Item findByName(String name);

	Item findById(Long id);
	
	List<Item> findByLocation(Location location);
	
	List<Item> findAll();
}
