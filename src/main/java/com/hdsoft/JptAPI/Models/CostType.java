package com.hdsoft.JptAPI.Models;


import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "ff_costtype")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CostType {
	@Id
	private int ff_costtype_id;

	private int ad_client_id;
	private int ad_org_id;
	private int createdby;
	private char isactive;
	private String name;
	private int updatedby;
	private String value;
	private char processed;
	private String ff_costcategory;

	public CostType() {

	}
	
	

	public int getFf_costtype_id() {
		return ff_costtype_id;
	}

	public void setFf_costtype_id(int ff_costtype_id) {
		this.ff_costtype_id = ff_costtype_id;
	}

	public int getAd_client_id() {
		return ad_client_id;
	}

	public void setAd_client_id(int ad_client_id) {
		this.ad_client_id = ad_client_id;
	}

	public int getAd_org_id() {
		return ad_org_id;
	}

	public void setAd_org_id(int ad_org_id) {
		this.ad_org_id = ad_org_id;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public char getIsactive() {
		return isactive;
	}

	public void setIsactive(char isactive) {
		this.isactive = isactive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public char getProcessed() {
		return processed;
	}

	public void setProcessed(char processed) {
		this.processed = processed;
	}

	public String getFf_costcategory() {
		return ff_costcategory;
	}

	public void setFf_costcategory(String ff_costcategory) {
		this.ff_costcategory = ff_costcategory;
	}

}
