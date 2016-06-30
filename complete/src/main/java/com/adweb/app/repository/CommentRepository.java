package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Comment;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;

public interface CommentRepository extends CrudRepository<Comment,Long>{
	
	List<Comment> findByItem(Item item);
	List<Comment> findByUser(User user);

}
