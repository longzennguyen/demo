package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MWarehouseShipment {

	private long orderId;

	private String documentNo;

	private long productId;

	private String productName;

	private long locatorId;

	private String locatorName;

	private long asiId;

	private String asiName;

	private double qty;

	public MWarehouseShipment() {
		super();
	}

	public MWarehouseShipment(long orderId, String documentNo, long productId, String productName, long locatorId,
			String locatorName, long asiId, String asiName, double qty) {
		super();
		this.orderId = orderId;
		this.documentNo = documentNo;
		this.productId = productId;
		this.productName = productName;
		this.locatorId = locatorId;
		this.locatorName = locatorName;
		this.asiId = asiId;
		this.asiName = asiName;
		this.qty = qty;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
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

	public long getAsiId() {
		return asiId;
	}

	public void setAsiId(long asiId) {
		this.asiId = asiId;
	}

	public String getAsiName() {
		return asiName;
	}

	public void setAsiName(String asiName) {
		this.asiName = asiName;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

}
