package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StorageOnHandNoAttribute {
	
	
	private long locatorId;
	private String locatorName;
	private long productId;
	private String productName;
	private Double sumQty;
 
	public StorageOnHandNoAttribute() {
		super();
	}

	public StorageOnHandNoAttribute(long locatorId, String locatorName, long productId, String productName,
			Double sumQty) {
		super();
		this.locatorId = locatorId;
		this.locatorName = locatorName;
		this.productId = productId;
		this.productName = productName;
		this.sumQty = sumQty;
	}

	public long getLocatorId() {
		return locatorId;
	}

	public void setLocatorId(long locatorId) {
		this.locatorId = locatorId;
	}

	public String getLocatorName() {
		return locatorName;
	}

	public void setLocatorName(String locatorName) {
		this.locatorName = locatorName;
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

	public Double getSumQty() {
		return sumQty;
	}

	public void setSumQty(Double sumQty) {
		this.sumQty = sumQty;
	}

}
