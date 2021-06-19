package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.HDSPalletList;

public interface HDSPalletListRepository extends JpaRepository<HDSPalletList, Long> {

	
	public List<HDSPalletList> findByOrderidOrderByPalletNo(long orderid);
	
	public List<HDSPalletList> findByOrderid(long orderid);
	
}
