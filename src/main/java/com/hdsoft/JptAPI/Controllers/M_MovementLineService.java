package com.hdsoft.JptAPI.Controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.hdsoft.ConnectDB;
import com.hdsoft.JptAPI.HDS.Repositories.M_MovementRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_storageonhandRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_transactionRepository;
import com.hdsoft.JptAPI.HDS.controller.GetIDUUDate;
import com.hdsoft.JptAPI.HDS.model.m_storageonehand;

//import com.hdsoft.webapi.bubbleapi.dao.MovementlineDAO;
//import com.hdsoft.webapi.bubbleapi.database.ConnectDB;

/**
 * All service of movement and movementline
 * 
 * @author Tuan Nguyen
 * @version 1.0
 */

public class M_MovementLineService {
	@Autowired
	m_storageonhandRepository ms;
	@Autowired
	m_transactionRepository mt;
	@Autowired
	M_MovementRepository mm;
	@Autowired
	m_locatorRepository mlr;
	@Autowired
	m_attributesetinstanceRepository ma;
	GetIDUUDate g = new GetIDUUDate();
	public static void addMovementLine(Integer m_movement_id, Integer m_locator_id, Integer m_locatorto_id,
			Integer m_product_id, Double movementQty, Integer m_attributeSetInstance_id,
			Integer m_attributeSetInstanceTo_id) {
		double qtyOnHand = new MovementlineDAO().getQtyOnHandOfProduct(m_product_id, m_locator_id, m_attributeSetInstance_id);
		if (qtyOnHand - movementQty < -1) {
			System.out.println("chay vao day");
			return;
		}
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movementline(\r\n"
					+ "	m_movementline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, m_movement_id, m_locator_id, m_locatorto_id, m_product_id, line, movementqty, description, m_attributesetinstance_id, confirmedqty, scrappedqty, targetqty, processed, m_attributesetinstanceto_id, dd_orderline_id, reversalline_id, m_movementline_uu, c_uom_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			Integer m_movementline_id = getNextID();
			ps.setLong(1, m_movementline_id);
			ps.setLong(2, 1000010);
			ps.setLong(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 100);
			ps.setLong(9, m_movement_id);
			ps.setLong(10, m_locator_id);
			ps.setLong(11, m_locatorto_id);
			ps.setLong(12, m_product_id);
			ps.setInt(13, getLine(m_movement_id));
			ps.setDouble(14, movementQty);
			ps.setNull(15, java.sql.Types.VARCHAR);
			ps.setLong(16, m_attributeSetInstance_id);
			ps.setInt(17, 0);
			ps.setInt(18, 0);
			ps.setInt(19, 0);
			ps.setString(20, "Y");
			ps.setLong(21, m_attributeSetInstanceTo_id);
			ps.setNull(22, java.sql.Types.NUMERIC);
			ps.setNull(23, java.sql.Types.NUMERIC);
			ps.setString(24, getUUID());
			ps.setInt(25, 1000028); 
			ps.executeUpdate();
			executeQuantityTrigger(m_locator_id, m_locatorto_id, m_product_id, movementQty, m_attributeSetInstance_id,
					m_attributeSetInstanceTo_id);
			updateTransactionLocator(m_locator_id, m_product_id, movementQty, m_movementline_id,
					m_attributeSetInstance_id);
			updateTransactionLocatorTo(m_locatorto_id, m_product_id, movementQty, m_movementline_id,
					m_attributeSetInstanceTo_id);

//			updateStorage(m_product_id, m_locator_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void addMovementLineDemo(Integer m_movement_id, Integer m_locator_id, Integer m_locatorto_id,
			Integer m_product_id, Double movementQty, Integer m_attributeSetInstance_id,
			Integer m_attributeSetInstanceTo_id, Long ad_client_id, Long ad_org_id, Long ad_user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movementline(\r\n"
					+ "	m_movementline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, m_movement_id, m_locator_id, m_locatorto_id, m_product_id, line, movementqty, description, m_attributesetinstance_id, confirmedqty, scrappedqty, targetqty, processed, m_attributesetinstanceto_id, dd_orderline_id, reversalline_id, m_movementline_uu, c_uom_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			Integer m_movementline_id = getNextID();
			ps.setLong(1, m_movementline_id);
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setLong(9, m_movement_id);
			ps.setLong(10, m_locator_id);
			ps.setLong(11, m_locatorto_id);
			ps.setLong(12, m_product_id);
			ps.setInt(13, getLine(m_movement_id));
			ps.setDouble(14, movementQty);
			ps.setNull(15, java.sql.Types.VARCHAR);
			ps.setLong(16, m_attributeSetInstance_id);
			ps.setInt(17, 0);
			ps.setInt(18, 0);
			ps.setInt(19, 0);
			ps.setString(20, "Y");
			ps.setLong(21, m_attributeSetInstanceTo_id);
			ps.setNull(22, java.sql.Types.NUMERIC);
			ps.setNull(23, java.sql.Types.NUMERIC);
			ps.setString(24, getUUID());
			ps.setInt(25, 1000046);
			ps.executeUpdate();
			executeQuantityTriggerDemo(m_locator_id, m_locatorto_id, m_product_id, movementQty, m_attributeSetInstance_id, m_attributeSetInstanceTo_id, ad_client_id, ad_org_id, ad_user_id);
			updateTransactionLocatorDemo(m_locator_id, m_product_id, movementQty, m_movementline_id, m_attributeSetInstance_id, ad_client_id, ad_org_id, ad_user_id);
			updateTransactionLocatorToDemo(m_locatorto_id, m_product_id, movementQty, m_movementline_id, m_attributeSetInstanceTo_id, ad_client_id, ad_org_id, ad_user_id);
//			updateStorage(m_product_id, m_locator_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// process qty ck
	public String processStorageCK(long adorgid, long locatorid, long locatortoid, long productid, double qty,long asiid) {
		m_storageonehand storageonehand = new m_storageonehand();
		m_storageonehand s1 = new m_storageonehand();// chứa dữ liệu tồn cũ của sp
		double oldqty;
		if (ms.findByLocatoridAndProductid(locatortoid, productid) != null) {
			storageonehand = ms.findByLocatoridAndProductidAndAsiid(locatortoid, productid,asiid);
			oldqty = storageonehand.getQtyonhand();
			storageonehand.setQtyonhand((double) (Math.round((oldqty + qty)*1000)/1000));
			System.out.println("before  save");
			ms.save(storageonehand);
			System.out.println("After save");
			System.out.println("Cộng số liệu thành công!");

		} else {
			// Không có record
			// Tạo record và cộng slg vị trí mới
			storageonehand.setAd_org_id(adorgid);
			storageonehand.setAsiid((long) 0);
			storageonehand.setCreated(g.getDate());
			storageonehand.setCreatedby(100);
			storageonehand.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
			storageonehand.setId(1000003);
			storageonehand.setLocatorid(locatortoid);
			storageonehand.setM_storageonhand_uu(g.getUUID());
			storageonehand.setProductid(productid);
			storageonehand.setQtyonhand((double) (Math.round(qty*1000)/1000));
			storageonehand.setUpdated(g.getDate());
			storageonehand.setUpdatedby(100);
			ms.save(storageonehand);
			System.out.println("Tạo record thành công!");
		} // trừ slg từ vị trí cũ
		s1 = ms.findByLocatoridAndProductid(locatorid, productid);
		oldqty = s1.getQtyonhand();
		s1.setQtyonhand((double) (Math.round((oldqty - qty)*1000)/1000));
		ms.save(s1);
		System.out.println("Trừ số liệu thành công!");
		return "Sucessful!";
	}
	public static void addMovementLineDemo1(Integer m_movement_id, Integer m_locator_id, Integer m_locatorto_id,
			Integer m_product_id, Double movementQty, Integer m_attributeSetInstance_id,
			Integer m_attributeSetInstanceTo_id, Long ad_client_id, Long ad_org_id, Long ad_user_id,Integer uomid,Double qtyentered,Long warehouseID,String uu) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movementline(\r\n"
					+ "	m_movementline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, m_movement_id, m_locator_id, m_locatorto_id, m_product_id, line, movementqty, description, m_attributesetinstance_id, confirmedqty, scrappedqty, targetqty, processed, m_attributesetinstanceto_id, dd_orderline_id, reversalline_id, m_movementline_uu, c_uom_id,qtyentered,m_linewarehouse_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			ps = con.prepareStatement(sql);
			Integer m_movementline_id = getNextID();
			ps.setLong(1, m_movementline_id);
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setLong(9, m_movement_id);
			ps.setLong(10, m_locator_id);
			ps.setLong(11, m_locatorto_id);
			ps.setLong(12, m_product_id);
			ps.setInt(13, getLine(m_movement_id));
			/// tiep tuc tim qtyentered va movementqty
			ps.setDouble(14, movementQty);
			ps.setNull(15, java.sql.Types.VARCHAR);
			ps.setLong(16, m_attributeSetInstance_id);
			ps.setInt(17, 0);
			ps.setInt(18, 0);
			ps.setInt(19, 0);
			ps.setString(20, "Y");
			ps.setLong(21, m_attributeSetInstanceTo_id);
			ps.setNull(22, java.sql.Types.NUMERIC);
			ps.setNull(23, java.sql.Types.NUMERIC);
			ps.setString(24, getUUID());
			ps.setInt(25, uomid);
			ps.setDouble(26, qtyentered);
			ps.setLong(27, warehouseID );
			ps.executeUpdate();
			executeQuantityTriggerDemo1(m_locator_id, m_locatorto_id, m_product_id, movementQty, m_attributeSetInstance_id, m_attributeSetInstanceTo_id, ad_client_id, ad_org_id, ad_user_id,uu);
			updateTransactionLocatorDemo(m_locator_id, m_product_id, movementQty, m_movementline_id, m_attributeSetInstance_id, ad_client_id, ad_org_id, ad_user_id);
			updateTransactionLocatorToDemo(m_locatorto_id, m_product_id, movementQty, m_movementline_id, m_attributeSetInstanceTo_id, ad_client_id, ad_org_id, ad_user_id);
//			updateStorage(m_product_id, m_locator_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updateTransactionLocator(Integer m_locator_id, Integer m_product_id, Double quantity,
			Integer m_movementline_id, Integer m_attributesetinstance_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_transaction(\r\n"
					+ "	m_transaction_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, movementtype, m_locator_id, m_product_id, movementdate, movementqty, m_inventoryline_id, m_movementline_id, m_inoutline_id, m_productionline_id, c_projectissue_id, m_attributesetinstance_id, pp_cost_collector_id, m_transaction_uu)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, getTransactionId());
			ps.setInt(2, 1000010);
			ps.setInt(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 100);
			ps.setString(9, "M-");
			ps.setInt(10, m_locator_id);
			ps.setInt(11, m_product_id);
			ps.setTimestamp(12, getDate());
			ps.setDouble(13, quantity);
			ps.setNull(14, java.sql.Types.NUMERIC);
			ps.setInt(15, m_movementline_id);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setInt(19, m_attributesetinstance_id);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setString(21, getUUID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void updateTransactionLocatorDemo(Integer m_locator_id, Integer m_product_id, Double quantity,
			Integer m_movementline_id, Integer m_attributesetinstance_id, Long ad_client_id, Long ad_org_id, Long ad_user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_transaction(\r\n"
					+ "	m_transaction_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, movementtype, m_locator_id, m_product_id, movementdate, movementqty, m_inventoryline_id, m_movementline_id, m_inoutline_id, m_productionline_id, c_projectissue_id, m_attributesetinstance_id, pp_cost_collector_id, m_transaction_uu)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, getTransactionId());
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setString(9, "M-");
			ps.setInt(10, m_locator_id);
			ps.setInt(11, m_product_id);
			ps.setTimestamp(12, getDate());
			ps.setDouble(13, quantity*(-1));
			ps.setNull(14, java.sql.Types.NUMERIC);
			ps.setInt(15, m_movementline_id);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setInt(19, m_attributesetinstance_id);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setString(21, getUUID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updateStorage(Integer m_product_id, Integer m_locator_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "Update m_storage set DateMaterialPolicy = ?, updated = now() where m_product_id = ? and m_locator_id = ?";
			ps = con.prepareStatement(sql);
			ps.setTimestamp(1, getDate());
			ps.setInt(2, m_product_id);
			ps.setInt(3, m_locator_id);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updateTransactionLocatorTo(Integer m_locator_id, Integer m_product_id, Double quantity,
			Integer m_movementline_id, Integer m_attributesetinstance_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_transaction(\r\n"
					+ "	m_transaction_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, movementtype, m_locator_id, m_product_id, movementdate, movementqty, m_inventoryline_id, m_movementline_id, m_inoutline_id, m_productionline_id, c_projectissue_id, m_attributesetinstance_id, pp_cost_collector_id, m_transaction_uu)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, getTransactionId());
			ps.setInt(2, 1000010);
			ps.setInt(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 100);
			ps.setString(9, "M+");
			ps.setInt(10, m_locator_id);
			ps.setInt(11, m_product_id);
			ps.setTimestamp(12, getDate());
			ps.setDouble(13, quantity);
			ps.setNull(14, java.sql.Types.NUMERIC);
			ps.setInt(15, m_movementline_id);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setInt(19, m_attributesetinstance_id);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setString(21, getUUID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void updateTransactionLocatorToDemo(Integer m_locator_id, Integer m_product_id, Double quantity,
			Integer m_movementline_id, Integer m_attributesetinstance_id, Long ad_client_id, Long ad_org_id, Long ad_user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_transaction(\r\n"
					+ "	m_transaction_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, movementtype, m_locator_id, m_product_id, movementdate, movementqty, m_inventoryline_id, m_movementline_id, m_inoutline_id, m_productionline_id, c_projectissue_id, m_attributesetinstance_id, pp_cost_collector_id, m_transaction_uu)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, getTransactionId());
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setString(9, "M+");
			ps.setInt(10, m_locator_id);
			ps.setInt(11, m_product_id);
			ps.setTimestamp(12, getDate());
			ps.setDouble(13, quantity);
			ps.setNull(14, java.sql.Types.NUMERIC);
			ps.setInt(15, m_movementline_id);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setInt(19, m_attributesetinstance_id);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setString(21, getUUID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}



	public static void executeQuantityTrigger(Integer m_locator_id, Integer m_locatorto_id, Integer m_product_id,
			double movementQty, Integer m_attributeSetInstance_id, Integer m_attributeSetInstanceTo_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			if (checkQuantityOnHand(m_locatorto_id, m_product_id, m_attributeSetInstanceTo_id) == false) {
				String sql = "INSERT INTO adempiere.m_storageonhand(\r\n"
						+ "	ad_client_id, ad_org_id, created, createdby, datelastinventory, isactive, m_attributesetinstance_id, m_locator_id, m_product_id, qtyonhand, updated, updatedby, m_storageonhand_uu, datematerialpolicy)\r\n"
						+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, 1000010);
				ps.setInt(2, 1000022);
				ps.setTimestamp(3, getDate());
				ps.setInt(4, 100);
				ps.setNull(5, java.sql.Types.TIMESTAMP);
				ps.setString(6, "Y");
				ps.setLong(7, m_attributeSetInstanceTo_id);
				ps.setLong(8, m_locatorto_id);
				ps.setLong(9, m_product_id);
				ps.setDouble(10, movementQty);
				ps.setTimestamp(11, getDate());
				ps.setInt(12, 100);
				ps.setString(13, getUUID());
				ps.setTimestamp(14, getDate());
				ps.executeUpdate();
				abtractQuantityOnHand(m_locator_id, m_product_id, movementQty, m_attributeSetInstance_id);
				ps.close();
				con.close();
			} else {
				double quan = getQuantityOnHand(m_locatorto_id, m_product_id, m_attributeSetInstanceTo_id)
						+ movementQty;
				String sql = "Update m_storageonhand set qtyonhand = " + quan
						+ ", updated = now() where m_locator_id = " + m_locatorto_id + " and m_product_id = "
						+ m_product_id + " and m_attributesetinstance_id = " + m_attributeSetInstanceTo_id;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				abtractQuantityOnHand(m_locator_id, m_product_id, movementQty, m_attributeSetInstance_id);
				ps.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void executeQuantityTriggerDemo(Integer m_locator_id, Integer m_locatorto_id, Integer m_product_id,
			double movementQty, Integer m_attributeSetInstance_id, Integer m_attributeSetInstanceTo_id, Long ad_client_id, Long ad_org_id, Long ad_user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		DecimalFormat df2 = new DecimalFormat("#.###");
		double movementQtyFormat = Double.parseDouble(df2.format(movementQty));
		try {
			con = ConnectDB.conHD();
			if (checkQuantityOnHand(m_locatorto_id, m_product_id, m_attributeSetInstanceTo_id) == false) {
				String sql = "INSERT INTO adempiere.m_storageonhand(\r\n"
						+ "	ad_client_id, ad_org_id, created, createdby, datelastinventory, isactive, m_attributesetinstance_id, m_locator_id, m_product_id, qtyonhand, updated, updatedby, m_storageonhand_uu, datematerialpolicy)\r\n"
						+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setLong(1, ad_client_id);
				ps.setLong(2, ad_org_id);
				ps.setTimestamp(3, getDate());
				ps.setLong(4, ad_user_id);
				ps.setNull(5, java.sql.Types.TIMESTAMP);
				ps.setString(6, "Y");
				ps.setLong(7, m_attributeSetInstanceTo_id);
				ps.setLong(8, m_locatorto_id);
				ps.setLong(9, m_product_id);
				ps.setDouble(10, movementQtyFormat);
				ps.setTimestamp(11, getDate());
				ps.setLong(12, ad_user_id);
				ps.setString(13, getUUID());
				ps.setDate(14, getDateSql());
				ps.executeUpdate();
				abtractQuantityOnHand(m_locator_id, m_product_id, movementQty, m_attributeSetInstance_id);
				ps.close();
				con.close();
			} else {
				double quan = getQuantityOnHand(m_locatorto_id, m_product_id, m_attributeSetInstanceTo_id)
						+ movementQty;
				double quanFormat = Double.parseDouble(df2.format(quan));
				String sql = "Update m_storageonhand set qtyonhand = " + quanFormat
						+ ", updated = now() where m_locator_id = " + m_locatorto_id + " and m_product_id = "
						+ m_product_id + " and m_attributesetinstance_id = " + m_attributeSetInstanceTo_id;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				abtractQuantityOnHand(m_locator_id, m_product_id, movementQty, m_attributeSetInstance_id);
				ps.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void executeQuantityTriggerDemo1(Integer m_locator_id, Integer m_locatorto_id, Integer m_product_id,
			double movementQty, Integer m_attributeSetInstance_id, Integer m_attributeSetInstanceTo_id, Long ad_client_id, Long ad_org_id, Long ad_user_id,String uu) {
		Connection con = null;
		PreparedStatement ps = null;
		DecimalFormat df2 = new DecimalFormat("#.###");
		double movementQtyFormat = Double.parseDouble(df2.format(movementQty));
		try {
			con = ConnectDB.conHD();
			if (checkQuantityOnHand(m_locatorto_id, m_product_id, m_attributeSetInstanceTo_id) == false) {
				String sql = "INSERT INTO adempiere.m_storageonhand(\r\n"
						+ "	ad_client_id, ad_org_id, created, createdby, datelastinventory, isactive, m_attributesetinstance_id, m_locator_id, m_product_id, qtyonhand, updated, updatedby, m_storageonhand_uu, datematerialpolicy)\r\n"
						+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setLong(1, ad_client_id);
				ps.setLong(2, ad_org_id);
				ps.setTimestamp(3, getDate());
				ps.setLong(4, ad_user_id);
				ps.setNull(5, java.sql.Types.TIMESTAMP);
				ps.setString(6, "Y");
				ps.setLong(7, m_attributeSetInstanceTo_id);
				ps.setLong(8, m_locatorto_id);
				ps.setLong(9, m_product_id);
				ps.setDouble(10, movementQtyFormat);
				ps.setTimestamp(11, getDate());
				ps.setLong(12, ad_user_id);
				ps.setString(13, getUUID());
				ps.setDate(14, getDateSql());
				ps.executeUpdate();
				abtractQuantityOnHand(m_locator_id, m_product_id, movementQty, m_attributeSetInstance_id);
				ps.close();
				con.close();
			} else {
				double quan = getQuantityOnHand(m_locatorto_id, m_product_id, m_attributeSetInstanceTo_id)
						+ movementQty;
				double quanFormat = Double.parseDouble(df2.format(quan));
				String sql = "Update m_storageonhand set qtyonhand = " + quanFormat
						+ ", updated = now() where m_locator_id = " + m_locatorto_id + " and m_product_id = "
						+ m_product_id + " and m_attributesetinstance_id = " + m_attributeSetInstanceTo_id+" and m_storageonhand_uu = "+uu;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				abtractQuantityOnHand(m_locator_id, m_product_id, movementQty, m_attributeSetInstance_id);
				ps.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void abtractQuantityOnHand(Integer m_locator_id, Integer m_product_id, double movementQty,
			Integer m_attributeSetInstanceId) {
		Connection con = null;
		Statement st = null;
		DecimalFormat df2 = new DecimalFormat("#.###");
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			double quan = getQuantityOnHand(m_locator_id, m_product_id, m_attributeSetInstanceId) - movementQty;
			double quanFormat = Double.parseDouble(df2.format(quan));
			String sql = "Update m_storageonhand set qtyonhand = " + quanFormat + ", updated = now() where m_locator_id = "
					+ m_locator_id + " and m_product_id = " + m_product_id + " and m_attributesetinstance_id = "
					+ m_attributeSetInstanceId;
			st.executeUpdate(sql);
			con.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void abtractMultiQuantityOnHand(Integer m_locator_id, Integer m_product_id, double movementQty,
			Integer m_attributeSetInstanceId) {
		Connection con = null;
		Statement st = null;
		Double check = 0.0;
		HashMap<String, Double> mapMultiQuantity = getMultiQuantityOnHand(m_locator_id, m_product_id,
				m_attributeSetInstanceId);
		String sql = null;
		Double movementQuan = movementQty;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			for (String key : mapMultiQuantity.keySet()) {
				check = mapMultiQuantity.get(key);
				if (check < movementQuan) {
					movementQuan = movementQuan - check;
					sql = "Update m_storageonhand set qtyonhand = " + 0 + ", updated = now() where m_locator_id = "
							+ m_locator_id + " and m_product_id = " + m_product_id + " and m_attributesetinstance_id = "
							+ m_attributeSetInstanceId + " and m_storageonhand_uu = '" + key + "'";
					st.executeUpdate(sql);
				} else {
					check = check - movementQuan;
					sql = "Update m_storageonhand set qtyonhand = " + check + ", updated = now() where m_locator_id = "
							+ m_locator_id + " and m_product_id = " + m_product_id + " and m_attributesetinstance_id = "
							+ m_attributeSetInstanceId + " and m_storageonhand_uu = '" + key + "'";
					st.executeUpdate(sql);
					break;
				}
			}
			st.executeUpdate(sql);
			con.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Double getQuantityOnHand(Integer m_locator_id, Integer m_product_id,
			Integer m_attributeSetInstanceId) {
		Connection con = null;
		Statement st = null;
		Double result = 0.0;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select qtyonhand from m_storageonhand where m_locator_id = " + m_locator_id
					+ " and m_product_id = " + m_product_id + " and m_attributesetinstance_id = "
					+ m_attributeSetInstanceId;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				try {
					result = rs.getDouble(1);
				} catch (Exception e) {
					result = 0.0;
				}
			}
			con.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Null point return 0");
			result = 0.0;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static Double getMultiQuantityOnHandReal(Integer m_locator_id, Integer m_product_id,
			Integer m_attributeSetInstanceId) {
		Connection con = null;
		Statement st = null;
		Double result = 0.0;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select qtyonhand from m_storageonhand where m_locator_id = " + m_locator_id
					+ " and m_product_id = " + m_product_id + " and m_attributesetinstance_id = "
					+ m_attributeSetInstanceId;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				try {
					result = result + rs.getDouble(1);
				} catch (Exception e) {
					result = 0.0;
				}
			}
			con.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Null point return 0");
			result = 0.0;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static HashMap<String, Double> getMultiQuantityOnHand(Integer m_locator_id, Integer m_product_id,
			Integer m_attributeSetInstanceId) {
		Connection con = null;
		Statement st = null;
		Double result = 0.0;
		HashMap<String, Double> mapResult = new HashMap<String, Double>();
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select m_storageonhand_uu, qtyonhand from m_storageonhand where m_locator_id = "
					+ m_locator_id + " and m_product_id = " + m_product_id + " and m_attributesetinstance_id = "
					+ m_attributeSetInstanceId;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				try {
					String uuid = rs.getString(1);
					result = rs.getDouble(2);
					mapResult.put(uuid, result);
				} catch (Exception e) {
					result = 0.0;
				}
			}
			con.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Null point return 0");
			result = 0.0;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return mapResult;
	}

	public static boolean checkQuantityOnHand(Integer m_locator_id, Integer m_product_id,
			Integer m_attributeSetInstanceId) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean check = false;
		try {
			con = ConnectDB.conHD();
			String sql = "select * from m_storageonhand where m_product_id = ? and m_locator_id = ? and m_attributesetinstance_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, m_product_id);
			ps.setInt(2, m_locator_id);
			ps.setInt(3, m_attributeSetInstanceId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				check = true;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return check;
	}

	public static Integer getLine(Integer m_movement_id) {
		Connection con = null;
		Statement st = null;
		Integer result = 10;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select max(line) from m_movementline where m_movement_id = " + m_movement_id;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt("max") + 10;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Integer getNextID() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'M_MovementLine')::Integer, 'N'::Varchar)";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String getUUID() {
		Connection con = null;
		CallableStatement cstmt = null;
		String result = null;
		try {
			con = ConnectDB.conHD();
			cstmt = con.prepareCall("{? = call generate_uuid()}");
			cstmt.registerOutParameter(1, Types.CHAR);
			cstmt.execute();
			result = cstmt.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static Integer getTransactionId() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'M_Transaction')::Integer, 'N'::Varchar)";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static Timestamp getDate() {
		Timestamp result = null;
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = ConnectDB.conHD();
			cstmt = con.prepareCall("{? = call getdate()}");
			cstmt.registerOutParameter(1, java.sql.Types.TIMESTAMP);
			cstmt.execute();
			result = cstmt.getTimestamp(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cstmt != null) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static Date getDateSql() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        Date now = Date.valueOf(dateFormat.format(date));
        return now;
	}
}
