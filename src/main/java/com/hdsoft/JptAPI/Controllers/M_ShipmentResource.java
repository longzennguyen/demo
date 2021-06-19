package com.hdsoft.JptAPI.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.ConnectDB;

@RestController
@RequestMapping("api/v2/shipmentorder")
public class M_ShipmentResource {

	@PostMapping
	public static void addShipment(@RequestParam int c_order_id) {
		if (checkOrder(c_order_id)) {
			M_ShipmentService.AddShipment(c_order_id);
			M_InOutService.updateOrderDocStatus(c_order_id);
		}
	}
	
	@PutMapping
	@RequestMapping("/demo")
	public void updateCheckQtyDemo(@RequestParam long m_inoutline_id, @RequestParam double qtyCheck) {
		new MInoutLineDAO().updateCheckQty(m_inoutline_id, qtyCheck);
	}

	@PostMapping
	@RequestMapping("/insertshipmentline")
	public static void addShipmentline(@RequestParam int m_inout_id,
			@RequestParam Integer c_orderline_id, @RequestParam int m_locator_id,
			@RequestParam int m_product_id, @RequestParam double quantity) {
		M_ShipmentLineService.addShipmentLine(m_inout_id, c_orderline_id, m_locator_id, m_product_id, quantity);
	}

	@PutMapping
	@RequestMapping("/updatevanning")
	public static void updateVanning(@RequestParam int c_order_id) {
		C_OrderUpdate.updateVanning(c_order_id);
	}

	@PutMapping
	@RequestMapping("/updatescanning")
	public static void updatescanning(@RequestParam int c_order_id) {
		C_OrderUpdate.updateScanning(c_order_id);
	}

	public static boolean checkOrder(int c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean check = true;
		try {
			con = ConnectDB.conHD();
			String sql = "Select docstatus from c_order where c_order_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_order_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (!rs.getString(1).equalsIgnoreCase("CO")) {
					check = false;
				}
			}
		} catch (SQLException e) {
			System.err.println("Only one order is closed");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return check;
	}

}
