package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.Bookingdetail;

public interface BookingdetailRepository extends JpaRepository<Bookingdetail, Integer>{

	public List<Bookingdetail> findByBookingValue (String bookingValue);
	
}
