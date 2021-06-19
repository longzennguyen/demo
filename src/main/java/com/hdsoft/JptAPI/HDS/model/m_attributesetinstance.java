package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "m_attributesetinstance")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_attributesetinstance {
	@Id  
	@Column(name="m_attributesetinstance_id")
	private long id;
	@Column(name="ad_client_id")
	private long adclient;
	@Column(name="ad_org_id")
	private long adorgid;
	private Date created;
	private long createdby;
	private Date updated;
	private String description;
	private String lot;
	private long updatedby;
	private String m_attributesetinstance_uu;
	private String asinote;
	private String reuselevel;
	private Date guaranteedate;
	
	
	public Date getGuaranteedate() {
		return guaranteedate;
	}
	public void setGuaranteedate(Date guaranteedate) {
		this.guaranteedate = guaranteedate;
	}
	public String getReuselevel() {
		return reuselevel;
	}
	public void setReuselevel(String reuselevel) {
		this.reuselevel = reuselevel;
	}
	public String getAsinote() {
		return asinote;
	}
	public void setAsinote(String asinote) {
		this.asinote = asinote;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getM_attributesetinstance_uu() {
		return m_attributesetinstance_uu;
	}
	public void setM_attributesetinstance_uu(String m_attributesetinstance_uu) {
		this.m_attributesetinstance_uu = m_attributesetinstance_uu;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAdclient() {
		return adclient;
	}
	public void setAdclient(long adclient) {
		this.adclient = adclient;
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
	public m_attributesetinstance() {
		// TODO Auto-generated constructor stub
	}
}
