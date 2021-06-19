package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;
import java.util.Date;

public class TransactionInformation {
	private long m_transaction_id;
	private Timestamp created;
	private Long m_locator_id;
	private String locatorName;
	private Long m_product_id;
	private String productName;
	private Date movementdate;
	private Double movementqty;
	private String movementtype;
	private Long m_attributesetinstance_id;
	private String lot;
	public long getM_transaction_id() {
		return m_transaction_id;
	}
	public void setM_transaction_id(long m_transaction_id) {
		this.m_transaction_id = m_transaction_id;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Long getM_locator_id() {
		return m_locator_id;
	}
	public void setM_locator_id(Long m_locator_id) {
		this.m_locator_id = m_locator_id;
	}
	public String getLocatorName() {
		return locatorName;
	}
	public void setLocatorName(String locatorName) {
		this.locatorName = locatorName;
	}
	public Long getM_product_id() {
		return m_product_id;
	}
	public void setM_product_id(Long m_product_id) {
		this.m_product_id = m_product_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getMovementdate() {
		return movementdate;
	}
	public void setMovementdate(Date movementdate) {
		this.movementdate = movementdate;
	}
	public Double getMovementqty() {
		return movementqty;
	}
	public void setMovementqty(Double movementqty) {
		this.movementqty = movementqty;
	}
	public String getMovementtype() {
		return movementtype;
	}
	public void setMovementtype(String movementtype) {
		this.movementtype = movementtype;
	}
	public Long getM_attributesetinstance_id() {
		return m_attributesetinstance_id;
	}
	public void setM_attributesetinstance_id(Long m_attributesetinstance_id) {
		this.m_attributesetinstance_id = m_attributesetinstance_id;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	
}
