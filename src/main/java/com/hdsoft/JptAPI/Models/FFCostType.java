package com.hdsoft.JptAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FFCostType implements Comparable<FFCostType>{

	private int CostType_ID;

	private String CostType_Name;

	public FFCostType() {
		super();
	}

	public FFCostType(int costType_ID, String costType_Name) {
		super();
		CostType_ID = costType_ID;
		CostType_Name = costType_Name;
	}

	public int getCostType_ID() {
		return CostType_ID;
	}

	public void setCostType_ID(int costType_ID) {
		CostType_ID = costType_ID;
	}

	public String getCostType_Name() {
		return CostType_Name;
	}

	public void setCostType_Name(String costType_Name) {
		CostType_Name = costType_Name;
	}
	
	@Override
	public int compareTo(FFCostType o) {
		// TODO Auto-generated method stub
		return this.CostType_Name.compareTo(o.getCostType_Name());
	}

}
