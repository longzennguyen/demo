package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.m_productprice;

public interface M_ProductPriceRepository extends JpaRepository<m_productprice, Long>{
	public List<m_productprice> findByProductid(long productid);
	public m_productprice findTopByProductidAndOrgidOrderByIdDesc(long productid,long orgid);

}
