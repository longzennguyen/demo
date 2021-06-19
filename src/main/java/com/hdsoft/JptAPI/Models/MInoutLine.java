package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_inoutline")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MInoutLine {

	@Id
	@Column(name = "m_inoutline_id")
	private long materialLineID;

	@Column(name = "m_locator_id")
	private Long locatorID;

	@Column(name = "m_product_id")
	private Long productID;

	@Column(name = "qtyentered")
	private Double quantity;

	@Column(name = "attributeinfor")
	private String boThuocTinh;

	@Column(name = "m_inout_id")
	private long materialID;

	@Column(name = "c_orderline_id")
	private Long orderlineID;

	@Column(name = "m_attributesetinstance_id")
	private Long asiId;

	@Column(name = "hds_qtycheckdemo")
	private Double qtyCheck;
 
	public MInoutLine() {
		super();
	}

	public Long getMaterialLineID() {
		return materialLineID;
	}

	public void setMaterialLineID(Long materialLineID) {
		this.materialLineID = materialLineID;
	}

	public Long getLocatorID() {
		return locatorID;
	}

	public void setLocatorID(Long locatorID) {
		this.locatorID = locatorID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getBoThuocTinh() {
		return boThuocTinh;
	}

	public void setBoThuocTinh(String boThuocTinh) {
		this.boThuocTinh = boThuocTinh;
	}

	public long getMaterialID() {
		return materialID;
	}

	public void setMaterialID(long materialID) {
		this.materialID = materialID;
	}

	public Long getOrderlineID() {
		return orderlineID;
	}

	public void setOrderlineID(Long orderlineID) {
		this.orderlineID = orderlineID;
	}

	public Long getAsiId() {
		return asiId;
	}

	public void setAsiId(Long asiId) {
		this.asiId = asiId;
	}

	public void setMaterialLineID(long materialLineID) {
		this.materialLineID = materialLineID;
	}

	public Double getQtyCheck() {
		return qtyCheck;
	}

	public void setQtyCheck(Double qtyCheck) {
		this.qtyCheck = qtyCheck;
	}

}
