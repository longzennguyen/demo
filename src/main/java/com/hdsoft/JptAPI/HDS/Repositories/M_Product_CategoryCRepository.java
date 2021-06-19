package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.M_Product_CategoryCModel;

public interface M_Product_CategoryCRepository extends JpaRepository<M_Product_CategoryCModel, Long> {
	public List<M_Product_CategoryCModel> findByAdorgid(long adorgid);
}
