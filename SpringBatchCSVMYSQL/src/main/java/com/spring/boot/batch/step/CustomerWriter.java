/**
 * Author : Subbu
 *SpringBatchCSVMYSQL
 *CustomerWriter.java
 *Apr 11, 2017
 */
package com.spring.boot.batch.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.spring.boot.batch.dao.CustomerDao;
import com.spring.boot.batch.model.Customer;

public class CustomerWriter implements ItemWriter<Customer> {
    private final CustomerDao custDao;

	public CustomerWriter(CustomerDao custDao) {
		this.custDao = custDao;
	}
	@Override
	public void write(List<? extends Customer> customers) throws Exception {
		custDao.insertCustomer(customers);
		
	}

}
