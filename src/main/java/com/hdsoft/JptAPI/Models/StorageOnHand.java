package com.hdsoft.JptAPI.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_storageonhand")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StorageOnHand {
	
	
	@Id
	@Column(name = "m_storageonhand_uu")
	private String UUID;

	@Column(name = "m_attributesetinstance_id")
	private long attributeSetInstanceId;

	@Column(name = "m_product_id")
	private long productId;

	@Column(name = "m_locator_id")
	private long locatorId;

	@Column(name = "qtyonhand")
	private double quantityOnHand;

	@Column(name = "datematerialpolicy")
	private Date dateMaterialPolicy;

	@Column(name = "ad_client_id")
	private Long clientId;

	public StorageOnHand(long attributeSetInstanceId, long locatorId, long productId, double quantityOnHand,
			Date dateMaterialPolicy) {
		super();
		this.attributeSetInstanceId = attributeSetInstanceId;
		this.locatorId = locatorId;
		this.productId = productId;
		this.quantityOnHand = quantityOnHand;
		this.dateMaterialPolicy = dateMaterialPolicy;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public StorageOnHand() {
		super();
	}

	public long getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(long attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public long getLocatorId() {
		return locatorId;
	}

	public void setLocatorId(long locatorId) {
		this.locatorId = locatorId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(double quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public Date getDateMaterialPolicy() {
		return dateMaterialPolicy;
	}

	public void setDateMaterialPolicy(Date dateMaterialPolicy) {
		this.dateMaterialPolicy = dateMaterialPolicy;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

}
