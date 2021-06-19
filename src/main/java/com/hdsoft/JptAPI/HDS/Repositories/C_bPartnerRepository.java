package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.C_bPartnerModel;

public interface C_bPartnerRepository extends JpaRepository<C_bPartnerModel, Long> {
	public List<C_bPartnerModel> findAll();
	public List<C_bPartnerModel> findByAdorgid(long adorgid);
}
