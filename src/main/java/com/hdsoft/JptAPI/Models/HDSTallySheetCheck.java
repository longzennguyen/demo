package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HDSTallySheetCheck {

	private String productName;

	private Integer in;

	private Integer ctn;

	private Double qtyKH;

	private Integer qtyTallyCheck;

	private Double thieu;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getIn() {
		return in;
	}

	public void setIn(Integer in) {
		this.in = in;
	}

	public Integer getCtn() {
		return ctn;
	}

	public void setCtn(Integer ctn) {
		this.ctn = ctn;
	}

	public Double getQtyKH() {
		return qtyKH;
	}

	public void setQtyKH(Double qtyKH) {
		this.qtyKH = qtyKH;
	}

	public Integer getQtyTallyCheck() {
		return qtyTallyCheck;
	}

	public void setQtyTallyCheck(Integer qtyTallyCheck) {
		this.qtyTallyCheck = qtyTallyCheck;
	}

	public Double getThieu() {
		return thieu;
	}

	public void setThieu(Double thieu) {
		this.thieu = thieu;
	}

}
