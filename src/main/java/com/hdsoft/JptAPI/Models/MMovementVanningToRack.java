package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MMovementVanningToRack {

	private long productId;
	private String productName;
	private double backQty;
	private long asiId;
	private String asiName;
	private long m_locator_id;

	public MMovementVanningToRack() {

	}

	public MMovementVanningToRack(long productId, String productName, double backQty, long asiId, String asiName,
			long m_locator_id) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.backQty = backQty;
		this.asiId = asiId;
		this.asiName = asiName;
		this.m_locator_id = m_locator_id;
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

	public double getBackQty() {
		return backQty;
	}

	public void setBackQty(double backQty) {
		this.backQty = backQty;
	}

	public long getAsiId() {
		return asiId;
	}

	public void setAsiId(long asiId) {
		this.asiId = asiId;
	}

	public String getAsiName() {
		return asiName;
	}

	public void setAsiName(String asiName) {
		this.asiName = asiName;
	}

	public long getM_locator_id() {
		return m_locator_id;
	}

	public void setM_locator_id(long m_locator_id) {
		this.m_locator_id = m_locator_id;
	}

}
