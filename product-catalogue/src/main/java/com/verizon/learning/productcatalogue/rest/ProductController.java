package com.verizon.learning.productcatalogue.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.learning.productcatalogue.model.Product;
import com.verizon.learning.productcatalogue.service.ProductService;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService service;

	@GetMapping(path = "/all")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping(path = "/name/{name}")
	public Product getProductByName(@PathVariable("name") String name) {
		return service.getProductByName(name);
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Integer saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

}
