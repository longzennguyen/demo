package com.hdsoft.JptAPI.Models;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WarehouseMovement {

	 
	private long productId;

	private String productName;

	private double quantityOnHand;

	private Date dateMaterialPolicy;

	private long attributeSetInstanceId;

	private String value;

	public WarehouseMovement() {
		super();
	}

	public WarehouseMovement(long productId, String productName, double quantityOnHand, Date dateMaterialPolicy,
			long attributeSetInstanceId, String value) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantityOnHand = quantityOnHand;
		this.dateMaterialPolicy = dateMaterialPolicy;
		this.attributeSetInstanceId = attributeSetInstanceId;
		this.value = value;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public long getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(long attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
