package com.verizon.learning.productcatalogue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.verizon.learning.productcatalogue.entity.ApplicationUser;
import com.verizon.learning.productcatalogue.entity.Authority;
import com.verizon.learning.productcatalogue.model.UserRegistrationDto;
import com.verizon.learning.productcatalogue.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void register(UserRegistrationDto registrationDto) {

		String userName = registrationDto.getUserName();

		ApplicationUser applicationUser = userRepository.findByUserName(userName);

		if (null != applicationUser) {
			throw new RuntimeException("UserName exists already!!");
		}

		ApplicationUser user = new ApplicationUser();
		user.setUserName(userName);
		user.setFirstName(registrationDto.getFirstName());
		user.setLastName(registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setEnabled(true);

		List<Authority> roles = registrationDto.getRoles().stream().map(roleName -> {
			Authority authority = new Authority();
			authority.setUsername(userName);
			authority.setAuthority(roleName);
			return authority;
		}).collect(Collectors.toList());
		user.getAuthorities().addAll(roles);

		userRepository.save(user);
	}

}
