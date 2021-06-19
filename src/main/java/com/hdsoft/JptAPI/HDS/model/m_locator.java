package com.hdsoft.JptAPI.HDS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "m_locator")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_locator {
	@Id
	@Column(name = "m_locator_id")
	private long id;
	@Column(name = "ad_client_id")
	private long adclientid;
	@Column(name = "ad_org_id")
	private long adorgid;
	private Date created;
	private long createdby;
	private Date updated;
	private long updatedby;
	private String value; // Search theo value
	private String name;
	private String m_locator_uu;
	@Column(name = "m_warehouse_id")
	private long warehouseid;
	private long priorityno;
	public long getPriorityno() {
		return priorityno;
	}

	public void setPriorityno(long priorityno) {
		this.priorityno = priorityno;
	}

	public long getM_warehouse_id() {
		return warehouseid;
	}

	public void setM_warehouse_id(long m_warehouse_id) {
		this.warehouseid = m_warehouse_id;
	}

	public String getM_locator_uu() {
		return m_locator_uu;
	}

	public void setM_locator_uu(String m_locator_uu) {
		this.m_locator_uu = m_locator_uu;
	}

	public m_locator() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAd_client_id() {
		return adclientid;
	}

	public void setAd_client_id(long ad_client_id) {
		this.adclientid = ad_client_id;
	}

	public long getAd_org_id() {
		return adorgid;
	}

	public void setAd_org_id(long ad_org_id) {
		this.adorgid = ad_org_id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
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
}
