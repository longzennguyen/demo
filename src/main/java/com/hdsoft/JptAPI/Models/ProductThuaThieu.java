package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductThuaThieu {

	private long productId;

	private String productName;

	private Integer qty;

	public ProductThuaThieu() {
		super();
	}

	public ProductThuaThieu(long productId, String productName, Integer qty) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.qty = qty;
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

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

}
