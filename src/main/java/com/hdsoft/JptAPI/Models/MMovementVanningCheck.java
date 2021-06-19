package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MMovementVanningCheck {

	
	private long productId;
	private String productName;
	private long orderId;
	private long orderlineId;
	private double orderQty;
	private long movementId;
	private long movementlineId;
	private double movementQty;
	private double diffQty;

	public MMovementVanningCheck() {
		super();
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

	public double getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(double orderQty) {
		this.orderQty = orderQty;
	}

	public long getMovementId() {
		return movementId;
	}

	public void setMovementId(long movementId) {
		this.movementId = movementId;
	}

	public long getMovementlineId() {
		return movementlineId;
	}

	public void setMovementlineId(long movementlineId) {
		this.movementlineId = movementlineId;
	}

	public double getMovementQty() {
		return movementQty;
	}

	public void setMovementQty(double movementQty) {
		this.movementQty = movementQty;
	}

	public double getDiffQty() {
		return diffQty;
	}

	public void setDiffQty(double diffQty) {
		this.diffQty = diffQty;
	}

}
