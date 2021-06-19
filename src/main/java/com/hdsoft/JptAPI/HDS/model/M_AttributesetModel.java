package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "m_attributeset")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class M_AttributesetModel {
	
	@Id
	private long m_attributeset_id;
	private String name;
	@Column(name="ad_org_id")
	private long adorgid;
	private long ad_client_id;
	private Timestamp created;
	private Timestamp updated;
	private long createdby;
	private long updatedby;
	private String m_attributeset_uu;
	
	public long getAd_client_id() {
		return ad_client_id;
	}
	public void setAd_client_id(long ad_client_id) {
		this.ad_client_id = ad_client_id;
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
	public String getM_attributeset_uu() {
		return m_attributeset_uu;
	}
	public void setM_attributeset_uu(String m_attributeset_uu) {
		this.m_attributeset_uu = m_attributeset_uu;
	}
	public long getAdorgid() {
		return adorgid;
	}
	public void setAdorgid(long adorgid) {
		this.adorgid = adorgid;
	}
	public long getM_attributeset_id() {
		return m_attributeset_id;
	}
	public void setM_attributeset_id(long m_attributeset_id) {
		this.m_attributeset_id = m_attributeset_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
