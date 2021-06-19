package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HDSerialBack {
	
	private long orderlineId;
	private long productId;
	private String productName;
	private double qtyScanned;
	private double qtyBack;
	private double qty;
	
	public long getOrderlineId() {
		return orderlineId;
	}
	public void setOrderlineId(long orderlineId) {
		this.orderlineId = orderlineId;
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
	public double getQtyScanned() {
		return qtyScanned;
	}
	public void setQtyScanned(double qtyScanned) {
		this.qtyScanned = qtyScanned;
	}
	public double getQtyBack() {
		return qtyBack;
	}
	public void setQtyBack(double qtyBack) {
		this.qtyBack = qtyBack;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}


}
