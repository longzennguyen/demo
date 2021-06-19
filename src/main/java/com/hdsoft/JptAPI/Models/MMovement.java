package com.hdsoft.JptAPI.Models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "m_movement")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MMovement { 
	@Id
	@Column(name = "m_movement_id")
	private long movementID;

	@Column(name = "documentno")
	private String documentno; 

	@Column(name = "movementdate")
	private Timestamp movementdate;

	@Column(name = "docstatus")
	 
	private String docstatus;

	private long ad_client_id;
	@Column(name ="ad_org_id")
	private long adorgid;

	@Column(name = "c_order_id")
	private Long orderId;

	@Column(name = "c_doctype_id")
	private long doctypeId;

	private Timestamp created;
	private long createdby;
	private long updatedby;
	private Timestamp updated;
	private String docaction;
	private String m_movement_uu;
	private String status;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getM_movement_uu() {
		return m_movement_uu;
	}

	public void setM_movement_uu(String m_movement_uu) {
		this.m_movement_uu = m_movement_uu;
	}

	public MMovement() {
		super();
	}

	public MMovement(long movementID, String documentNo, Timestamp movementDate, String status, long ad_client_id,
			long ad_org_id, Long orderId, long doctypeId) {
		super();
		this.movementID = movementID;
		this.documentno = documentNo;
		this.movementdate = movementDate;
		this.docstatus = status;
		this.ad_client_id = ad_client_id;
		this.adorgid = ad_org_id;
		this.orderId = orderId;
		this.doctypeId = doctypeId;
	}

	public long getMovementID() {
		return movementID;
	}

	public void setMovementID(long movementID) {
		this.movementID = movementID;
	}

	public String getDocaction() {
		return docaction;
	}

	public void setDocaction(String docaction) {
		this.docaction = docaction;
	}

	public String getDocumentno() {
		return documentno;
	}

	public void setDocumentno(String documentno) {
		this.documentno = documentno;
	}

	public Timestamp getMovementdate() {
		return movementdate;
	}

	public void setMovementdate(Timestamp movementdate) {
		this.movementdate = movementdate;
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

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getDocumentNo() {
		return documentno;
	}

	public void setDocumentNo(String documentNo) {
		this.documentno = documentNo;
	}

	public Timestamp getMovementDate() {
		return movementdate;
	}

	public void setMovementDate(Timestamp movementDate) {
		this.movementdate = movementDate;
	}

	

	public String getDocstatus() {
		return docstatus;
	}

	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}

	public long getAd_client_id() {
		return ad_client_id;
	}

	public void setAd_client_id(long ad_client_id) {
		this.ad_client_id = ad_client_id;
	}

	public long getAd_org_id() {
		return adorgid;
	}

	public void setAd_org_id(long ad_org_id) {
		this.adorgid = ad_org_id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public long getDoctypeId() {
		return doctypeId;
	}

	public void setDoctypeId(long doctypeId) {
		this.doctypeId = doctypeId;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
}
