package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hds_tallysheet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class HDSTallySheet {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "c_order_id")
	private long orderId;
	
	@Column(name = "m_product_id")
	private long productId;
	
	private Integer qty;
	private Integer ctn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

}
