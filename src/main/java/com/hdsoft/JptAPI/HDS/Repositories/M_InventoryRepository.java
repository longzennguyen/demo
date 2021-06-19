package com.hdsoft.JptAPI.HDS.Repositories;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.HDS.model.M_Inventory;

public interface M_InventoryRepository extends JpaRepository<M_Inventory, Long>{
	public M_Inventory findTopByOrderByDocumentnoDesc();
	public List<M_Inventory> findAllByAdclientid(long adclientid);

	public List<M_Inventory> findByDocumentnoStartsWith(String documentno);
	
	//kiem kho moi update 7-5-2021
	@Query(value = "select * from m_inventory m  where (m.created between ?1  and ?2)and m.m_warehouse_id=?3",nativeQuery = true)
	public M_Inventory getInDayProcess(Timestamp date,Timestamp date2,long m_warehouse_id);
	
}
