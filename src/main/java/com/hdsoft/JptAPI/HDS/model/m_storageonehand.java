package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "m_storageonhand")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_storageonehand {
//	@Id
	@Column(name="ad_client_id")
	private long adclientid;
	private Date created;
	private long createdby;
	private Date updated;
	private long updatedby;
	@Column(name="m_attributesetinstance_id")
	private Long asiid;
	@Column(name="m_locator_id")
	private long locatorid;
	@Column(name="m_product_id")
	private long productid;
	private double qtyonhand;
	@Column(name="ad_org_id")
	private long adorgid;
	private Timestamp datematerialpolicy;
	@Id
	private String m_storageonhand_uu;


	public String getM_storageonhand_uu() {
		return m_storageonhand_uu;
	}



	public void setM_storageonhand_uu(String m_storageonhand_uu) {
		this.m_storageonhand_uu = m_storageonhand_uu;
	}



	public Timestamp getDatematerialpolicy() {
		return datematerialpolicy;
	}



	public void setDatematerialpolicy(Timestamp localDate) {
		this.datematerialpolicy = localDate;
	}



	public long getAd_org_id() {
		return adorgid;
	}



	public void setAd_org_id(long ad_org_id) {
		this.adorgid = ad_org_id;
	}



	public long getId() {
		return adclientid;
	}
	public void setId(long id) {
		this.adclientid = id;
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
	
	public Long getAsiid() {
		return asiid;
	}
	public void setAsiid(Long asiid) {
		this.asiid = asiid;
	}
	public long getLocatorid() {
		return locatorid;
	}
	public void setLocatorid(long locatorid) {
		this.locatorid = locatorid;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public Double getQtyonhand() {
		return qtyonhand;
	}
	public void setQtyonhand(Double qtyonhand) {
		this.qtyonhand = qtyonhand;
	}
	
	
}
