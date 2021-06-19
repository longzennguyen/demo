package com.hdsoft.JptAPI.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_inout")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MInout {

	@Id
	@Column(name = "m_inout_id")
	private long materialID;

	@Column(name = "c_doctype_id")
	private long doctypeID;

	@Column(name = "docstatus")
	private String docStatus;

	@Column(name = "documentno")
	private String documentNo;

	@Column(name = "c_order_id")
	private Long orderId;

	@Column(name = "created")
	private Date ngayTaoPhieu;

	@Column(name = "movementdate")
	private Date ngayThucHien;

	@Column(name = "ad_client_id")
	private Long clientId;

	@Transient
	private Date ngayDatHang;

	public MInout() {
		super();
	}

	public MInout(long materialID, String documentNo) {
		super();
		this.materialID = materialID;
		this.documentNo = documentNo;
	}

	public long getMaterialID() {
		return materialID;
	}

	public void setMaterialID(long materialID) {
		this.materialID = materialID;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public long getDoctypeID() {
		return doctypeID;
	}

	public void setDoctypeID(long doctypeID) {
		this.doctypeID = doctypeID;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getNgayTaoPhieu() {
		return ngayTaoPhieu;
	}

	public void setNgayTaoPhieu(Date ngayTaoPhieu) {
		this.ngayTaoPhieu = ngayTaoPhieu;
	}

	public Date getNgayThucHien() {
		return ngayThucHien;
	}

	public void setNgayThucHien(Date ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

}
