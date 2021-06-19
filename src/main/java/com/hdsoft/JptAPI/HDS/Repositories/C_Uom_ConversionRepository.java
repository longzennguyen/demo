package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.C_UOM_ConversionModel;

public interface C_Uom_ConversionRepository extends JpaRepository<C_UOM_ConversionModel, Long>{
	public C_UOM_ConversionModel findByProductidAndUomidAndUomtoid(long productid,long uomid,long uomtoid);
	public List<C_UOM_ConversionModel> findByProductidAndAdclientid(long productid,long adclientid);
}
