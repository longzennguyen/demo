package com.hdsoft.JptAPI.HDS.model;

public class ProductInfomation {
	private long productID;
	private String productName;
	private String productValue;
	private long unisperpack;
	private long clientid;
	private long orgid;
	private long m_attributeset_id;//id thuoc tinh
	private String thuoctinh;
	private long uomID;
	private String dvt;
	private long productCategoryid;
	private String productCategoryName;
	private long pricesale;
	private long purprice;
	private Long m_attributesetinstance_id;
	private String m_attributesetinstance_value;
	private double qty;
	private Long locatorid;
	private String locatorName;
	private String maPhu;
	private Long m_warehouse_id;
	private String m_warehouse_value;
	private String note;
	
	
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getM_warehouse_id() {
		return m_warehouse_id;
	}
	public void setM_warehouse_id(Long m_warehouse_id) {
		this.m_warehouse_id = m_warehouse_id;
	}
	public String getM_warehouse_value() {
		return m_warehouse_value;
	}
	public void setM_warehouse_value(String m_warehouse_value) {
		this.m_warehouse_value = m_warehouse_value;
	}
	public String getMaPhu() {
		return maPhu;
	}
	public void setMaPhu(String maPhu) {
		this.maPhu = maPhu;
	}
	public Long getLocatorid() {
		return locatorid;
	}
	public void setLocatorid(Long locatorid) {
		this.locatorid = locatorid;
	}
	public String getLocatorName() {
		return locatorName;
	}
	public void setLocatorName(String locatorName) {
		this.locatorName = locatorName;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public Long getM_attributesetinstance_id() {
		return m_attributesetinstance_id;
	}
	public void setM_attributesetinstance_id(Long m_attributesetinstance_id) {
		this.m_attributesetinstance_id = m_attributesetinstance_id;
	}
	public String getM_attributesetinstance_value() {
		return m_attributesetinstance_value;
	}
	public void setM_attributesetinstance_value(String m_attributesetinstance_value) {
		this.m_attributesetinstance_value = m_attributesetinstance_value;
	}
	public long getPricesale() {
		return pricesale;
	}
	public void setPricesale(long pricesale) {
		this.pricesale = pricesale;
	}
	public long getPurprice() {
		return purprice;
	}
	public void setPurprice(long purprice) {
		this.purprice = purprice;
	}
	public long getProductCategoryid() {
		return productCategoryid;
	}
	public void setProductCategoryid(long productCategoryid) {
		this.productCategoryid = productCategoryid;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductValue() {
		return productValue;
	}
	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}
	public long getUnisperpack() {
		return unisperpack;
	}
	public void setUnisperpack(long unisperpack) {
		this.unisperpack = unisperpack;
	}
	public long getClientid() {
		return clientid;
	}
	public void setClientid(long clientid) {
		this.clientid = clientid;
	}
	public long getOrgid() {
		return orgid;
	}
	public void setOrgid(long orgid) {
		this.orgid = orgid;
	}
	public long getM_attributeset_id() {
		return m_attributeset_id;
	}
	public void setM_attributeset_id(long m_attributeset_id) {
		this.m_attributeset_id = m_attributeset_id;
	}
	
	public String getThuoctinh() {
		return thuoctinh;
	}
	public void setThuoctinh(String thuoctinh) {
		this.thuoctinh = thuoctinh;
	}
	public long getUomID() {
		return uomID;
	}
	public void setUomID(long uomID) {
		this.uomID = uomID;
	}
	public String getDvt() {
		return dvt;
	}
	public void setDvt(String dvt) {
		this.dvt = dvt;
	}
	
}
