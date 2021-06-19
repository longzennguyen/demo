package com.hdsoft.JptAPI.Models;

public class ProductMovement {

	private long productId;

	private double qty;

	private long movementId;
	private long movementlineId;

	public ProductMovement() {
		super();
	}

	public ProductMovement(long productId, double qty, long movementId, long movementlineId) {
		super();
		this.productId = productId;
		this.qty = qty;
		this.movementId = movementId;
		this.movementlineId = movementlineId;
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

}
