package com.verizon.learning.productcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.verizon.learning.productcatalogue.model.Product;
import com.verizon.learning.productcatalogue.model.UserRegistrationDto;
import com.verizon.learning.productcatalogue.service.ProductCatalogueService;

@Controller
public class ProductCatalogueViewController {

	@Autowired
	private ProductCatalogueService productCatalogueService;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		return "login";
	}
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@GetMapping("/viewProducts")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productCatalogueService.getAllProducts());
		return "products";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product, Model model) {
		productCatalogueService.saveProduct(product);
		return "redirect:/viewProducts";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") UserRegistrationDto registrationDto, Model model) {
		try {
			productCatalogueService.register(registrationDto);
			model.addAttribute("isRegistered", true);
		} catch(Exception exception) {
			model.addAttribute("isRegistered", false);
			model.addAttribute("message", exception.getMessage());
		}		
		return "login";
	}

}
