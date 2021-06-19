package com.hdsoft.JptAPI.HDS.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity(name = "hds_pushnotification")
@Table(name = "hds_pushnotification")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class hds_pushnotification {
	@Id
	private long id;
	private String client_id;
	@Column(name = "serialnumber")
	private String username;
	@Column(name = "noidung")
	private String password;
	 
	private Boolean isdisplay;
	
	public long getId() {
		return id;
	}
	
	public Boolean isIsdisplay() {
		return isdisplay;
	}
	public void setIsdisplay(Boolean isdisplay) {
		this.isdisplay = isdisplay;
	}
	public void setId(long id) {
		this.id = id;
	}
	public hds_pushnotification() {
		// TODO Auto-generated constructor stub
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
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

	public hds_pushnotification(String client_id, String serialNumber,long id,String noidung,Boolean isdisplay) {
		super();
		this.client_id = client_id;
		this.username = serialNumber;
		this.id = id;
		this.isdisplay = isdisplay;
		this.password = noidung;
	}
	
}
