package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ad_user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AdUser {

	@Id
	@Column(name = "ad_user_id")
	private long adUserId;

	@Column(name = "ad_client_id")
	private long clientId;

	@Column(name = "ad_org_id")
	private Long orgId;

	private String name;
	private String password;

	private String email;
	
	public AdUser() {
		super();
	}

	public AdUser(long adUserId, String email) {
		super();
		this.adUserId = adUserId;
		this.email = email;
	}

	public long getAdUserId() {
		return adUserId;
	}

	public void setAdUserId(long adUserId) {
		this.adUserId = adUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

}
