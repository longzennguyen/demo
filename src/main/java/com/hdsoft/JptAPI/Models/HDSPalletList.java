package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hds_palletlist")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class HDSPalletList {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	private int id;
	
	@Column(name = "c_order_id")
	private long orderid;
	
	
	@Column(name = "m_product_id")
	private long productId;
	
	@Column(name = "pallet")
	private String palletNo;
	
	private Integer qty;
	private Integer ctn;
	
	private double weight;
	
	private double height;
	
	private double length;
	
	private double width;

	public long getOrderId() {
		return orderid;
	}

	public void setOrderId(long orderId) {
		this.orderid = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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
