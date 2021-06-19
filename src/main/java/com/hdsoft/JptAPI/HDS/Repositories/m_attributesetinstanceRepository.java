package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.HDS.model.m_attributesetinstance;

public interface m_attributesetinstanceRepository extends JpaRepository<m_attributesetinstance, Long>{
	
	public List<m_attributesetinstance> findAll();
	public List<m_attributesetinstance> findByAdclient(long adclient);
	public List<m_attributesetinstance> findByLotAndAdclient(String lot,long adclient);
	public List<m_attributesetinstance> findByLotStartsWith(String lot);
	public m_attributesetinstance findTopByOrderByIdDesc();
	public m_attributesetinstance findById(long id);
	//Thạch Bàn
	public m_attributesetinstance findTopByDescriptionAndAdclient(String description,long adclient);
	public List<m_attributesetinstance> findByAsinoteAndReuselevelAndAdorgid(String asinote,String reuselevel,long adorgid);
	@Query(value = "select distinct(m_attributesetinstance_id) from m_storageonhand where M_Locator_ID = ?1 and M_Product_ID = ?2",nativeQuery = true)
	public List<Long> listASIFocusLocatorAndProduct(long locatorid,long productid);
	
}
