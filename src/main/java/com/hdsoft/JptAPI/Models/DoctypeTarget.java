package com.hdsoft.JptAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_doctype_trl")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DoctypeTarget {

	@Id
	@Column(name = "c_doctype_id")
	private Long id;

	@Column(name = "printname")
	private String loaiChungTu;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoaiChungTu() {
		return loaiChungTu;
	}

	public void setLoaiChungTu(String loaiChungTu) {
		this.loaiChungTu = loaiChungTu;
	}

}
