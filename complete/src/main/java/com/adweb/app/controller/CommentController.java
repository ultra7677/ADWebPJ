package com.adweb.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
