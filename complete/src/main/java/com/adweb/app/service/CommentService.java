package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Comment;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.User;
import com.adweb.app.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired CommentRepository commentRepository;
	
	public Comment create(Comment comment){
		this.commentRepository.save(comment);
		return comment;
	}
	
	public List<Comment> findByUser(User user){
		return this.commentRepository.findByUser(user);
	}
	
	public List<Comment> findByItem(Item item){
		return this.commentRepository.findByItem(item);
	}
	
}
