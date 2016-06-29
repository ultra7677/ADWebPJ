package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Collect;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;

public interface CollectRepository  extends CrudRepository<Collect,Long>{
	List<Collect> findByItem(Item item);
	List<Collect> findByUser(User user);
}
