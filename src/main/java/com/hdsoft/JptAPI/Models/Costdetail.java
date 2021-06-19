package com.hdsoft.JptAPI.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Convention Cost as FF_Costdetail table 
 */
@Entity
@Table(name = "ff_costdetail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Costdetail {
	@Id
	private Integer ff_costdetail_id;

	private String cont_Serial;
	private Date created;
	private String dcln_num;

	private Integer ff_booking_id;
	@Column(name = "ff_cost_id")
	private Integer costID;
	private String hawb;
	private char isactive;
	private String mawb;
	private Integer ff_bookingdetail_id;
	private Integer price_costdetail;

	public Costdetail() {

	}

	public Integer getFf_costdetail_id() {
		return ff_costdetail_id;
	}

	public void setFf_costdetail_id(Integer ff_costdetail_id) {
		this.ff_costdetail_id = ff_costdetail_id;
	}

	public String getCont_Serial() {
		return cont_Serial;
	}

	public void setCont_Serial(String cont_Serial) {
		this.cont_Serial = cont_Serial;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDcln_num() {
		return dcln_num;
	}

	public void setDcln_num(String dcln_num) {
		this.dcln_num = dcln_num;
	}

	public Integer getFf_booking_id() {
		return ff_booking_id;
	}

	public void setFf_booking_id(Integer ff_booking_id) {
		this.ff_booking_id = ff_booking_id;
	}

	public Integer getCostID() {
		return costID;
	}

	public void setCostID(Integer costID) {
		this.costID = costID;
	}

	public String getHawb() {
		return hawb;
	}

	public void setHawb(String hawb) {
		this.hawb = hawb;
	}

	public char getIsactive() {
		return isactive;
	}

	public void setIsactive(char isactive) {
		this.isactive = isactive;
	}

	public String getMawb() {
		return mawb;
	}

	public void setMawb(String mawb) {
		this.mawb = mawb;
	}

	public Integer getFf_bookingdetail_id() {
		return ff_bookingdetail_id;
	}

	public void setFf_bookingdetail_id(Integer ff_bookingdetail_id) {
		this.ff_bookingdetail_id = ff_bookingdetail_id;
	}

	public Integer getPrice_costdetail() {
		return price_costdetail;
	}

	public void setPrice_costdetail(Integer price_costdetail) {
		this.price_costdetail = price_costdetail;
	}

}
