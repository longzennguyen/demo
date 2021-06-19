package com.hdsoft.JptAPI.HDS.Repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hdsoft.JptAPI.HDS.model.m_inoutline;

public interface m_inoutlineRepository extends JpaRepository<m_inoutline	, Long>,CrudRepository<m_inoutline, Long> {
	
	public List<m_inoutline> findAll();
	public m_inoutline findTopByOrderByIdDesc();
	public List<m_inoutline> findByNumbergenLike(String numbergen);
	public m_inoutline findTopByOrderByNumbergenDesc();
	public List<m_inoutline> findByNumbergenIsNotNullAndAdclientid(long adclientid);
	public List<m_inoutline> findByMinoutid(long minoutid);
	//TB
	@Query(value = "SELECT m FROM m_inoutline m WHERE m_inout_id = ?1 and m_product_id = ?2 and m_attributesetinstance_id = ?3 and m_locator_id = ?4")
	public List<m_inoutline> getAllDetailFocusByUOM(long m_inout_id,long m_product_id,long m_attributesetinstance_id, long m_locator_id);
	@Query ( value ="select m.description from m_inoutline m where m.m_inoutline_id = (select m1.m_inoutline_id from m_inoutlinema m1 where m1.M_AttributeSetInstance_ID= ?1)",nativeQuery = true)
	public String getNoteFromASIID(long m_attributesetinstance_id);
	//HDS Base App
	public List<m_inoutline> findByMinoutidIn(List<Long> minoutid);
	
	@Query(value = "Select m.created from m_inoutlinema m where m.m_attributesetinstance_id = ?1 limit 1",nativeQuery = true) // lấy ra record đầu tiên
	public Timestamp getCreatedInMaTable(long asiid); 
}
