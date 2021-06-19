package com.hdsoft.JptAPI.Models;

public class ProductCheck {

	private long productId;
	private double qty;
	private long asiId;

	public ProductCheck() {
		super();
	}

	public ProductCheck(long productId, double qty, long asiId) {
		super();
		this.productId = productId;
		this.qty = qty;
		this.asiId = asiId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public long getAsiId() {
		return asiId;
	}

	public void setAsiId(long asiId) {
		this.asiId = asiId;
	}

}
