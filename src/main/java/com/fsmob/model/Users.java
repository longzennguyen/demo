package com.fsmob.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Users {
	@Id
	private long userid;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String role;
	private boolean isactive;
	private String token;
	private Timestamp lastlogin;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}
}
