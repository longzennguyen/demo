package com.hdsoft.JptAPI.HDS.model;

public class M_InoutLineInforChiThiXuatKhoTB {
	private Long maLineId;
	private Long locatorId;
	private String locatorName;
	private Long productId;
	private String productName;
	private Double qty;
	private Long uomId;
	private String uomName;

	private Long materialId;
//	private Long orderId;
//	private Long orderlineId;
	private Long asiId;
	private String asiValue;
	private Double qtyCheck;
	private String productDescription;
	private Double ke;
	private Double Hop;

	private Double Vien;
	private Double m2;

	public Double getKe() {
		return ke;
	}

	public void setKe(Double ke) {
		this.ke = ke;
	}

	public Double getHop() {
		return Hop;
	}

	public void setHop(Double hop) {
		Hop = hop;
	}

	public Double getVien() {
		return Vien;
	}

	public void setVien(Double vien) {
		Vien = vien;
	}

	public Double getM2() {
		return m2;
	}

	public void setM2(Double m2) {
		this.m2 = m2;
	}

	public Long getMaLineId() {
		return maLineId;
	}

	public void setMaLineId(Long maLineId) {
		this.maLineId = maLineId;
	}

	public Long getLocatorId() {
		return locatorId;
	}

	public void setLocatorId(Long locatorId) {
		this.locatorId = locatorId;
	}

	public String getLocatorName() {
		return locatorName;
	}

	public void setLocatorName(String locatorName) {
		this.locatorName = locatorName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Long getUomId() {
		return uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

//	public int getUnitperpack() {
//		return unitperpack;
//	}
//
//	public void setUnitperpack(int unitperpack) {
//		this.unitperpack = unitperpack;
//	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

//	public Long getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}
//
//	public Long getOrderlineId() {
//		return orderlineId;
//	}
//
//	public void setOrderlineId(Long orderlineId) {
//		this.orderlineId = orderlineId;
//	}

	public Long getAsiId() {
		return asiId;
	}

	public void setAsiId(Long asiId) {
		this.asiId = asiId;
	}

	public String getAsiValue() {
		return asiValue;
	}

	public void setAsiValue(String asiValue) {
		this.asiValue = asiValue;
	}

	public Double getQtyCheck() {
		return qtyCheck;
	}

	public void setQtyCheck(Double qtyCheck) {
		this.qtyCheck = qtyCheck;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
