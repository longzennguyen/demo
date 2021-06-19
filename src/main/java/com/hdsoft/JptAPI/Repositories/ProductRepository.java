package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findByValue (String value);
	
	public List<Product> findByValueOrNameAndClientId (String value, String name, Long clientId);
	
	public List<Product> findByValueAndClientId (String name, Long clientId);
	
	public Product findById(long id);
}
