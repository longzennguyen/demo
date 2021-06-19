package com.hdsoft.JptAPI.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_movementline")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MMovementLine {

	@Id
	@Column(name = "m_movementline_id")
	private Long movementLineId;

	@Column(name = "m_locator_id")
	private Long currentLocatorId;

	@Column(name = "m_locatorto_id")
	private Long locatorToId;

	@Column(name = "m_product_id")
	private Long productId;

	@Column(name = "movementqty")
	private double quantity;

	@Column(name = "m_attributesetinstance_id")
	private Long attributeSetId;

	@Column(name = "m_movement_id")
	private Long movementId;
	
	private Long ad_client_id;
	private Long ad_org_id;
	private Date created;
	private Date updated;
	private Long createdby;
	private Long updatedby;
	private Long m_attributesetinstanceto_id;
	private Long c_uom_id;

	public Long getC_uom_id() {
		return c_uom_id;
	}

	public void setC_uom_id(Long c_uom_id) {
		this.c_uom_id = c_uom_id;
	}

	public Long getM_attributesetinstanceto_id() {
		return m_attributesetinstanceto_id;
	}

	public void setM_attributesetinstanceto_id(Long m_attributesetinstanceto_id) {
		this.m_attributesetinstanceto_id = m_attributesetinstanceto_id;
	}

	public Long getAd_org_id() {
		return ad_org_id;
	}

	public void setAd_org_id(Long ad_org_id) {
		this.ad_org_id = ad_org_id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public Long getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(Long updatedby) {
		this.updatedby = updatedby;
	}

	public Long getAd_client_id() {
		return ad_client_id;
	}

	public void setAd_client_id(Long ad_client_id) {
		this.ad_client_id = ad_client_id;
	}

	public MMovementLine() {
		super();
	}

	public MMovementLine(Long movementLineId, Long currentLocatorId, Long locatorToId, Long productId, double quantity,
			Long attributeSetId, Long movementId) {
		super();
		this.movementLineId = movementLineId;
		this.currentLocatorId = currentLocatorId;
		this.locatorToId = locatorToId;
		this.productId = productId;
		this.quantity = quantity;
		this.attributeSetId = attributeSetId;
		this.movementId = movementId;
	}

	public Long getMovementLineId() {
		return movementLineId;
	}

	public void setMovementLineId(Long movementLineId) {
		this.movementLineId = movementLineId;
	}

	public Long getCurrentLocatorId() {
		return currentLocatorId;
	}

	public void setCurrentLocatorId(Long currentLocatorId) {
		this.currentLocatorId = currentLocatorId;
	}

	public Long getLocatorToId() {
		return locatorToId;
	}

	public void setLocatorToId(Long locatorToId) {
		this.locatorToId = locatorToId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Long getAttributeSetId() {
		return attributeSetId;
	}

	public void setAttributeSetId(Long attributeSetId) {
		this.attributeSetId = attributeSetId;
	}

	public Long getMovementId() {
		return movementId;
	}

	public void setMovementId(Long movementId) {
		this.movementId = movementId;
	}

}
