package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.HDSerial;


public interface HDSerialRepository extends JpaRepository<HDSerial, Long>{

	public List<HDSerial> findByOrderlineIdAndProductId(long orderlineId, long productId);
	
	public HDSerial findBySerial(String serial);

	public HDSerial findBySerialAndOrderlineId(String serial, long orderlineId);
}
