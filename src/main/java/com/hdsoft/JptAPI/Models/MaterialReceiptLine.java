package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MaterialReceiptLine {

	private long maLineId;
	private long locatorId;
	private String locatorName;
	private long productId;
	private String productName;
	private Double qty;
	private long uomId;
	private String uomName;
	private int unitperpack;

	private long materialId;
	private Long orderId;
	private Long orderlineId;
	private long asiId;
	private String asiValue;
	private Double qtyCheck;

	public MaterialReceiptLine() {
		super();
	}

	public long getMaLineId() {
		return maLineId;
	}

	public void setMaLineId(long maLineId) {
		this.maLineId = maLineId;
	}

	public long getLocatorId() {
		return locatorId;
	}

	public void setLocatorId(long locatorId) {
		this.locatorId = locatorId;
	}

	public String getLocatorName() {
		return locatorName;
	}

	public void setLocatorName(String locatorName) {
		this.locatorName = locatorName;
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

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public long getUomId() {
		return uomId;
	}

	public void setUomId(long uomId) {
		this.uomId = uomId;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public int getUnitperpack() {
		return unitperpack;
	}

	public void setUnitperpack(int unitperpack) {
		this.unitperpack = unitperpack;
	}

	public long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderlineId() {
		return orderlineId;
	}

	public void setOrderlineId(Long orderlineId) {
		this.orderlineId = orderlineId;
	}

	public long getAsiId() {
		return asiId;
	}

	public void setAsiId(long asiId) {
		this.asiId = asiId;
	}

	public Double getQtyCheck() {
		return qtyCheck;
	}

	public void setQtyCheck(Double qtyCheck) {
		this.qtyCheck = qtyCheck;
	}

	public String getAsiValue() {
		return asiValue;
	}

	public void setAsiValue(String asiValue) {
		this.asiValue = asiValue;
	}
	
	

}
