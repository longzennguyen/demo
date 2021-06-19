package com.hdsoft.JptAPI.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Convention Cost as ff_Cost table 
 */
@Entity
@Table(name = "ff_cost")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cost {

	@Id
	private int ff_cost_id;

	private Integer costtype;
	private Date created;

	private Integer ff_booking_id;
	private Integer base_amt;

	private Date inv_date;

	private String inv_desc;
	private String inv_number;

	private String proxy;

	private Integer tax_amt;

	private Integer Total_Amt;

	private Integer ff_costtype_id;

	private String bill_no;
	private String cont_serial;

	@Column(name = "booking_value")
	private String bookingvalue;

	private String note;
	private Integer c_bpartner_id;
	private String pmttype_in;

	private String isactive;

	private String processed;

	@Column(name = "separate_payment")
	private String statusPayment;

	public Cost() {

	}

	public int getFf_cost_id() {
		return ff_cost_id;
	}

	public void setFf_cost_id(int ff_cost_id) {
		this.ff_cost_id = ff_cost_id;
	}

	public Integer getCosttype() {
		return costtype;
	}

	public void setCosttype(Integer costtype) {
		this.costtype = costtype;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getFf_booking_id() {
		return ff_booking_id;
	}

	public void setFf_booking_id(Integer ff_booking_id) {
		this.ff_booking_id = ff_booking_id;
	}

	public Integer getBase_amt() {
		return base_amt;
	}

	public void setBase_amt(Integer base_amt) {
		this.base_amt = base_amt;
	}

	public Date getInv_date() {
		return inv_date;
	}

	public void setInv_date(Date inv_date) {
		this.inv_date = inv_date;
	}

	public String getInv_desc() {
		return inv_desc;
	}

	public void setInv_desc(String inv_desc) {
		this.inv_desc = inv_desc;
	}

	public String getInv_number() {
		return inv_number;
	}

	public void setInv_number(String inv_number) {
		this.inv_number = inv_number;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public Integer getTax_amt() {
		return tax_amt;
	}

	public void setTax_amt(Integer tax_amt) {
		this.tax_amt = tax_amt;
	}

	public Integer getFf_costtype_id() {
		return ff_costtype_id;
	}

	public void setFf_costtype_id(Integer ff_costtype_id) {
		this.ff_costtype_id = ff_costtype_id;
	}

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getCont_serial() {
		return cont_serial;
	}

	public void setCont_serial(String cont_serial) {
		this.cont_serial = cont_serial;
	}

	public String getBookingvalue() {
		return bookingvalue;
	}

	public void setBookingvalue(String bookingvalue) {
		this.bookingvalue = bookingvalue;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getC_bpartner_id() {
		return c_bpartner_id;
	}

	public void setC_bpartner_id(Integer c_bpartner_id) {
		this.c_bpartner_id = c_bpartner_id;
	}

	public String getPmttype_in() {
		return pmttype_in;
	}

	public void setPmttype_in(String pmttype_in) {
		this.pmttype_in = pmttype_in;
	}

	public Integer getTotal_Amt() {
		return Total_Amt;
	}

	public void setTotal_Amt(Integer total_Amt) {
		Total_Amt = total_Amt;
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

	public String getStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(String statusPayment) {
		this.statusPayment = statusPayment;
	}

}
