package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "AD_Org")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AdOrg {

	@Column(name = "ad_org_id")
	@Id
	private long orgId;

	@Column(name = "ad_client_id")
	private long clientId;

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

}
