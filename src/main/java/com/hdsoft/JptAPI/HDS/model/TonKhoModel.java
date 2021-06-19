package com.hdsoft.JptAPI.HDS.model;

import java.util.Date;

public class TonKhoModel {
	private String ViTri;
	private Long locatorid;
	private String SanPham;
	private Long productID;
	private String NgaySX;
	private Long ASIID;
	private double SoLuong;// so vien
	private Double m2;
	private Double ke;
	private Double hop;
	private String documentno;
	private String doitac;
	private long pricebuy;
	private long purchaseprice;
	private String maPhu;
	private String warehouseValue;
	private String note;
	
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getWarehouseValue() {
		return warehouseValue;
	}
	public void setWarehouseValue(String warehouseValue) {
		this.warehouseValue = warehouseValue;
	}
	public Double getKe() {
		return ke;
	}
	public void setKe(Double ke) {
		this.ke = ke;
	}
	public Double getHop() {
		return hop;
	}
	public void setHop(Double hop) {
		this.hop = hop;
	}
	public Double getM2() {
		return m2;
	}
	public void setM2(Double m2) {
		this.m2 = m2;
	}
	public String getMaPhu() {
		return maPhu;
	}
	public void setMaPhu(String maPhu) {
		this.maPhu = maPhu;
	}
	public long getPricebuy() {
		return pricebuy;
	}
	public void setPricebuy(long pricebuy) {
		this.pricebuy = pricebuy;
	}
	public long getPurchaseprice() {
		return purchaseprice;
	}
	public void setPurchaseprice(long purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	public String getDoitac() {
		return doitac;
	}
	public void setDoitac(String doitac) {
		this.doitac = doitac;
	}
	public String getDocumentno() {
		return documentno;
	}
	public void setDocumentno(String documentno) {
		this.documentno = documentno;
	}
	public Long getLocatorid() {
		return locatorid;
	}
	public void setLocatorid(Long locatorid) {
		this.locatorid = locatorid;
	}
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public Long getASIID() {
		return ASIID;
	}
	public void setASIID(Long aSIID) {
		ASIID = aSIID;
	}
	public String getViTri() {
		return ViTri;
	}
	public void setViTri(String viTri) {
		ViTri = viTri;
	}
	public String getSanPham() {
		return SanPham;
	}
	public void setSanPham(String sanPham) {
		SanPham = sanPham;
	}
	public String getNgaySX() {
		return NgaySX;
	}
	public void setNgaySX(String ngaySX) {
		NgaySX = ngaySX;
	}
	public Double getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(Double soLuong) {
		SoLuong = soLuong;
	}
	
}
