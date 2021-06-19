package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.hdsoft.JptAPI.HDS.model.m_InventoryLine;

public interface M_InventoryLineRepository extends JpaRepository<m_InventoryLine	, Long>,CrudRepository<m_InventoryLine, Long>{
	public List<m_InventoryLine> findById(long id);
}
