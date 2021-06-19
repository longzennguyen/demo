package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Convention cont as table FF_BookingDetail
 */
@Entity(name = "Cont")
@Table(name = "ff_bookingdetail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cont {
	@Id
	private Integer ff_bookingdetail_id;

	private String cont_serial;
	private Integer ff_booking_id;
	@Column(name = "booking_Value")
	private String bookingValue;

	public Cont() {

	}

	public String getCont_serial() {
		return cont_serial;
	}

	public void setCont_serial(String cont_serial) {
		this.cont_serial = cont_serial;
	}

	public Integer getFf_bookingdetail_id() {
		return ff_bookingdetail_id;
	}

	public void setFf_bookingdetail_id(Integer ff_bookingdetail_id) {
		this.ff_bookingdetail_id = ff_bookingdetail_id;
	}

	public String getBookingValue() {
		return bookingValue;
	}

	public void setBooking_Value(String bookingValue) {
		this.bookingValue = bookingValue;
	}

	public Integer getFf_booking_id() {
		return ff_booking_id;
	}

	public void setFf_booking_id(Integer ff_booking_id) {
		this.ff_booking_id = ff_booking_id;
	}
	
	

}
