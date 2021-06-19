package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
	public List<Order> findByKhoHang(int khoHang);
	
	public Order findBySoChungTu (String soChungTu);

}
