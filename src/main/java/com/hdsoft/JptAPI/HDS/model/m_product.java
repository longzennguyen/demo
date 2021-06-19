package com.hdsoft.JptAPI.HDS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_product {

	
	@Id
	@Column(name = "m_product_id")
	private long id;

	private String name;

	private String value;

	private int unitsperpack;
	private String m_product_uu;

	@Column(name = "ad_client_id")
	private Long clientId;
	@Column(name = "m_product_category_id")
	private Long mproductcategoryid;
	private Long m_attributeset_id;//nhom sp
	@Column(name="ad_org_id")
	private long adorgid;
	private Long c_uom_id;
	private long createdby;
	private long updatedby;
	private Timestamp created;
	private Timestamp updated;
	private String description;
	private long c_taxcategory_id;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getC_taxcategory_id() {
		return c_taxcategory_id;
	}

	public void setC_taxcategory_id(long c_taxcategory_id) {
		this.c_taxcategory_id = c_taxcategory_id;
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

	public String getM_product_uu() {
		return m_product_uu;
	}

	public void setM_product_uu(String m_product_uu) {
		this.m_product_uu = m_product_uu;
	}

	public Long getM_product_category() {
		return mproductcategoryid;
	}

	public void setM_product_category(Long m_product_category) {
		this.mproductcategoryid = m_product_category;
	}

	public Long getM_attributeset_id() {
		return m_attributeset_id;
	}

	public void setM_attributeset_id(Long m_attributeset_id) {
		this.m_attributeset_id = m_attributeset_id;
	}

	public Long getAd_org_id() {
		return adorgid;
	}

	public void setAd_org_id(Long ad_org_id) {
		this.adorgid = ad_org_id;
	}

	public Long getC_uom_id() {
		return c_uom_id;
	}

	public void setC_uom_id(Long c_uom_id) {
		this.c_uom_id = c_uom_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitsperpack() {
		return unitsperpack;
	}

	public void setUnitsperpack(int unitsperpack) {
		this.unitsperpack = unitsperpack;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

}
