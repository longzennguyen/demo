package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hds_serial")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class HDSerial {

	@Id
	@Column(name = "hds_serial_id")
	private long serialId;

	@Column(name = "c_orderline_id")
	private long orderlineId;

	@Column(name = "m_product_id")
	private long productId;

	private String serial;

	private Integer qtyentered;

	private String subserial;

	public HDSerial() {
		super();
	}

	public HDSerial(long serialId, long orderlineId, long productId) {
		super();
		this.serialId = serialId;
		this.orderlineId = orderlineId;
		this.productId = productId;
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

	public String getSubserial() {
		return subserial;
	}

	public void setSubserial(String subserial) {
		this.subserial = subserial;
	}

}
