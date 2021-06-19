package com.hdsoft.JptAPI.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_order")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order {

	@Id
	@Column(name = "c_order_id")
	private Long id;

	@Column(name = "documentno")
	private String soChungTu;

	@Column(name = "description")
	private String dienGiai;

	@Column(name = "c_doctypetarget_id")
	private Integer loaiChungTu;

	@Column(name = "dateordered")
	private Date ngayDatHang;

	@Column(name = "datepromised")
	private Date ngayDuKienGiaoHang;

	@Column(name = "c_bpartner_id")
	private Integer doiTac;

	@Column(name = "m_warehouse_id")
	private Integer khoHang;

	@Column(name = "docstatus")
	private String docStatus;

	@Column(name = "c_doctype_id")
	private int doctypeId;

	@Column(name = "processed")
	private String processed;

	private String isvanning;

	private String isscanning;
	
	private String c_order_uu;
	@Column(name = "isback")
	private String isback;

	private int ad_client_id;

	private int ad_org_id;

	public String getC_order_uu() {
		return c_order_uu;
	}

	public void setC_order_uu(String c_order_uu) {
		this.c_order_uu = c_order_uu;
	}

	public Order() {
		super();
	}

	public Order(Long id, String soChungTu, String dienGiai, Integer loaiChungTu, Date ngayDatHang,
			Date ngayDuKienGiaoHang, Integer doiTac, Integer khoHang, String docStatus, int doctypeId, String processed,
			String isvanning, String isscanning, String isback, int ad_client_id, int ad_org_id) {
		super();
		this.id = id;
		this.soChungTu = soChungTu;
		this.dienGiai = dienGiai;
		this.loaiChungTu = loaiChungTu;
		this.ngayDatHang = ngayDatHang;
		this.ngayDuKienGiaoHang = ngayDuKienGiaoHang;
		this.doiTac = doiTac;
		this.khoHang = khoHang;
		this.docStatus = docStatus;
		this.doctypeId = doctypeId;
		this.processed = processed;
		this.isvanning = isvanning;
		this.isscanning = isscanning;
		this.isback = isback;
		this.ad_client_id = ad_client_id;
		this.ad_org_id = ad_org_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSoChungTu() {
		return soChungTu;
	}

	public void setSoChungTu(String soChungTu) {
		this.soChungTu = soChungTu;
	}

	public String getDienGiai() {
		return dienGiai;
	}

	public void setDienGiai(String dienGiai) {
		this.dienGiai = dienGiai;
	}

	public Integer getLoaiChungTu() {
		return loaiChungTu;
	}

	public void setLoaiChungTu(Integer loaiChungTu) {
		this.loaiChungTu = loaiChungTu;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayDuKienGiaoHang() {
		return ngayDuKienGiaoHang;
	}

	public void setNgayDuKienGiaoHang(Date ngayDuKienGiaoHang) {
		this.ngayDuKienGiaoHang = ngayDuKienGiaoHang;
	}

	public Integer getDoiTac() {
		return doiTac;
	}

	public void setDoiTac(Integer doiTac) {
		this.doiTac = doiTac;
	}

	public Integer getKhoHang() {
		return khoHang;
	}

	public void setKhoHang(Integer khoHang) {
		this.khoHang = khoHang;
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public int getDoctypeId() {
		return doctypeId;
	}

	public void setDoctypeId(int doctypeId) {
		this.doctypeId = doctypeId;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getIsvanning() {
		return isvanning;
	}

	public void setIsvanning(String isvanning) {
		this.isvanning = isvanning;
	}

	public String getIsscanning() {
		return isscanning;
	}

	public void setIsscanning(String isscanning) {
		this.isscanning = isscanning;
	}

	public String getIsback() {
		return isback;
	}

	public void setIsback(String isback) {
		this.isback = isback;
	}

	public int getAd_client_id() {
		return ad_client_id;
	}

	public void setAd_client_id(int ad_client_id) {
		this.ad_client_id = ad_client_id;
	}

	public int getAd_org_id() {
		return ad_org_id;
	}

	public void setAd_org_id(int ad_org_id) {
		this.ad_org_id = ad_org_id;
	}

}
