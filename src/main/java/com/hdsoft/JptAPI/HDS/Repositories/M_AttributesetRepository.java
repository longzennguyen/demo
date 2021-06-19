package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.M_AttributesetModel;

public interface M_AttributesetRepository extends JpaRepository<M_AttributesetModel, Long> {
	public List<M_AttributesetModel> findByAdorgid(long adorgid);
}
