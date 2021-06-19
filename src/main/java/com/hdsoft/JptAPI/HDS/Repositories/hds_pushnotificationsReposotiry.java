package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.HDS.model.hds_pushnotification;

public interface hds_pushnotificationsReposotiry extends JpaRepository<hds_pushnotification, Long> {
	public List<hds_pushnotification> findAll();
//	public List<hds_pushnotification> findByDisplay();
	public List<hds_pushnotification> findById(long id);
	public List<hds_pushnotification> findAllById(long id);
	public hds_pushnotification findByUsernameAndPassword(String username,String password);
//	public hds_pushnotification changisDisplayA(hds_pushnotification hdpush,Boolean isdisplay,long id);
	@Query(value = "delete from hds_pushnotification where id = ?1", nativeQuery =  true)
	public void deleteAccount(int id);
	@Query(value = "select * from hds_pushnotification where serialnumber = ?1 and noidung= ?2",nativeQuery = true)
	public hds_pushnotification getByUsernameAndPassword(String username, String password);
}
