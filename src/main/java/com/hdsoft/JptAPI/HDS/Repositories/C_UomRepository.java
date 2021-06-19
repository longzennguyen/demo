package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hdsoft.JptAPI.HDS.model.C_UOM;

public interface C_UomRepository extends JpaRepository<C_UOM, Long>,CrudRepository<C_UOM, Long> {
	public C_UOM findById(long id);
	public List<C_UOM> findByAdorgid(long adorgid);
	@Query(value = "select * from c_uom where ad_client_id = ?1",nativeQuery =  true)
	public List<C_UOM> listUOmByClient(long clientid);
}
