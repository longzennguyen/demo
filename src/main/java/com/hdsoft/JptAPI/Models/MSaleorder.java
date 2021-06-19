package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_saleorder")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MSaleorder {

	@Id
	@Column(name = "c_saleorder_id")
	private long saleOrderId;

	@Column(name = "c_order_id")
	private long orderId;

	public MSaleorder() {
		super();
	}

	public MSaleorder(long saleOrderId, long orderId) {
		super();
		this.saleOrderId = saleOrderId;
		this.orderId = orderId;
	}

	public long getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(long saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
