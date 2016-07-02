package com.adweb.app.model;

public class TagForm {
	private String tag;
	private int kind;
	private int left;
	private int top;
	private int type;
	
	private long itemid;
	
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	

}
