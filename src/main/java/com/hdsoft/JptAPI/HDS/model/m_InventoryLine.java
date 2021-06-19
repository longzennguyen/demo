package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "m_inventoryline")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_InventoryLine {
	@Id
	@Column(name="m_inventoryline_id")
	private long id;
	@Column(name="ad_client_id")
	private long adclientid;
	private long ad_org_id;
	private Timestamp created;
	private Timestamp updated;
	private long createdby;
	private long updatedby;
	private long m_inventory_id;
	private long m_locator_id;
	private long m_product_id;
	private long line;
	private double qtybook;
	private double qtycount;
	private long m_attributesetinstance_id;
	private String inventorytype;
	private String processed;
	private String m_inventoryline_uu;
	public long getM_inventoryline_id() {
		return id;
	}
	public void setM_inventoryline_id(long id) {
		this.id = id;
	}
	public long getAdclientid() {
		return adclientid;
	}
	public void setAdclientid(long adclientid) {
		this.adclientid = adclientid;
	}
	public long getAd_org_id() {
		return ad_org_id;
	}
	public void setAd_org_id(long ad_org_id) {
		this.ad_org_id = ad_org_id;
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
	public long getM_inventory_id() {
		return m_inventory_id;
	}
	public void setM_inventory_id(long m_inventory_id) {
		this.m_inventory_id = m_inventory_id;
	}
	public long getM_locator_id() {
		return m_locator_id;
	}
	public void setM_locator_id(long m_locator_id) {
		this.m_locator_id = m_locator_id;
	}
	public long getM_product_id() {
		return m_product_id;
	}
	public void setM_product_id(long m_product_id) {
		this.m_product_id = m_product_id;
	}
	public long getLine() {
		return line;
	}
	public void setLine(long line) {
		this.line = line;
	}
	public double getQtybook() {
		return qtybook;
	}
	public void setQtybook(double qtybook) {
		this.qtybook = qtybook;
	}
	public double getQtycount() {
		return qtycount;
	}
	public void setQtycount(double qtycount) {
		this.qtycount = qtycount;
	}
	public long getM_attributesetinstance() {
		return m_attributesetinstance_id;
	}
	public void setM_attributesetinstance(long m_attributesetinstance) {
		this.m_attributesetinstance_id = m_attributesetinstance;
	}
	public String getInventorytype() {
		return inventorytype;
	}
	public void setInventorytype(String inventorytype) {
		this.inventorytype = inventorytype;
	}
	public String getProcessed() {
		return processed;
	}
	public void setProcessed(String processed) {
		this.processed = processed;
	}
	public String getM_inventoryline_uu() {
		return m_inventoryline_uu;
	}
	public void setM_inventoryline_uu(String m_inventoryline_uu) {
		this.m_inventoryline_uu = m_inventoryline_uu;
	}
	
}
