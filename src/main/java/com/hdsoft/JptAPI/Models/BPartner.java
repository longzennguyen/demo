package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_bpartner")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BPartner {

	@Id
	@Column(name = "c_bpartner_id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "ad_client_id")
	private Long clientId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	

}
