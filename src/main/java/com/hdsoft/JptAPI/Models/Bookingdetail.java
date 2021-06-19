package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ff_bookingdetail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Bookingdetail {
	
	@Id
	@Column(name = "ff_bookingdetail_ID")
	private Integer bookingdetailID;
	
	private String cont_serial;
	
	private String dcln_num;
	
	private int ff_booking_id;
	
	private String bookingdetail_value;
	
	@Column(name = "booking_value")
	private String bookingValue;

	public Bookingdetail() {
		super();
	}

	public Integer getBookingdetailID() {
		return bookingdetailID;
	}

	public void setBookingdetailID(Integer bookingdetailID) {
		this.bookingdetailID = bookingdetailID;
	}

	public String getCont_serial() {
		return cont_serial;
	}

	public void setCont_serial(String cont_serial) {
		this.cont_serial = cont_serial;
	}

	public String getDcln_num() {
		return dcln_num;
	}

	public void setDcln_num(String dcln_num) {
		this.dcln_num = dcln_num;
	}

	public int getFf_booking_id() {
		return ff_booking_id;
	}

	public void setFf_booking_id(int ff_booking_id) {
		this.ff_booking_id = ff_booking_id;
	}

	public String getBookingdetail_value() {
		return bookingdetail_value;
	}

	public void setBookingdetail_value(String bookingdetail_value) {
		this.bookingdetail_value = bookingdetail_value;
	}

	public String getBookingValue() {
		return bookingValue;
	}

	public void setBookingValue(String bookingValue) {
		this.bookingValue = bookingValue;
	}
	
}
