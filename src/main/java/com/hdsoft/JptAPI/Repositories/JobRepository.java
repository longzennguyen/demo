package com.hdsoft.JptAPI.Repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hdsoft.JptAPI.Models.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>{
	
	public Job findById (int id);
	
	public List<Job> findByIdGreaterThan (int id);
	
	public List<Job> findByBookingValue (String bookingValue);
	
	public List<Job> findByBookingValueContainingOrTokhaiNumContainingOrContNumContainingOrHawbContainingOrMawbContainingOrCustomerNameContainingOrBookingNoContainingAllIgnoreCase (String bookingValue, String tokhaiNum, String contNum, String hawb, String mawb, String customerName, String bookingNo);
	
	public List<Job> findByCustomerNameContainingIgnoreCase(String customerName);
}
