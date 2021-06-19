package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SaleOrder {

	private long productId;
	private String productName;

	private Integer quantity;
	private Integer quantityThucte;

	private long locatorId;
	private String locatorName;

	private long asiId;
	private String asiName;

	private long orderId;

	public SaleOrder() {
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantityThucte() {
		return quantityThucte;
	}

	public void setQuantityThucte(Integer quantityThucte) {
		this.quantityThucte = quantityThucte;
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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
