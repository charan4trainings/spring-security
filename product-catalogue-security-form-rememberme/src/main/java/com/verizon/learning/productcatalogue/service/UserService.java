package com.verizon.learning.productcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.learning.productcatalogue.model.User;
import com.verizon.learning.productcatalogue.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return prepareUsers((List<com.verizon.learning.productcatalogue.entity.User>) userRepository.findAll());
	}

	private List<User> prepareUsers(List<com.verizon.learning.productcatalogue.entity.User> users) {
		return null;

	}

}
