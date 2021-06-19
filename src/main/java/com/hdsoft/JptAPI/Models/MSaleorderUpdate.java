package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MSaleorderUpdate {

	private long saleorderlineId;

	public MSaleorderUpdate() {
		super();
	}

	public long getSaleorderlineId() {
		return saleorderlineId;
	}

	public void setSaleorderlineId(long saleorderlineId) {
		this.saleorderlineId = saleorderlineId;
	}

}
