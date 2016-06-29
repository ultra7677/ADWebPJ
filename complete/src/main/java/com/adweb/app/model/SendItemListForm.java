package com.adweb.app.model;

public class SendItemListForm {
	long id;
	String name;
	float averageRating;
	int collect; 
	int footstep;
	int wanted;
	
	public int getWanted() {
		return wanted;
	}
	public void setWanted(int wanted) {
		this.wanted = wanted;
	}
	public int getFootstep() {
		return footstep;
	}
	public void setFootstep(int footstep) {
		this.footstep = footstep;
	}
	public int getCollect() {
		return collect;
	}
	public void setCollect(int collect) {
		this.collect = collect;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
	
}
