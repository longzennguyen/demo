package com.hdsoft.JptAPI.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_attributesetinstance")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MAttributeSetInstance {

	@Id
	@Column(name = "m_attributesetinstance_id")
	private long attributeSetInstanceId;

	@Column(name = "lot")
	private String name;

	@Column(name = "description")
	private String value;

	@Column(name = "guaranteedate")
	private Date guaranteeDate;

	@Column(name = "m_attributeset_id")
	private Integer attributeSetId;

	@Column(name = "ad_client_id")
	private long clientId;

	public MAttributeSetInstance() {
		super();
	}

	public MAttributeSetInstance(long attributeSetInstanceId, String name, String value, Date guaranteeDate,
			Integer attributeSetId) {
		super();
		this.attributeSetInstanceId = attributeSetInstanceId;
		this.name = name;
		this.value = value;
		this.guaranteeDate = guaranteeDate;
		this.attributeSetId = attributeSetId;
	}

	public long getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(long attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getGuaranteeDate() {
		return guaranteeDate;
	}

	public void setGuaranteeDate(Date guaranteeDate) {
		this.guaranteeDate = guaranteeDate;
	}

	public Integer getAttributeSetId() {
		return attributeSetId;
	}

	public void setAttributeSetId(Integer attributeSetId) {
		this.attributeSetId = attributeSetId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

}
