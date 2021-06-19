package com.hdsoft.JptAPI.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ff_cntdep")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Contdeposit {

	@Id
	@Column(name = "ff_cntdep_id")
	private Integer contDepID;

	@Column(name = "ff_booking_id")
	private Integer bookingId;

	@Column(name = "booking_no")
	private String bookingNo;

	@Column(name = "shpper_carrier")
	private String hangTauBay;

	@Column(name = "seal_serial")
	private String soChi;

	private String mawb;

	@Column(name = "cont_serial")
	private String contSerial;

	@Column(name = "customernames")
	private String customerName;

	@Column(name = "approval_request")
	private String yeucauDuyet;

	@Column(name = "date_trx")
	private java.sql.Date dateCuoc;

	@Column(name = "amt_out")
	private Double soTienCuoc;

	@Column(name = "pmttype_out")
	private String hinhThucCuoc;

	private String note;

	@Column(name = "description")
	private String bienso;

	@Column(name = "pmttype_in")
	private String pmttypeOut;

	@Column(name = "amt_in")
	private Double soTienLayCuoc;

	@Column(name = "datereceived")
	private java.sql.Date dateLayCuoc;

	@Column(name = "isapproved")
	private String isApproved;

	@Column(name = "isrejected")
	private String isRejected;

	private Integer c_bpartner_id;

	public Contdeposit() {
		super();
	}

	public Integer getContDepID() {
		return contDepID;
	}

	public void setContDepID(Integer contDepID) {
		this.contDepID = contDepID;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getHangTauBay() {
		return hangTauBay;
	}

	public void setHangTauBay(String hangTauBay) {
		this.hangTauBay = hangTauBay;
	}

	public String getSoChi() {
		return soChi;
	}

	public void setSoChi(String soChi) {
		this.soChi = soChi;
	}

	public String getMawb() {
		return mawb;
	}

	public void setMawb(String mawb) {
		this.mawb = mawb;
	}

	public String getContSerial() {
		return contSerial;
	}

	public void setContSerial(String contSerial) {
		this.contSerial = contSerial;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getYeucauDuyet() {
		return yeucauDuyet;
	}

	public void setYeucauDuyet(String yeucauDuyet) {
		this.yeucauDuyet = yeucauDuyet;
	}

	public Date getDateCuoc() {
		return dateCuoc;
	}

	public void setDateCuoc(Date dateCuoc) {
		this.dateCuoc = dateCuoc;
	}

	public Double getSoTienCuoc() {
		return soTienCuoc;
	}

	public void setSoTienCuoc(Double soTienCuoc) {
		this.soTienCuoc = soTienCuoc;
	}

	public String getHinhThucCuoc() {
		return hinhThucCuoc;
	}

	public void setHinhThucCuoc(String hinhThucCuoc) {
		this.hinhThucCuoc = hinhThucCuoc;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBienso() {
		return bienso;
	}

	public void setBienso(String bienso) {
		this.bienso = bienso;
	}

	public String getPmttypeOut() {
		return pmttypeOut;
	}

	public void setPmttypeOut(String pmttypeOut) {
		this.pmttypeOut = pmttypeOut;
	}

	public Double getSoTienLayCuoc() {
		return soTienLayCuoc;
	}

	public void setSoTienLayCuoc(Double soTienLayCuoc) {
		this.soTienLayCuoc = soTienLayCuoc;
	}

	public Date getDateLayCuoc() {
		return dateLayCuoc;
	}

	public void setDateLayCuoc(Date dateLayCuoc) {
		this.dateLayCuoc = dateLayCuoc;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getIsRejected() {
		return isRejected;
	}

	public void setIsRejected(String isRejected) {
		this.isRejected = isRejected;
	}

	public Integer getC_bpartner_id() {
		return c_bpartner_id;
	}

	public void setC_bpartner_id(Integer c_bpartner_id) {
		this.c_bpartner_id = c_bpartner_id;
	}

}
