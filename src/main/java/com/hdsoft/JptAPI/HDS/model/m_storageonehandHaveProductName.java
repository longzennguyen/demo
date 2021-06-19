package com.hdsoft.JptAPI.HDS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class m_storageonehandHaveProductName {

	private Long id;
	private Date created;
	private Long createdby;
	private Date updated;
	private Long updatedby;
	private Long asiid;
	private String asiName;
	private Long locatorid;
	private String locatorName;
	private Long productid;
	private Double qtyonhand;
	private String productName;
	private String note;
	private String uu;

	public String getUu() {
		return uu;
	}

	public void setUu(String uu) {
		this.uu = uu;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAsiName() {
		return asiName;
	}

	public void setAsiName(String asiName) {
		this.asiName = asiName;
	}

	public String getLocatorName() {
		return locatorName;
	}

	public void setLocatorName(String locatorName) {
		this.locatorName = locatorName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Long getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(Long updatedby) {
		this.updatedby = updatedby;
	}

	public Long getAsiid() {
		return asiid;
	}

	public void setAsiid(Long asiid) {
		this.asiid = asiid;
	}

	public Long getLocatorid() {
		return locatorid;
	}

	public void setLocatorid(Long locatorid) {
		this.locatorid = locatorid;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Double getQtyonhand() {
		return qtyonhand;
	}

	public void setQtyonhand(Double qtyonhand) {
		this.qtyonhand = qtyonhand;
	}

	public m_storageonehandHaveProductName() {
		// TODO Auto-generated constructor stub
	}
}
