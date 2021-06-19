package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Product;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> listAll() {
		return productRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public Product findById(@PathVariable long id) {
		return productRepository.getOne(id);
	}
	
	@GetMapping
	@RequestMapping("/name/{name}")
	public List<Product> findByName(@PathVariable String name) {
		return productRepository.findByValue(name);
	}
	
	@GetMapping
	@RequestMapping("/name/demo/{name}")
	public List<Product> findByNameDemo(@PathVariable String name) {
		List<Product> result = new ArrayList<Product>();
		List<Product> listProduct = productRepository.findByValueAndClientId(name, (long) 1000000);
		for (Product product : listProduct) {
			if (product.getClientId() == 1000000) {
				result.add(product);
			}
		}
		return result;
	}
	
}
