package com.verizon.learning.productcatalogue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.learning.productcatalogue.model.Product;
import com.verizon.learning.productcatalogue.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> getAllProducts() {
		return prepareProducts((List<com.verizon.learning.productcatalogue.entity.Product>) repository.findAll());
	}

	private List<Product> prepareProducts(List<com.verizon.learning.productcatalogue.entity.Product> allProducts) {
		return allProducts.stream().map(entity -> prepareProduct(entity)).collect(Collectors.toList());
	}

	public Product getProductByName(String name) {
		return prepareProduct(repository.findByName(name));
	}

	public Product prepareProduct(com.verizon.learning.productcatalogue.entity.Product entity) {
		Product product = new Product();
		product.setId(String.valueOf(entity.getId()));
		product.setName(entity.getName());
		product.setMfgDate(entity.getMfgDate().toString());
		if (null != entity.getExpDate())
			product.setExpDate(entity.getExpDate().toString());
		return product;
	}

	public Integer saveProduct(Product product) {
		com.verizon.learning.productcatalogue.entity.Product entity = new com.verizon.learning.productcatalogue.entity.Product();
		entity.setName(product.getName());
		entity.setPrice(Double.valueOf(product.getPrice()));
		com.verizon.learning.productcatalogue.entity.Product result = repository.save(entity);
		return result.getId();
	}

}
