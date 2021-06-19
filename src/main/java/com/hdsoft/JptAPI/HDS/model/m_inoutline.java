package com.hdsoft.JptAPI.HDS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_inoutline")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_inoutline {
	@Id
	@Column(name = "m_inoutline_id")
	private long  id;
	@Column(name="ad_client_id")
	private Long adclientid;
	private long ad_org_id;
	private Date created;
	private Long createdby;
	private Date updated;
	private long updatedby;
	private long line;
	private String description;
	@Column(name="m_inout_id")
	private long minoutid;
	private Long m_product_id;
	private long c_uom_id;
	private Long m_attributesetinstance_id;
	private double qtyentered;
	private double movementqty;
	private String attributeinfor;
	private Long m_locator_id;
	private String m_inoutline_uu;
	private Long c_orderline_id;
	@Column(name ="hds1")
	private String qtyctn; // qty catong
	@Column(name ="hds2")
	private String palletfrelix;
	@Column(name ="hds3")
	private String invoiceno;
	@Column(name ="hds4")
	private String numbergen;
	@Column(name = "hds_orderno")
	private String orderno;
	private double qtyoverreceipt;
	private Long hds_qtycheckdemo;
	private Long m_linewarehouse_id;
	
	

	public Long getM_linewarehouse_id() {
		return m_linewarehouse_id;
	}
	public void setM_linewarehouse_id(Long m_linewarehouse_id) {
		this.m_linewarehouse_id = m_linewarehouse_id;
	}
	public Long getHds_qtycheckdemo() {
		return hds_qtycheckdemo;
	}
	public void setHds_qtycheckdemo(Long hds_qtycheckdemo) {
		this.hds_qtycheckdemo = hds_qtycheckdemo;
	}
	public double getQtyoverreceipt() {
		return qtyoverreceipt;
	}
	public void setQtyoverreceipt(double qtyoverreceipt) {
		this.qtyoverreceipt = qtyoverreceipt;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getQtyctn() {
		return qtyctn;
	}
	public void setQtyctn(String qtyctn) {
		this.qtyctn = qtyctn;
	}
	public String getPalletfrelix() {
		return palletfrelix;
	}
	public void setPalletfrelix(String palletfrelix) {
		this.palletfrelix = palletfrelix;
	}
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invouceno) {
		this.invoiceno = invouceno;
	}
	public String getNumbergen() {
		return numbergen;
	}
	public void setNumbergen(String numbergen) {
		this.numbergen = numbergen;
	}
	public Long getC_orderline_id() {
		return c_orderline_id;
	}
	public void setC_orderline_id(Long c_orderline_id) {
		this.c_orderline_id = c_orderline_id;
	}
	public String getM_inoutline_uu() {
		return m_inoutline_uu;
	}
	public void setM_inoutline_uu(String m_inoutline_uu) {
		this.m_inoutline_uu = m_inoutline_uu;
	}
	public String getAttributeinfor() {
		return attributeinfor;
	}
	public void setAttributeinfor(String attributeinfor) {
		this.attributeinfor = attributeinfor;
	}
	public Long getM_locator_id() {
		return m_locator_id;
	}
	public void setM_locator_id(Long m_locator_id) {
		this.m_locator_id = m_locator_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getAd_client_id() {
		return adclientid;
	}
	public void setAd_client_id(Long ad_client_id) {
		this.adclientid = ad_client_id;
	}
	public long getAd_org_id() {
		return ad_org_id;
	}
	public void setAd_org_id(long ad_org_id) {
		this.ad_org_id = ad_org_id;
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
	public long getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(long updatedby) {
		this.updatedby = updatedby;
	}
	public long getLine() {
		return line;
	}
	public void setLine(long line) {
		this.line = line;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getM_inout_id() {
		return minoutid;
	}
	public void setM_inout_id(long m_inout_id) {
		this.minoutid = m_inout_id;
	}
	public Long getM_product_id() {
		return m_product_id;
	}
	public void setM_product_id(Long m_product_id) {
		this.m_product_id = m_product_id;
	}
	public long getC_uom_id() {
		return c_uom_id;
	}
	public void setC_uom_id(long c_uom_id) {
		this.c_uom_id = c_uom_id;
	}
	public Long getM_attributesetinstance_id() {
		return m_attributesetinstance_id;
	}
	public void setM_attributesetinstance_id(Long m_attributesetinstance_id) {
		this.m_attributesetinstance_id = m_attributesetinstance_id;
	}
	public double getQtyentered() {
		return qtyentered;
	}
	public void setQtyentered(double qtyentered) {
		this.qtyentered = qtyentered;
	}
	public double getMovementqty() {
		return movementqty;
	}
	public void setMovementqty(double movementqty) {
		this.movementqty = movementqty;
	}
	
	
}
