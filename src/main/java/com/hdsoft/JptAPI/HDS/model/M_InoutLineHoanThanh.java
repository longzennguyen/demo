package com.hdsoft.JptAPI.HDS.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class M_InoutLineHoanThanh {
	private long m_inout_id;
	private String documentno;
	private Timestamp updated;// ngày hoàn thành trong m_inout
	private String productName;
	private Long productID;
	private double qty;
	private int ke;
	private int hop;
	private int vien;
	
	public long getM_inout_id() {
		return m_inout_id;
	}
	public void setM_inout_id(long m_inout_id) {
		this.m_inout_id = m_inout_id;
	}
	public String getDocumentno() {
		return documentno;
	}
	public void setDocumentno(String documentno) {
		this.documentno = documentno;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	
}
