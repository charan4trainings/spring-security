package com.verizon.learning.productcatalogue.repository;

import org.springframework.data.repository.CrudRepository;

import com.verizon.learning.productcatalogue.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
