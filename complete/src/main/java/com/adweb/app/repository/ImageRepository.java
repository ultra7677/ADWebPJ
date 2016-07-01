package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Comment;
import com.adweb.app.entity.Image;
import com.adweb.app.entity.Item;

public interface ImageRepository extends CrudRepository<Image,Long>{
	List<Image> findByItem(Item item);
	
	Image findByComment(Comment comment);
}
