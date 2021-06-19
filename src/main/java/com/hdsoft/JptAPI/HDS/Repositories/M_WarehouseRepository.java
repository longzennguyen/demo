package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.M_WarehouseModel;

public interface M_WarehouseRepository extends JpaRepository<M_WarehouseModel, Long>{
	public M_WarehouseModel findByNameAndValueAndAdclientidAndAdorgid(String name,String value,long adclientid,long adorgid);
	public List<M_WarehouseModel> findByAdorgid(long adorgid);
	public List<M_WarehouseModel> findByAdclientid(long adclientid);
}
