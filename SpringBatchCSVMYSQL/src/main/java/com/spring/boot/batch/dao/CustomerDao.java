
package com.spring.boot.batch.dao;

import java.util.List;

import com.spring.boot.batch.model.Customer;

/**
 * Author : Subbu
 *SpringBatchCSVMYSQL
 *CustomerDao.java
 *Apr 11, 2017
 */
public interface CustomerDao {

	public void insertCustomer(List<?extends Customer> customer);
	public List<Customer> getCustomers();
	
	
}
