package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "m_product_category")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class M_Product_CategoryCModel {
	@Id
	@Column(name="m_product_category_id")
	private long id;
	private String value;
	private String name;
	@Column(name="ad_org_id")
	private long adorgid;
	private long ad_client_id;
	private String m_product_category_uu;
	private Timestamp created;
	private Timestamp updated;
	private long createdby;
	private long updatedby;
	private long plannedmargin;
	
	
	
	public long getPlannedmargin() {
		return plannedmargin;
	}
	public void setPlannedmargin(long plannedmargin) {
		this.plannedmargin = plannedmargin;
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
	public long getAd_client_id() {
		return ad_client_id;
	}
	public void setAd_client_id(long ad_client_id) {
		this.ad_client_id = ad_client_id;
	}
	public String getM_product_category_uu() {
		return m_product_category_uu;
	}
	public void setM_product_category_uu(String m_product_category_uu) {
		this.m_product_category_uu = m_product_category_uu;
	}
	public long getAdorgid() {
		return adorgid;
	}
	public void setAdorgid(long adorgid) {
		this.adorgid = adorgid;
	}
	public long getM_product_category_id() {
		return id;
	}
	public void setM_product_category_id(long m_product_category_id) {
		this.id = m_product_category_id;
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
