package com.hdsoft.JptAPI.HDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_movementline")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_movementLine {

	@Id
	@Column(name = "m_movementline_id")
	private long movementLineId;

	@Column(name = "m_locator_id")
	private long currentLocatorId;

	@Column(name = "m_locatorto_id")
	private long locatorToId;

	@Column(name = "m_product_id")
	private long productId;

	@Column(name = "movementqty")
	private double quantity;

	@Column(name = "m_attributesetinstance_id")
	private long attributeSetId;

	@Column(name = "m_movement_id")
	private long movementId;

	private String m_movementline_uu;
	public String getM_movementline_uu() {
		return m_movementline_uu;
	}

	public void setM_movementline_uu(String m_movementline_uu) {
		this.m_movementline_uu = m_movementline_uu;
	}

	public m_movementLine() {
		super();
	}

	public m_movementLine(long movementLineId, long currentLocatorId, long locatorToId, long productId, double quantity,
			long attributeSetId, long movementId) {
		super();
		this.movementLineId = movementLineId;
		this.currentLocatorId = currentLocatorId;
		this.locatorToId = locatorToId;
		this.productId = productId;
		this.quantity = quantity;
		this.attributeSetId = attributeSetId;
		this.movementId = movementId;
	}

	public long getMovementLineId() {
		return movementLineId;
	}

	public void setMovementLineId(long movementLineId) {
		this.movementLineId = movementLineId;
	}

	public long getCurrentLocatorId() {
		return currentLocatorId;
	}

	public void setCurrentLocatorId(long currentLocatorId) {
		this.currentLocatorId = currentLocatorId;
	}

	public long getLocatorToId() {
		return locatorToId;
	}

	public void setLocatorToId(long locatorToId) {
		this.locatorToId = locatorToId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public long getAttributeSetId() {
		return attributeSetId;
	}

	public void setAttributeSetId(long attributeSetId) {
		this.attributeSetId = attributeSetId;
	}

	public long getMovementId() {
		return movementId;
	}

	public void setMovementId(long movementId) {
		this.movementId = movementId;
	}

}
