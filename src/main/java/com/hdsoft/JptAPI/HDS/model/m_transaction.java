package com.hdsoft.JptAPI.HDS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_transaction")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_transaction implements Comparable<m_transaction> {

	@Id
	@Column(name = "m_transaction_id")
	private long id;
	@Column(name = "ad_client_id")
	private Long adclientid;
	@Column(name = "ad_org_id")
	private Long adorgid;
	private Date created;
	private Long createdby;
	private Date updated;
	private Long updatedby;
	private Long m_locator_id;
	@Column(name = "m_product_id")
	private Long mproductid;
	private Date movementdate;
	private Double movementqty;
	private Long m_inoutline_id;
	private String movementtype;
	private Long m_attributesetinstance_id;
	private String m_transaction_uu;

	public String getM_transaction_uu() {
		return m_transaction_uu;
	}

	public void setM_transaction_uu(String m_transaction_uu) {
		this.m_transaction_uu = m_transaction_uu;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovementtype() {
		return movementtype;
	}

	public void setMovementtype(String movementtype) {
		this.movementtype = movementtype;
	}

	public Long getAd_client_id() {
		return adclientid;
	}

	public void setAd_client_id(Long ad_client_id) {
		this.adclientid = ad_client_id;
	}

	public Long getAd_org_id() {
		return adorgid;
	}

	public void setAd_org_id(Long ad_org_id) {
		this.adorgid = ad_org_id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Long getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(Long updatedby) {
		this.updatedby = updatedby;
	}

	public Long getM_locator_id() {
		return m_locator_id;
	}

	public void setM_locator_id(Long m_locator_id) {
		this.m_locator_id = m_locator_id;
	}

	public Long getM_product_id() {
		return mproductid;
	}

	public void setM_product_id(Long m_product_id) {
		this.mproductid = m_product_id;
	}

	public Date getMovementdate() {
		return movementdate;
	}

	public void setMovementdate(Date movementdate) {
		this.movementdate = movementdate;
	}

	public Double getMovementqty() {
		return movementqty;
	}

	public void setMovementqty(Double movementqty) {
		this.movementqty = movementqty;
	}

	public Long getM_inoutline_id() {
		return m_inoutline_id;
	}

	public void setM_inoutline_id(Long m_inoutline_id) {
		this.m_inoutline_id = m_inoutline_id;
	}

	public Long getM_attributesetinstance_id() {
		return m_attributesetinstance_id;
	}

	public void setM_attributesetinstance_id(Long m_attributesetinstance_id) {
		this.m_attributesetinstance_id = m_attributesetinstance_id;
	}

	@Override
	public int compareTo(m_transaction o) {
		if (this.id < o.getId()) {
			return 1;
		} else if (this.id == o.getId()) {
			return 0;
		} else
			return -1;
	}

}
