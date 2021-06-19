package com.hdsoft.JptAPI.HDS.Repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdsoft.JptAPI.HDS.model.*;

public interface m_transactionRepository extends JpaRepository<m_transaction, Long> {
	
	public List<m_transaction> findByOrderByIdDesc();
	public List<m_transaction> findByIdGreaterThan(long Id);
	public m_transaction findTopByOrderByIdDesc(); // Lấy ra record có ID cao nhất
//	public List<m_transaction> findAllByAd_client_id(long ad_client_id);
	//HDS Base App
	public List<m_transaction> findTop100ByMproductidOrderByCreatedDesc(long mproductid);
	public List<m_transaction> findTop100ByAdclientidAndAdorgidAndMproductidOrderByCreatedDesc(long adclientid,long adorgid,long mproductid);
	@Query(value = "select m.updated from m_transaction m where m.m_product_id = ?1 and m.m_transaction_id = (select max(m1.m_transaction_id) from m_transaction m1 where m1.m_product_id=?1 and m1.m_locator_id = ?2)",nativeQuery = true)
	public Timestamp getMaxUpdated(long m_product_id,long m_locator_id);
}
