package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Orderback {

	 
	private long orderId;

	private long orderlineId;

	private long productId;
	private String productName;

	private Double qty;

	public Orderback() {
		super();
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

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

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

}
