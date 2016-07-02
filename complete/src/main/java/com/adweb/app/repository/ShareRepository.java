package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Share;
import com.adweb.app.entity.User;

public interface ShareRepository extends CrudRepository<Share,Long>{
	List<Share> findByItem(Item item);
	List<Share> findByUser(User user);
}
