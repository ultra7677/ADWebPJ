package com.adweb.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true,nullable=false)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private long avatarid;

	public long getAvatarid() {
		return avatarid;
	}

	public void setAvatarid(long avatarid) {
		this.avatarid = avatarid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	

}
