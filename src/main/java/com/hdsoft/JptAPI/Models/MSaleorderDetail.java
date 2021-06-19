package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_saleorderdetail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MSaleorderDetail {

	
	@Id
	@Column(name = "c_saleorderdetail_id")
	private long saleOrderDetailId;

	@Column(name = "c_saleorder_id")
	private long saleOrderId;

	@Column(name = "m_product_id")
	private long productId;

	@Column(name = "m_locator_id")
	private long locatorId;

	@Column(name = "m_attributesetinstance_id")
	private long asiId;

	@Column(name = "qtymovement")
	private Integer qty;

	@Column(name = "checkqty")
	private Integer checkqty;

	@Column(name = "qtyentered")
	private Integer qtyentered;

	public MSaleorderDetail() {
		super();
	}

	public MSaleorderDetail(long saleOrderDetailId, long saleOrderId, long productId, long locatorId, long asiId,
			Integer qty, Integer checkqty, Integer qtyentered) {
		super();
		this.saleOrderDetailId = saleOrderDetailId;
		this.saleOrderId = saleOrderId;
		this.productId = productId;
		this.locatorId = locatorId;
		this.asiId = asiId;
		this.qty = qty;
		this.checkqty = checkqty;
		this.qtyentered = qtyentered;
	}

	public long getSaleOrderDetailId() {
		return saleOrderDetailId;
	}

	public void setSaleOrderDetailId(long saleOrderDetailId) {
		this.saleOrderDetailId = saleOrderDetailId;
	}

	public long getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(long saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getLocatorId() {
		return locatorId;
	}

	public void setLocatorId(long locatorId) {
		this.locatorId = locatorId;
	}

	public long getAsiId() {
		return asiId;
	}

	public void setAsiId(long asiId) {
		this.asiId = asiId;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getCheckqty() {
		return checkqty;
	}

	public void setCheckqty(Integer checkqty) {
		this.checkqty = checkqty;
	}

	public Integer getQtyentered() {
		return qtyentered;
	}

	public void setQtyentered(Integer qtyentered) {
		this.qtyentered = qtyentered;
	}

}
