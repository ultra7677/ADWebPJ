package com.adweb.app.model;

public class SendCommentForm {
	private long itemid;
	private long imageid;
	private String username;
	private int score;
	private String text;
	
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	public long getImageid() {
		return imageid;
	}
	public void setImageid(long imageid) {
		this.imageid = imageid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
