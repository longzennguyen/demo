package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_orderline")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Orderline {

	
	@Id
	@Column(name = "c_orderline_id")
	private Long id;

	@Column(name = "m_product_id")
	private Long sanPham;

	@Column(name = "qtyentered")
	private Double soLuong;

	@Column(name = "c_uom_id")
	private Integer dvt;

	@Column(name = "c_order_id")
	private long orderID;

	@Column(name = "qtyinvoiced")
	private Double soLuongThucTe;

	@Column(name = "qtycheck")
	private Double qtyslc;

	@Column(name = "qtydelivered")
	private Double qtypallet;

	private Integer ctntally;

	private Integer ctnpallet;
	private String lot;
	
	private String c_orderline_uu;
	
	@Column(name="hds1")
	private String orderno;
	@Column(name="serno")
	private String invoiceno;
	private String palletno;
	@Column(name="hds2")
	private String vendorprefix;
	@Column(name="hds4")
	private Long carton;
	
	public Long getCarton() {
		return carton;
	}

	public void setCarton(Long carton) {
		this.carton = carton;
	}

	public String getVendorprefix() {
		return vendorprefix;
	}

	public void setVendorprefix(String vendorprefix) {
		this.vendorprefix = vendorprefix;
	}

	public String getPalletno() {
		return palletno;
	}

	public void setPalletno(String palletno) {
		this.palletno = palletno;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getC_orderline_uu() {
		return c_orderline_uu;
	}

	public void setC_orderline_uu(String c_orderline_uu) {
		this.c_orderline_uu = c_orderline_uu;
	}

	@Column(name = "ad_client_id")
	private long clientId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSanPham() {
		return sanPham;
	}

	public void setSanPham(Long sanPham) {
		this.sanPham = sanPham;
	}

	public Double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Double soLuong) {
		this.soLuong = soLuong;
	}

	public Integer getDvt() {
		return dvt;
	}

	public void setDvt(Integer dvt) {
		this.dvt = dvt;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public Double getSoLuongThucTe() {
		return soLuongThucTe;
	}

	public void setSoLuongThucTe(Double soLuongThucTe) {
		this.soLuongThucTe = soLuongThucTe;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public Double getQtyslc() {
		return qtyslc;
	}

	public void setQtyslc(Double qtyslc) {
		this.qtyslc = qtyslc;
	}

	public Integer getCtntally() {
		return ctntally;
	}

	public void setCtntally(Integer ctntally) {
		this.ctntally = ctntally;
	}

	public Integer getCtnpallet() {
		return ctnpallet;
	}

	public void setCtnpallet(Integer ctnpallet) {
		this.ctnpallet = ctnpallet;
	}

	public Double getQtypallet() {
		return qtypallet;
	}

	public void setQtypallet(Double qtypallet) {
		this.qtypallet = qtypallet;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

}
