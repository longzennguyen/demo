package com.hdsoft.JptAPI.HDS.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.hds_appuser;
import com.hdsoft.JptAPI.Models.Account;

public interface hds_appuserReposotiry extends  JpaRepository<hds_appuser, Long>{
	public List<hds_appuser> findAll(); 
	public List<hds_appuser> findByEmail(String email);
	public hds_appuser findByAdorgidAndUsernameAndAdclientid(long adorgid,String username,long adclientid);
	public hds_appuser findByAdorgidAndUsernameAndAdclientidAndEmail(long adorgid,String username,long adclientid,String email);
	public hds_appuser findByUsernameAndPassword(String username,String password);
}
