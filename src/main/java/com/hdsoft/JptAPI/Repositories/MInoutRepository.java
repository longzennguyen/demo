package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.MInout;

public interface MInoutRepository extends JpaRepository<MInout, Long> {
	
	
	public List<MInout> findByDocumentNoStartingWithOrderByDocumentNo(String documentNo);
	
	public List<MInout> findByOrderId(long orderId);
	
	public List<MInout> findByClientIdAndDoctypeIDAndDocStatus(long clientId, long doctypeId, String docStatus);
}
