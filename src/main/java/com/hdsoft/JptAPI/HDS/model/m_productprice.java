package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "m_productprice")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_productprice {
	
	@Id
	@Column(name="m_productprice_id")
	private long id;
	private long pricelist;
	private long pricestd;
	@Column(name="m_product_id")
	private long productid;
	@Column(name="ad_org_id")
	private long orgid;
	private String m_productprice_uu;
	private Timestamp created;
	private Timestamp updated;
	private long createdby;
	private long updatedby;
	private long ad_client_id;
	private long m_pricelist_version_id;
	
	
	public long getAd_client_id() {
		return ad_client_id;
	}
	public void setAd_client_id(long ad_client_id) {
		this.ad_client_id = ad_client_id;
	}
	public long getM_pricelist_version_id() {
		return m_pricelist_version_id;
	}
	public void setM_pricelist_version_id(long m_pricelist_version_id) {
		this.m_pricelist_version_id = m_pricelist_version_id;
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
	public String getM_productprice_uu() {
		return m_productprice_uu;
	}
	public void setM_productprice_uu(String m_productprice_uu) {
		this.m_productprice_uu = m_productprice_uu;
	}
	public long getM_productprice_id() {
		return id;
	}
	public void setM_productprice_id(long m_productprice_id) {
		this.id = m_productprice_id;
	}
	public long getPricelist() {
		return pricelist;
	}
	public void setPricelist(long pricelist) {
		this.pricelist = pricelist;
	}
	public long getPricestd() {
		return pricestd;
	}
	public void setPricestd(long pricestd) {
		this.pricestd = pricestd;
	}
	public long getM_product_id() {
		return productid;
	}
	public void setM_product_id(long m_product_id) {
		this.productid = m_product_id;
	}
	public long getOrgid() {
		return orgid;
	}
	public void setOrgid(long orgid) {
		this.orgid = orgid;
	}
	
}
