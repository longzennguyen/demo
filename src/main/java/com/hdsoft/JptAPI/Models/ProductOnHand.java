package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductOnHand {

	 
	private long attributeSetInstanceId;
	private String ASI;
	private long productId;
	private String productName;
	private long locatorId;
	private String locatorName;
	private double quantityOnHand;

	public ProductOnHand() {
		super();
	}

	public ProductOnHand(long attributeSetInstanceId, String aSI, long productId, String productName, long locatorId,
			String locatorName, double quantityOnHand) {
		super();
		this.attributeSetInstanceId = attributeSetInstanceId;
		ASI = aSI;
		this.productId = productId;
		this.productName = productName;
		this.locatorId = locatorId;
		this.locatorName = locatorName;
		this.quantityOnHand = quantityOnHand;
	}

	public long getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(long attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public String getASI() {
		return ASI;
	}

	public void setASI(String aSI) {
		ASI = aSI;
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

	public double getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(double quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

}
