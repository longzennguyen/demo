package com.hdsoft.JptAPI.Models;

import java.sql.Date;

import javax.persistence.Column;
//import java.util.List;
//
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Convention job as FF_Booking in Database
 */
@Entity
@Table(name = "ff_booking")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Job {
	@Id
	@Column(name = "ff_booking_id")
	private Integer id;

	@Column(name = "booking_value")
	private String bookingValue;

	@Column(name = "customernames")
	private String customerName;

	@Column(name = "cont_serials")
	private String contNum;

	@Column(name = "dcln_nums")
	private String tokhaiNum;

	@Column(name = "Booking_No")
	private String bookingNo;

	@Column(name = "office_open_id")
	private String vpMoToKhai;

	@Column(name = "office_incharge_id")
	private String vpNhanTT;

	private String mawb;

	private String hawb;

	private Date created;

	private String isactive;

	private String processed;

//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "ff_booking_id")
//	private List<Cont> conts;

	public Job() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookingValue() {
		return bookingValue;
	}

	public void setBookingValue(String bookingValue) {
		this.bookingValue = bookingValue;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContNum() {
		return contNum;
	}

	public void setContNum(String contNum) {
		this.contNum = contNum;
	}

	public String getTokhaiNum() {
		return tokhaiNum;
	}

	public void setTokhaiNum(String tokhaiNum) {
		this.tokhaiNum = tokhaiNum;
	}

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getVpMoToKhai() {
		return vpMoToKhai;
	}

	public void setVpMoToKhai(String vpMoToKhai) {
		this.vpMoToKhai = vpMoToKhai;
	}

	public String getVpNhanTT() {
		return vpNhanTT;
	}

	public void setVpNhanTT(String vpNhanTT) {
		this.vpNhanTT = vpNhanTT;
	}

	public String getMawb() {
		return mawb;
	}

	public void setMawb(String mawb) {
		this.mawb = mawb;
	}

	public String getHawb() {
		return hawb;
	}

	public void setHawb(String hawb) {
		this.hawb = hawb;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}



}
