package com.hdsoft.JptAPI.HDS.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity(name = "M_Inventory")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class M_Inventory {
	@Id
	@Column(name = "M_Inventory_id")
	private long id;
	@Column(name = "ad_client_id")
	private Long adclientid;
	private String documentno;
	private Long ad_org_id;
	private Timestamp created;
	private long createdby;
	private Timestamp updated;
	private long updatedby;
	private Timestamp movementdate;
	private String docstatus;
	private String docaction;
	private long c_doctype_id;
	private long m_warehouse_id;
	private String m_Inventory_uu;
	private String processing;
	private String generatelist;
	private long approvalamt;
	public String getProcessing() {
		return processing;
	}
	public void setProcessing(String processing) {
		this.processing = processing;
	}
	public String getGeneratelist() {
		return generatelist;
	}
	public void setGeneratelist(String generatelist) {
		this.generatelist = generatelist;
	}
	public long getApprovalamt() {
		return approvalamt;
	}
	public void setApprovalamt(long approvalamt) {
		this.approvalamt = approvalamt;
	}
	public long getM_warehouse_id() {
		return m_warehouse_id;
	}
	public void setM_warehouse_id(long m_warehouse_id) {
		this.m_warehouse_id = m_warehouse_id;
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
	public String getDocumentno() {
		return documentno;
	}
	public void setDocumentno(String documentno) {
		this.documentno = documentno;
	}
	public Long getAd_org_id() {
		return ad_org_id;
	}
	public void setAd_org_id(Long ad_org_id) {
		this.ad_org_id = ad_org_id;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(long createdby) {
		this.createdby = createdby;
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
	public Timestamp getMovementdate() {
		return movementdate;
	}
	public void setMovementdate(Timestamp movementdate) {
		this.movementdate = movementdate;
	}
	public String getDocstatus() {
		return docstatus;
	}
	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}
	public String getDocaction() {
		return docaction;
	}
	public void setDocaction(String docaction) {
		this.docaction = docaction;
	}
	public long getC_doctype_id() {
		return c_doctype_id;
	}
	public void setC_doctype_id(long c_doctype_id) {
		this.c_doctype_id = c_doctype_id;
	}
	public String getM_Inventory_uu() {
		return m_Inventory_uu;
	}
	public void setM_Inventory_uu(String m_Inventory_uu) {
		this.m_Inventory_uu = m_Inventory_uu;
	}
	
	
}
