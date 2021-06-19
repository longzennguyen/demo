package com.hdsoft.JptAPI.HDS.model;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity(name = "m_inout")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class m_inout {
	
	@Id
	@Column(name = "m_inout_id")
	private long id;
	@Column(name="ad_client_id")
	private long adclientid;
	private String documentno;
	private String docstatus;
	private String description;
	private Long c_order_id;
	@Column(name="ad_org_id")
	private long adorgid;
	private long c_doctype_id;
	private long c_bpartner_id;
	private long m_warehouse_id;
	private Long c_invoice_id;
	private Date created;
	private Long createdby;
	private long updatedby;
	private Long dropship_location_id;
	private String docaction;
	private String movementtype;
	private Date movementdate;
	private Date dateacct;
	private Long c_bpartner_location_id;
	private char deliveryrule;
	private char freightcostrule;
	private char deliveryviarule;
	private char priorityrule;
	private String m_inout_uu;
	private Timestamp updated;
	@Column(name="issotrx")
	private String issotrox;
	
	public String getIssotrox() {
		return issotrox;
	}
	public void setIssotrox(String issotrox) {
		this.issotrox = issotrox;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public String getM_inout_uu() {
		return m_inout_uu;
	}
	public void setM_inout_uu(String m_inout_uu) {
		this.m_inout_uu = m_inout_uu;
	}
	public char getPriorityrule() {
		return priorityrule;
	}
	public void setPriorityrule(char priorityrule) {
		this.priorityrule = priorityrule;
	}
	public char getDeliveryviarule() {
		return deliveryviarule;
	}
	public void setDeliveryviarule(char deliveryviarule) {
		this.deliveryviarule = deliveryviarule;
	}
	public char getFreightcostrule() {
		return freightcostrule;
	}
	public void setFreightcostrule(char freightcostrule) {
		this.freightcostrule = freightcostrule;
	}
	public char getDeliveryrule() {
		return deliveryrule;
	}
	public void setDeliveryrule(char deliveryrule) {
		this.deliveryrule = deliveryrule;
	}
	public Long getC_bpartner_location_id() {
		return c_bpartner_location_id;
	}
	public void setC_bpartner_location_id(Long c_bpartner_location_id) {
		this.c_bpartner_location_id = c_bpartner_location_id;
	}
	public Long getDropship_location_id() {
		return dropship_location_id;
	}
	public void setDropship_location_id(Long dropship_location_id) {
		this.dropship_location_id = dropship_location_id;
	}
	public Date getDateacct() {
		return dateacct;
	}
	public void setDateacct(Date dateacct) {
		this.dateacct = dateacct;
	}
	public Date getMovementdate() {
		return movementdate;
	}
	public void setMovementdate(Date movementdate) {
		this.movementdate = movementdate;
	}
	public String getMovementtype() {
		return movementtype;
	}
	public void setMovementtype(String movementtype) {
		this.movementtype = movementtype;
	}
	public String getDocaction() {
		return docaction;
	}
	public void setDocaction(String docaction) {
		this.docaction = docaction;
	}
	public long getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(long updatedby) {
		this.updatedby = updatedby;
	}
	public Long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public long getId() {
		return id;
	}
	public long getAd_org_id() {
		return adorgid;
	}
	public void setAd_org_id(long ad_org_id) {
		this.adorgid = ad_org_id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAd_client_id() {
		return adclientid;
	}
	public void setAd_client_id(long ad_client_id) {
		this.adclientid = ad_client_id;
	}

	public long getC_doctype_id() {
		return c_doctype_id;
	}
	public void setC_doctype_id(long c_doctype_id) {
		this.c_doctype_id = c_doctype_id;
	}
	public String getDocumentno() {
		return documentno;
	}
	public void setDocumentno(String documentno) {
		this.documentno = documentno;
	}
	public String getDocstatus() {
		return docstatus;
	}
	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getC_order_id() {
		return c_order_id;
	}
	public void setC_order_id(Long c_order_id) {
		this.c_order_id = c_order_id;
	}
	public long getC_bpartner_id() {
		return c_bpartner_id;
	}
	public void setC_bpartner_id(long c_bpartner_id) {
		this.c_bpartner_id = c_bpartner_id;
	}
	public long getM_warehouse_id() {
		return m_warehouse_id;
	}
	public void setM_warehouse_id(long m_warehouse_id) {
		this.m_warehouse_id = m_warehouse_id;
	}
	public Long getC_invoice_id() {
		return c_invoice_id;
	}
	public void setC_invoice_id(Long c_invoice_id) {
		this.c_invoice_id = c_invoice_id;
	}
	public m_inout() {
		// TODO Auto-generated constructor stub
	}
	
}
