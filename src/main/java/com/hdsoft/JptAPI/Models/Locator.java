package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_locator")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Locator {
	
	@Id
	@Column(name = "m_locator_id")
	private long locatorID;

	@Column(name = "value")
	private String name;

	@Column(name = "m_warehouse_id")
	private long warehouseID;
	
	@Column(name="ad_client_id")
	private long adclientid;
	

	public long getAdclientid() {
		return adclientid;
	}

	public void setAdclientid(long adclientid) {
		this.adclientid = adclientid;
	}

	public long getLocatorID() {
		return locatorID;
	}

	public void setLocatorID(long locatorID) {
		this.locatorID = locatorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(long warehouseID) {
		this.warehouseID = warehouseID;
	}

}
