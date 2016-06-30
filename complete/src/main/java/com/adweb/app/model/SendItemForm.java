package com.adweb.app.model;

public class SendItemForm {
	private String name;
	private int oneStar;
	private int twoStar;
	private int threeStar;
	private int fourStar;
	private int fiveStar;
	private String baseContent;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOneStar() {
		return oneStar;
	}
	public void setOneStar(int oneStar) {
		this.oneStar = oneStar;
	}
	public int getTwoStar() {
		return twoStar;
	}
	public void setTwoStar(int twoStar) {
		this.twoStar = twoStar;
	}
	public int getThreeStar() {
		return threeStar;
	}
	public void setThreeStar(int threeStar) {
		this.threeStar = threeStar;
	}
	public int getFourStar() {
		return fourStar;
	}
	public void setFourStar(int fourStar) {
		this.fourStar = fourStar;
	}
	public int getFiveStar() {
		return fiveStar;
	}
	public void setFiveStar(int fiveStar) {
		this.fiveStar = fiveStar;
	}
	public String getBaseContent() {
		return baseContent;
	}
	public void setBaseContent(String baseContent) {
		this.baseContent = baseContent;
	}
}
