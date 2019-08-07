package com.verizon.learning.productcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.verizon.learning.productcatalogue.service.ProductService;

@Controller
public class ProductCatalogueViewController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/viewProducts")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

}
