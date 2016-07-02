package com.adweb.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.Comment;
import com.adweb.app.entity.Item;
import com.adweb.app.entity.Rating;
import com.adweb.app.entity.User;
import com.adweb.app.model.CommentForm;
import com.adweb.app.service.CommentService;
import com.adweb.app.service.ItemService;
import com.adweb.app.service.RatingService;
import com.adweb.app.service.UserService;

@Controller
public class CommentController {
	
	@Autowired RatingService ratingService;
	
	@Autowired ItemService itemService;
	
	@Autowired UserService userService;
	
	@Autowired CommentService commentService;
	
	@RequestMapping(value = "/addCommentToItem")
	public @ResponseBody void addComment(@RequestBody CommentForm commentForm){
		String username = commentForm.getUsername();
		String text = commentForm.getText();
		String imagename = commentForm.getImagename();
		int ratingValue = commentForm.getScore();
		
		User user = this.userService.findByUsername(username);
		Item item = this.itemService.findById(commentForm.getItemid());
		
		Rating rating = new Rating();
		rating.setItem(item);
		rating.setUser(user);
		rating.setRatingvalue(ratingValue);
		this.ratingService.create(rating);
		
		Comment comment = new Comment();
		comment.setItem(item);
		comment.setUser(user);
		comment.setRatingValue(ratingValue);
		comment.setText(text);
		comment.setImagename(imagename);
		
		this.commentService.create(comment);
	}
	
	//获取对于一个item的所有评价
	@RequestMapping(value = "/getCommentListByItem/{itemid}")
	public @ResponseBody List<CommentForm> getCommentListById(@PathVariable long itemid){
		Item item = this.itemService.findById(itemid);
		List<Comment> commentList = this.commentService.findByItem(item);
		List<CommentForm> commentFormList = new ArrayList<CommentForm>();
		for(Comment comment : commentList){
			CommentForm commentForm = new CommentForm();
			commentForm.setImagename(comment.getImagename());
			commentForm.setItemid(comment.getItem().getId());
			commentForm.setScore(comment.getRatingValue());
			commentForm.setText(comment.getText());
			commentForm.setUsername(comment.getUser().getUsername());
		
			commentFormList.add(commentForm);
		}
		return commentFormList;
	}
	
}
