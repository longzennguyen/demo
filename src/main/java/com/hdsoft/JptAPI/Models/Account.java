package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ad_user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Account {

	@Column(name = "ad_user_id")
	@Id
	private int userId;

	@Column(name = "name")
	private String username;

	@Column(name = "password")
	private String password;

	private String email;

	@Column(name = "description")
	private String status;

	private String isactive;

	public Account() {
		super();
	}

	public Account(int userId, String username, String password, String email, String status, String isactive) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = status;
		this.isactive = isactive;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

}
