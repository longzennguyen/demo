package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.C_Bp_GroupModel;

public interface C_Bp_GroupRepository extends JpaRepository<C_Bp_GroupModel, Long>{
	public List<C_Bp_GroupModel> findByAdorgid(long adorgid);
	
}
