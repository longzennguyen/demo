package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "c_uom")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class C_UOM {
	@Id
	@Column(name = "c_uom_id")
	private long id;
	private String name;
	@Column(name = "ad_org_id")
	private long adorgid;
	private long ad_client_id;
	private Timestamp created;
	private Timestamp updated;
	private long createdby;
	private long updatedby;
	private String c_uom_uu;
	private String x12de355;
	private long stdprecision;
	private long costingprecision;
	
	public long getCostingprecision() {
		return costingprecision;
	}

	public void setCostingprecision(long costingprecision) {
		this.costingprecision = costingprecision;
	}

	public long getStdprecision() {
		return stdprecision;
	}

	public void setStdprecision(long stdprecision) {
		this.stdprecision = stdprecision;
	}

	public String getX12de355() {
		return x12de355;
	}

	public void setX12de355(String x12de355) {
		this.x12de355 = x12de355;
	}

	public long getAd_client_id() {
		return ad_client_id;
	}

	public void setAd_client_id(long ad_client_id) {
		this.ad_client_id = ad_client_id;
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

	public String getC_uom_uu() {
		return c_uom_uu;
	}

	public void setC_uom_uu(String c_uom_uu) {
		this.c_uom_uu = c_uom_uu;
	}

	public long getAdorgid() {
		return adorgid;
	}

	public void setAdorgid(long adorgid) {
		this.adorgid = adorgid;
	}

	public long getC_uom_id() {
		return id;
	}

	public void setC_uom_id(long c_uom_id) {
		this.id = c_uom_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
