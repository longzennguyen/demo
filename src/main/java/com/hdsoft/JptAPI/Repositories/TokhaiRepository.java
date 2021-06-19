package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdsoft.JptAPI.Models.ToKhai;

@Repository
public interface TokhaiRepository extends JpaRepository<ToKhai, Integer>{

	public List<ToKhai> findByBookingValue(String bookingValue);
	
}
