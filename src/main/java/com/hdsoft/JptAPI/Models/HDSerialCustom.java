package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HDSerialCustom {

	private int no;

	private long serialId;

	private long orderlineId;

	private long productId;

	private String serial;

	private Integer qtyentered;

	private String subSerial;

	public HDSerialCustom() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public long getSerialId() {
		return serialId;
	}

	public void setSerialId(long serialId) {
		this.serialId = serialId;
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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Integer getQtyentered() {
		return qtyentered;
	}

	public void setQtyentered(Integer qtyentered) {
		this.qtyentered = qtyentered;
	}

	public String getSubSerial() {
		return subSerial;
	}

	public void setSubSerial(String subSerial) {
		this.subSerial = subSerial;
	}

}
