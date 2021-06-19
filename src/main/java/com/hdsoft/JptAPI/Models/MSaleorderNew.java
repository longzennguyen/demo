package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MSaleorderNew {

	
	
	private int no;
	private long productId;
	private String productName;

	private Double quantityKH;
	private Double quantityThucte;
	private Double quantityThieu;
	private Double quantitySlc2;
	private Double qtyPalet;

	private Integer ctnTally;
	private Integer ctnPallet;

	private long orderId;
	private String note;

	public MSaleorderNew() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getQuantityKH() {
		return quantityKH;
	}

	public void setQuantityKH(Double quantityKH) {
		this.quantityKH = quantityKH;
	}

	public Double getQuantityThucte() {
		return quantityThucte;
	}

	public void setQuantityThucte(Double quantityThucte) {
		this.quantityThucte = quantityThucte;
	}

	public Double getQuantityThieu() {
		return quantityThieu;
	}

	public void setQuantityThieu(Double quantityThieu) {
		this.quantityThieu = quantityThieu;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Double getQuantitySlc2() {
		return quantitySlc2;
	}

	public void setQuantitySlc2(Double quantitySlc2) {
		this.quantitySlc2 = quantitySlc2;
	}

	public Double getQtyPalet() {
		return qtyPalet;
	}

	public void setQtyPalet(Double qtyPalet) {
		this.qtyPalet = qtyPalet;
	}

	public Integer getCtnTally() {
		return ctnTally;
	}

	public void setCtnTally(Integer ctnTally) {
		this.ctnTally = ctnTally;
	}

	public Integer getCtnPallet() {
		return ctnPallet;
	}

	public void setCtnPallet(Integer ctnPallet) {
		this.ctnPallet = ctnPallet;
	}

}
