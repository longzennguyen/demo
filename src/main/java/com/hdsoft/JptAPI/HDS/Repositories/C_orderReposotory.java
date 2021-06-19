package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.Models.Order;

public interface C_orderReposotory  extends JpaRepository<Order, Long>{
	public Order findById(long id);
	@Query(value = "select * from c_order where ad_client_id = ?1 and issotrx = ?2 and docstatus = 'DR'",nativeQuery = true)
	public List<Order> listKH(long ad_client_id , String issotrx);
}
