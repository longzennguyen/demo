package com.hdsoft.JptAPI.HDS.Repositories;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.HDS.model.m_inout;

public interface m_inoutRepository  extends JpaRepository<m_inout, Long>{
	public List<m_inout> findAll();
	public m_inout findTopByOrderByIdDesc();
	public List<m_inout> findByDocumentnoStartingWith(String documentno);
	public List<m_inout> findByAdclientid(long adclientid);
	public m_inout findByDocumentnoAndAdclientid(String value, long adclientid);
	//HDS Base App
	public List<m_inout> findByAdorgidAndAdclientidAndUpdatedBetween(Long adorgid,Long adclientid,Timestamp updated1,Timestamp updated2);
	public List<m_inout> findByUpdatedBetween(Timestamp updated1,Timestamp updated2);
	public List<m_inout> findByAdorgidAndDocumentnoContainingIgnoreCase(long adorgid,String documentno);
	public List<m_inout> findByAdclientidAndDocumentnoContainingIgnoreCase(long adclientid,String documentno);
	//Thachj banf
	public List<m_inout> findByAdclientidAndMovementtypeAndDocstatus(long adclientid,String movementtype,String docstatus);
//	@Query(value="SELECT m FROM m_inout m WHERE m_inout_id=(SELECT MAX(m_inout_id) FROM m_inout where documentno like ?1)")
//	public m_inout getMaxDocument(String documemtno);
	
	@Query(value = "select * from m_inout where ad_client_id = ?1 and documentno like ?2 order by m_inout_id desc",nativeQuery = true)
	public List<m_inout> listMInoutDESC(long ad_client_id, String documentno);
}
