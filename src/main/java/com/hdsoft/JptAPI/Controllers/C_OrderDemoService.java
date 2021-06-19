package com.hdsoft.JptAPI.Controllers;

import java.sql.Date;

public class C_OrderDemoService {

	public void insertOrder(String documentNo,String description, long c_bpartner_id, Date dateOrder, Date datePromised, long ad_client_id, long ad_org_id, long ad_user_id) {
		new OrderDAO().addOrderDemo(documentNo, description, c_bpartner_id, dateOrder, datePromised, ad_client_id, ad_org_id, ad_user_id);
	}
	
	public void insertOrderline(long c_order_id, long m_product_id, double qty, long ad_client_id, long ad_org_id, long ad_user_id, Date dateOrder, Date datePromised) {
		new OrderlineDAO().addOrderline(c_order_id, m_product_id, qty, ad_client_id, ad_org_id, ad_user_id, dateOrder, datePromised);
	}
	
}
