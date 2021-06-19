package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Tokhai")
@Table(name = "ff_bookingdetail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ToKhai {
	@Id
	private int ff_bookingdetail_id;
	
	private String dcln_num;
	private int ff_booking_id;
	@Column(name = "booking_value")
	private String bookingValue;
	
	public ToKhai() {
		
	}

	public int getFf_bookingdetail_id() {
		return ff_bookingdetail_id;
	}

	public void setFf_bookingdetail_id(int ff_bookingdetail_id) {
		this.ff_bookingdetail_id = ff_bookingdetail_id;
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

	public String getBookingValue() {
		return bookingValue;
	}

	public void setBookingValue(String bookingValue) {
		this.bookingValue = bookingValue;
	}
	
}

