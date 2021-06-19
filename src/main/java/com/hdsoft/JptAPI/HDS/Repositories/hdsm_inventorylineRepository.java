package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.HDS.model.HDSM_InventoryLine;

public interface hdsm_inventorylineRepository extends JpaRepository<HDSM_InventoryLine, Long>{
	public List<HDSM_InventoryLine> findByInventoryID(long inventoryID);
//	@Query(value = "delete from hdsm_inventoryline where m_inventory_id = ?1",nativeQuery = true)
//	public void deleteAllDetailOfInventory(long m_inventory_id);
	public long deleteByInventoryID(long inventoryID);
}
