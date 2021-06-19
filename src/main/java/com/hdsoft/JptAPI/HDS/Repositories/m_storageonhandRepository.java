package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hdsoft.JptAPI.HDS.model.m_storageonehand;

@Repository
public interface m_storageonhandRepository
		extends CrudRepository<m_storageonehand, Long>, JpaRepository<m_storageonehand, Long> {
	public List<m_storageonehand> findAll();

	public m_storageonehand findByAsiidAndLocatoridAndProductidAndAdclientid(long asiid, long locatorid, long productid,
			long adclientid);

	public List<m_storageonehand> findDistinctByProductidAndAdclientid(long productid, long adclientid);

	public List<m_storageonehand> findDistinctLocatoridByProductidAndAdclientid(long productid, long adclientid);

	public List<m_storageonehand> findByAsiidAndAdclientidAndLocatorid(long asiid, long adclientid, long locatorid);

	public List<m_storageonehand> findByAdclientidAndLocatoridAndAsiidIn(long adclientid, long locatorid, List<Long> asiid);

	public List<m_storageonehand> findByAdclientidAndQtyonhandGreaterThanOrderByUpdatedDesc(long adclientid, double qtyonhand);

	public List<m_storageonehand> findByAdclientidAndQtyonhandGreaterThan(long adclientid, double qtyonhand);
	public List<m_storageonehand> findByAdclientidAndProductidAndQtyonhandGreaterThan(long adclientid,long productid, double qtyonhand);

	public List<m_storageonehand> findByProductid(long productid);

	public List<m_storageonehand> findByLocatorid(long locatorid);

	public m_storageonehand findByLocatoridAndProductidAndAsiid(long locatorid, long productid, long asiid);
	
	
	
	// id = ad_client_id , tìm kiếm theo client , vị trí và số lượng luôn luôn > 0
	public List<m_storageonehand> findByAdclientidAndLocatoridAndQtyonhandGreaterThan(long Adclientid, long locatorid, double qtyonhand);

	// HDS Base App
	public List<m_storageonehand> findByAdorgidAndAdclientidAndQtyonhandGreaterThan(long adorgid, long adclientid, double qtyonhand);

	public List<m_storageonehand> findByProductidAndQtyonhandGreaterThan(long productid, long qty);

	public List<m_storageonehand> findByProductidAndAdclientidAndQtyonhandGreaterThan(long productid,long adclientid, double qty);

	
	public List<m_storageonehand> findByLocatoridAndQtyonhandGreaterThan(long locatorid, long qty);

	public m_storageonehand findByLocatoridAndProductid(long locatorid,long productid);
	//public m_storageonehand findByLocatoridAndProductidAndAsiid(long locatorid,long productid,long asiid);
	@Query(value = "select count(m) from m_storageonhand m where m.m_locator_id=?1 and m.m_product_id=?2 and m.m_attributesetinstance_id=?3",nativeQuery = true)
	public long countProductInLocator(long locatorid,long productid,long asiid);
	@Query(value = "select sum(m.qtyonhand) from m_storageonhand m where m.m_locator_id=?1 and m.m_product_id=?2 and m.m_attributesetinstance_id=?3",nativeQuery = true)
	public Double sumQtyonhanFocusLocatorAndProuct(long locatorid,long productid,long asiid);
}
