package com.hdsoft.JptAPI.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.Contdeposit;

public interface ContdepositRepository extends JpaRepository<Contdeposit, Integer> {
	
//	public List<Contdeposit> findByBookingValueOrMawbOrHawbOrBookingNoOrHangTauBayOrSoChiOrContSerialOrCustomerNameAllContainingIgnoreCase(String txtSearch);
	
	public Contdeposit findByBookingId(Integer bookingId);
	
}
