package com.hdsoft.JptAPI.HDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity(name = "C_UOM_Conversion")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class C_UOM_ConversionModel {
	@Id
	@Column(name="C_UOM_Conversion_id")
	private long id;
	@Column(name="c_uom_id")
	private long uomid;
	@Column(name="c_uom_to_id")
	private long uomtoid;
	private double multiplyrate;
	private double dividerate;
	@Column(name="m_product_id")
	private long productid;
	@Column(name="ad_client_id")
	private long adclientid;
	public long getAdclientid() {
		return adclientid;
	}
	public void setAdclientid(long adclientid) {
		this.adclientid = adclientid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUomid() {
		return uomid;
	}
	public void setUomid(long uomid) {
		this.uomid = uomid;
	}
	public long getUomtoid() {
		return uomtoid;
	}
	public void setUomtoid(long uomtoid) {
		this.uomtoid = uomtoid;
	}
	public double getMultiplyrate() {
		return multiplyrate;
	}
	public void setMultiplyrate(double multiplyrate) {
		this.multiplyrate = multiplyrate;
	}
	public double getDividerate() {
		return dividerate;
	}
	public void setDividerate(double dividerate) {
		this.dividerate = dividerate;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	
}
