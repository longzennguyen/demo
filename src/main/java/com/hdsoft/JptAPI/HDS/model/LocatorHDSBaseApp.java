package com.hdsoft.JptAPI.HDS.model;

public class LocatorHDSBaseApp {
	private long m_locator_id;
	private String nameString;
	private String value;
	private int countProduct;
	public long getM_locator_id() {
		return m_locator_id;
	}
	public void setM_locator_id(long m_locator_id) {
		this.m_locator_id = m_locator_id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getCountProduct() {
		return countProduct;
	}
	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}
	
}
