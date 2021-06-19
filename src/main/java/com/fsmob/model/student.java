package com.fsmob.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "student")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class student {
	@Id
	private long studid;
	private String stfname;
	private String stlname;
	private String stcourse;
	private long styear;
	private String stcontact;
	private long stage;
	private Date dob;
	private long stgendar;
	public long getStudid() {
		return studid;
	}

	public void setStudid(long studid) {
		this.studid = studid;
	}

	public String getStfname() {
		return stfname;
	}

	public void setStfname(String stfname) {
		this.stfname = stfname;
	}

	public String getStlname() {
		return stlname;
	}

	public void setStlname(String stlname) {
		this.stlname = stlname;
	}

	public String getStcourse() {
		return stcourse;
	}

	public void setStcourse(String stcourse) {
		this.stcourse = stcourse;
	}

	public long getStyear() {
		return styear;
	}

	public void setStyear(long styear) {
		this.styear = styear;
	}

	public String getStcontact() {
		return stcontact;
	}

	public void setStcontact(String stcontact) {
		this.stcontact = stcontact;
	}

	public long getStage() {
		return stage;
	}

	public void setStage(long stage) {
		this.stage = stage;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getStgendar() {
		return stgendar;
	}

	public void setStgendar(long stgendar) {
		this.stgendar = stgendar;
	}
}
