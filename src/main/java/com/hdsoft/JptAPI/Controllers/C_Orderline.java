package com.hdsoft.JptAPI.Controllers;

public class C_Orderline {

	private int m_product_id;
	private int quantity;

	public C_Orderline() {
		super();
	}

	public C_Orderline(int m_product_id, int quantity) {
		super();
		this.m_product_id = m_product_id;
		this.quantity = quantity;
	}

	public int getM_product_id() {
		return m_product_id;
	}

	public void setM_product_id(int m_product_id) {
		this.m_product_id = m_product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
