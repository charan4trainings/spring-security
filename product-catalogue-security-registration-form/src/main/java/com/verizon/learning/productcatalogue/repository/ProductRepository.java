package com.verizon.learning.productcatalogue.repository;

import org.springframework.data.repository.CrudRepository;

import com.verizon.learning.productcatalogue.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public Product findByName(String name);

}
