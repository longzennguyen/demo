package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.Models.MMovement;

public interface MMovementRepository extends JpaRepository<MMovement, Long>{
	
	public List<MMovement> findByDocumentnoStartingWithOrderByCreatedDesc(String documentno);
	
	public List<MMovement> findByDocumentno(String documentno);
	
	public List<MMovement> findByOrderId(long orderId);
	
	public List<MMovement> findByOrderIdAndDoctypeId(long orderId, long doctypeId);
	
	public MMovement findTopByOrderByMovementIDDesc();
	
	public List<MMovement> findByDocumentnoStartsWith(String documentno);
	
	//HDS Base App
	public List<MMovement> findByAdorgidAndDocumentnoStartsWith(Long adorgid,String documentno);
	
	@Query(value = "select * from M_Movement where ad_client_id = ?1 and documentno like ?2 order by m_movement_id desc",nativeQuery = true)
	public List<MMovement> findbydocumentofmaxid(long ad_client_id , String documentno);
	
//	@Query("SELECT max(documentno) FROM m_movement m WHERE m.documentno LIKE %?#{escape([0])} escape ?#{escapeCharacter()}")
//	List<Movie> searchByDirectorEndsWith(String director);
}
