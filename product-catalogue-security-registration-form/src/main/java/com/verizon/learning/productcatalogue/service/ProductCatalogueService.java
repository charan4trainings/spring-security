package com.verizon.learning.productcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.learning.productcatalogue.model.Product;
import com.verizon.learning.productcatalogue.model.UserRegistrationDto;

@Service
public class ProductCatalogueService {

	@Autowired
	private ProductService productService;

	@Autowired
	private RegistrationService registrationService;

	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	public void saveProduct(Product product) {
		productService.saveProduct(product);
	}

	public void register(UserRegistrationDto userRegistrationDto) {
		registrationService.register(userRegistrationDto);
	}

}
