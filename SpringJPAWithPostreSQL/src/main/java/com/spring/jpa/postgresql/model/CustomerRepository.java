package com.spring.jpa.postgresql.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findCustomerBylName(String lName);

}
