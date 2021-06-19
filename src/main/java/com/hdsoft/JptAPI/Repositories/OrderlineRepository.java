package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.Orderline;

public interface OrderlineRepository extends JpaRepository<Orderline, Long>{
	
	public List<Orderline> findByOrderID(long orderID);
	public List<Orderline> findByOrderIDAndSanPham(long orderID, long sanPham);
	
	public List<Orderline> findByInvoicenoAndLotAndOrderID(String invoiceno,String lot,long orderID);
	public List<Orderline> findByInvoicenoAndSanPhamAndOrderID(String invoiceno,long sanPham,long orderID);
}
