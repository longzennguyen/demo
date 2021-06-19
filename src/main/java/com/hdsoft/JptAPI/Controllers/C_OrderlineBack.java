package com.hdsoft.JptAPI.Controllers;

public class C_OrderlineBack {

	private Integer c_orderline_id;
	private Integer m_product_id;
	private Integer quantity;
	private Integer asiId;

	public C_OrderlineBack() {
		super();
	}

	public Integer getC_orderline_id() {
		return c_orderline_id;
	}

	public void setC_orderline_id(Integer c_orderline_id) {
		this.c_orderline_id = c_orderline_id;
	}

	public Integer getM_product_id() {
		return m_product_id;
	}

	public void setM_product_id(Integer m_product_id) {
		this.m_product_id = m_product_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAsiId() {
		return asiId;
	}

	public void setAsiId(Integer asiId) {
		this.asiId = asiId;
	}

}
