package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "ad_org")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Ad_OrgModel {
	
	@Id
	private long ad_org_id;
	@Column(name="ad_client_id")
	private long adclientid;
	private Timestamp created;
	private long createdby;
	private Timestamp updated;
	private long updatedby;
	private String value;
	private String name;
	private String issummary;
	private String ad_org_uu;
	public long getAd_org_id() {
		return ad_org_id;
	}
	public void setAd_org_id(long ad_org_id) {
		this.ad_org_id = ad_org_id;
	}
	public long getAdclientid() {
		return adclientid;
	}
	public void setAdclientid(long adclientid) {
		this.adclientid = adclientid;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public long getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(long updatedby) {
		this.updatedby = updatedby;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIssummary() {
		return issummary;
	}
	public void setIssummary(String issummary) {
		this.issummary = issummary;
	}
	public String getAd_org_uu() {
		return ad_org_uu;
	}
	public void setAd_org_uu(String ad_org_uu) {
		this.ad_org_uu = ad_org_uu;
	}
	
	
}
