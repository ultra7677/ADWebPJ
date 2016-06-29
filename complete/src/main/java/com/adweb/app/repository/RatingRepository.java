package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Rating;
import com.adweb.app.entity.User;

public interface RatingRepository extends CrudRepository<Rating,Long>{
	List<Rating> findByItem(Item item);
	List<Rating> findByUser(User user);
}
