package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MaterialReceipt {

	private long orderlineId;

	private long productId;

	private String productName;

	private int unitsperpack;

	private Double qtyOrder;

	private Double qtyCurrent;

	private Double qtyCheck;
	

	public MaterialReceipt() {

	}

	public MaterialReceipt(long orderlineId, long productId, String productName, int unitsperpack, Double qtyOrder,
			Double qtyCurrent, Double qtyCheck) {
		super();
		this.orderlineId = orderlineId;
		this.productId = productId;
		this.productName = productName;
		this.unitsperpack = unitsperpack;
		this.qtyOrder = qtyOrder;
		this.qtyCurrent = qtyCurrent;
		this.qtyCheck = qtyCheck;
	}

	public long getOrderlineId() {
		return orderlineId;
	}

	public void setOrderlineId(long orderlineId) {
		this.orderlineId = orderlineId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Double getQtyOrder() {
		return qtyOrder;
	}

	public void setQtyOrder(Double qtyOrder) {
		this.qtyOrder = qtyOrder;
	}

	public Double getQtyCurrent() {
		return qtyCurrent;
	}

	public void setQtyCurrent(Double qtyCurrent) {
		this.qtyCurrent = qtyCurrent;
	}

	public Double getQtyCheck() {
		return qtyCheck;
	}

	public void setQtyCheck(Double qtyCheck) {
		this.qtyCheck = qtyCheck;
	}

	public int getUnitsperpack() {
		return unitsperpack;
	}

	public void setUnitsperpack(int unitsperpack) {
		this.unitsperpack = unitsperpack;
	}

}
