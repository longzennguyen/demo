package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HDSPalletListCheck {

	
	private long orderId;

	private long productId;
	private String productName;
	private String palletNo;

	private Integer qty;
	private Integer ctn;

	private double weight;

	private double height;

	private double length;

	private double width;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	public String getPalletNo() {
		return palletNo;
	}

	public void setPalletNo(String palletNo) {
		this.palletNo = palletNo;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getCtn() {
		return ctn;
	}

	public void setCtn(Integer ctn) {
		this.ctn = ctn;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

}
