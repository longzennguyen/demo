package com.hdsoft.JptAPI.HDS.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "hds_appuser")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class hds_appuser {
	@Id
	private long hds_appuser_id;
	@Column(name = "ad_client_id")
	private long adclientid;
	@Column(name = "ad_org_id")
	private long adorgid;
	private String email;
	private String validationkey;
	private Long c_bpartner_id;
	private String username;
	private String password;
	private long createdby;
	private long updatedby;
	private java.util.Date expirydate;
	private Timestamp created;
	private Timestamp updated;

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

	private String hds_appuser_uu;

	public String getHds_appuser_uu() {
		return hds_appuser_uu;
	}

	public void setHds_appuser_uu(String hds_appuser_uu) {
		this.hds_appuser_uu = hds_appuser_uu;
	}

	public java.util.Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(java.util.Date expirydate) {
		this.expirydate = expirydate;
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

	// private long ad_user_id;
	public hds_appuser() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getHds_appuser_id() {
		return hds_appuser_id;
	}

	public void setHds_appuser_id(long hds_appuser_id) {
		this.hds_appuser_id = hds_appuser_id;
	}

	public long getAd_client_id() {
		return adclientid;
	}

	public void setAd_client_id(long ad_client_id) {
		this.adclientid = ad_client_id;
	}

	public long getAd_org_id() {
		return adorgid;
	}

	public void setAd_org_id(long ad_org_id) {
		this.adorgid = ad_org_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getValidationkey() {
		return validationkey;
	}

	public void setValidationkey(String validationkey) {
		this.validationkey = validationkey;
	}

	public Long getC_bpartner_id() {
		return c_bpartner_id;
	}

	public void setC_bpartner_id(Long c_bpartner_id) {
		this.c_bpartner_id = c_bpartner_id;
	}

//		public long getAd_user_id() {
//			return ad_user_id;
//		}
//		public void setAd_user_id(long ad_user_id) {
//			this.ad_user_id = ad_user_id;
//		}
	public hds_appuser(long hds_appuser_id, long ad_client_id, long ad_org_id, String email, String validationkey,
			long c_bpartner_id) {
		super();
		this.hds_appuser_id = hds_appuser_id;
		this.adclientid = ad_client_id;
		this.adorgid = ad_org_id;
		this.email = email;
		this.validationkey = validationkey;
		this.c_bpartner_id = c_bpartner_id;
//			this.ad_user_id = ad_user_id;
	}

}
