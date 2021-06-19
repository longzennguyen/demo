package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_bpartner")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class C_bPartnerModel {
	@Id
	@Column(name = "c_bpartner_id")
	private long cbpartnerid;
	@Column(name = "value")
	private String value;
	@Column(name = "name")
	private String name;
	@Column(name = "m_warehouse_id")
	private Long mwarehouseid;
	@Column(name = "ad_client_id")
	private long adclientid;
	@Column(name="ad_org_id")
	private long adorgid;
	private Timestamp created;
	private Timestamp updated;
	private long updatedby;
	private long createdby;
	private String c_bpartner_uu;
	private String isvendor; //NCC
	private String iscustomer; // Khách hàng
	private String isemployee;//Nhân viên
	private String issalesrep;//Nhân viên kinh doanh
	private long c_bp_group_id;
	public long getC_bp_group_id() {
		return c_bp_group_id;
	}
	public void setC_bp_group_id(long c_bp_group_id) {
		this.c_bp_group_id = c_bp_group_id;
	}
	public String getIsvendor() {
		return isvendor;
	}
	public void setIsvendor(String isvendor) {
		this.isvendor = isvendor;
	}
	public String getIscustomer() {
		return iscustomer;
	}
	public void setIscustomer(String iscustomer) {
		this.iscustomer = iscustomer;
	}
	public String getIsemployee() {
		return isemployee;
	}
	public void setIsemployee(String isemployee) {
		this.isemployee = isemployee;
	}
	public String getIssalesrep() {
		return issalesrep;
	}
	public void setIssalesrep(String issalesrep) {
		this.issalesrep = issalesrep;
	}
	public long getAdclientid() {
		return adclientid;
	}
	public void setAdclientid(long adclientid) {
		this.adclientid = adclientid;
	}
	public long getAdorgid() {
		return adorgid;
	}
	public void setAdorgid(long adorgid) {
		this.adorgid = adorgid;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public long getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(long updatedby) {
		this.updatedby = updatedby;
	}
	public long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}
	
	public String getC_bpartner_uu() {
		return c_bpartner_uu;
	}
	public void setC_bpartner_uu(String c_bpartner_uu) {
		this.c_bpartner_uu = c_bpartner_uu;
	}
	public C_bPartnerModel() {
		// TODO Auto-generated constructor stub
	}
	public long getC_bpartner_id() {
		return cbpartnerid;
	}
	public void setC_bpartner_id(long c_bpartner_id) {
		this.cbpartnerid = c_bpartner_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getM_warehouse_id() {
		return mwarehouseid;
	}
	public void setM_warehouse_id(Long m_warehouse_id) {
		this.mwarehouseid = m_warehouse_id;
	}
	
}
