package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.Tag;

public interface TagRepository extends CrudRepository<Tag,Long>{
	List<Tag> findByItem(Item item);
}
