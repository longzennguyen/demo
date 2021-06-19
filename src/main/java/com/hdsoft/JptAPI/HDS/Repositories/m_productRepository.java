package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.m_product;

public interface m_productRepository extends JpaRepository<m_product, Long>{
	
	
	public m_product findById(long id);
	public m_product findByClientIdAndValue(Long clientId,String value);
	public List<m_product> findByValueOrName(String value,String name);
	public m_product findByIdAndAdorgid(Long id,Long adorgid);
	
	public m_product findByClientIdAndId(Long clientId,Long id);

	//HDS Base App Mobile
	public List<m_product> findByClientIdAndAdorgid(long clientId,long adorgid);
	public m_product findByAdorgidAndId(long adorgid,long id);
	public List<m_product> findByNameAndValueAndAdorgid(String name,String value,long adorgid);
	public List<m_product> findByNameAndAdorgid(String name,long adorgid);
	public m_product findByValueAndAdorgid(String value,long adorgid);
	public List<m_product> findByValueAndClientId(String value,long clientId);
	public List<m_product> findByNameAndClientId(String name,long clientId);
	public List<m_product> findByAdorgid(long adorgid);
}
