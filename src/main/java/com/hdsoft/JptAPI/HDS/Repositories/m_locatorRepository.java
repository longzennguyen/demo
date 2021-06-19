package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.HDS.model.m_locator;

public interface m_locatorRepository extends JpaRepository<m_locator	, Long> {
	public m_locator findTopByOrderByIdDesc();
	public List<m_locator> findByValue(String value);
	public m_locator findById(long id);
	public List<m_locator> findAllByAdclientid(long adclientid);
	public m_locator findByIdAndAdorgid(Long id,Long adorgid);
	public m_locator findByAdorgidAndValue(long adorgid,String value);
	public List<m_locator> findByAdclientid(long adclientid);
	@Query(value = "select * from m_locator where ad_client_id = ?1",nativeQuery = true)
	public List<m_locator> listLocator(long ad_client_id);
	//HDS Base App
	public List<m_locator> findByAdorgid(long adorgid);
	@Query(value = "select count(m) from m_storageonhand m where m.m_locator_id =?1 and m.qtyonhand >0",nativeQuery =  true)
	public int countTK(long m_locator_id);
	@Query(value = "SELECT * FROM m_locator m WHERE m.M_Warehouse_ID = ?1",nativeQuery = true)
	public List<m_locator> getAllFocusWarehouse(long m_warehouse_id);
	public List<m_locator> findByWarehouseid(long warehouseid);
	@Query(value = "select * from m_locator where m_locator_id not in \r\n"
			+ "( select distinct(m_locator_id) from M_storageonhand  where ad_client_id = ?1 and qtyonhand > 0) and ad_client_id = ?1",nativeQuery =  true)
	public List<m_locator> listAllVTT(long ad_client_id);
}
