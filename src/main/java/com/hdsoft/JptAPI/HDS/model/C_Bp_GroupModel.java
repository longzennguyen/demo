package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_bp_group")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class C_Bp_GroupModel {
	@Id
	@Column(name="c_bp_group_id")
	private long id;
	private long ad_client_id;
	@Column(name="ad_org_id")
	private long adorgid;
	private Timestamp created;
	private Timestamp updated;
	private long createdby;
	private long updatedby;
	private String value;
	private String name;
	private String c_bp_group_uu;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAd_client_id() {
		return ad_client_id;
	}
	public void setAd_client_id(long ad_client_id) {
		this.ad_client_id = ad_client_id;
	}
	public long getAdorgid() {
		return adorgid;
	}
	public void setAdorgid(long adorgid) {
		this.adorgid = adorgid;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(long createdby) {
		this.createdby = createdby;
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
	public String getC_bp_group_uu() {
		return c_bp_group_uu;
	}
	public void setC_bp_group_uu(String c_bp_group_uu) {
		this.c_bp_group_uu = c_bp_group_uu;
	}
	
}
