package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "m_warehouse")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class M_WarehouseModel {
	@Id
	private long m_warehouse_id;
	@Column(name = "ad_client_id")
	private long adclientid;
	@Column(name = "ad_org_id")
	private long adorgid;
	private Timestamp created;
	private Timestamp updated;
	private long createdby;
	private long updatedby;
	private String value;
	private String name;
	private String m_warehouse_uu;
	private long c_location_id;
	private String separator;
	private Long m_reservelocator_id;
	
	public Long getM_reservelocator_id() {
		return m_reservelocator_id;
	}

	public void setM_reservelocator_id(Long m_reservelocator_id) {
		this.m_reservelocator_id = m_reservelocator_id;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public long getC_location_id() {
		return c_location_id;
	}

	public void setC_location_id(long c_location_id) {
		this.c_location_id = c_location_id;
	}

	public long getM_warehouse_id() {
		return m_warehouse_id;
	}

	public void setM_warehouse_id(long m_warehouse_id) {
		this.m_warehouse_id = m_warehouse_id;
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

	public long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}

	public long getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(long updatedby) {
		this.updatedby = updatedby;
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

	public String getM_warehouse_uu() {
		return m_warehouse_uu;
	}

	public void setM_warehouse_uu(String m_warehouse_uu) {
		this.m_warehouse_uu = m_warehouse_uu;
	}

}
