package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdsoft.JptAPI.Models.Cont;

@Repository
public interface ContRepository extends JpaRepository<Cont, Integer>{
	
	public List<Cont> findByBookingValue (String bookingValue);
	
}
