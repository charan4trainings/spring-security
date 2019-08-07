package com.verizon.learning.productcatalogue.repository;

import org.springframework.data.repository.CrudRepository;

import com.verizon.learning.productcatalogue.entity.ApplicationUser;

public interface UserRepository extends CrudRepository<ApplicationUser, String> {

	ApplicationUser findByUserName(String userName);

}
