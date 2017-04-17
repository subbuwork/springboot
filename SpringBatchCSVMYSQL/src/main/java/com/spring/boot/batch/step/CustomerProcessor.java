/**
 * Author : Subbu
 *SpringBatchCSVMYSQL
 *CustomerProcessor.java
 *Apr 11, 2017
 */
package com.spring.boot.batch.step;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.spring.boot.batch.model.Customer;


public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	Logger logger = LoggerFactory.getLogger(CustomerProcessor.class);
	@Override
	public Customer process(Customer customer) throws Exception {
         logger.info("CustomerProcessor::", "process() method....");
		Random random = new Random();
		final  Integer cid = random.nextInt();
		final  String fName= customer.getfName().toUpperCase();
		final  String lName = customer.getlName().toUpperCase();
		final  String address = customer.getAddress().toUpperCase();
		Customer fixedCustomer = new Customer(cid, fName, lName, address);
		logger.info("Converting (" + customer + ") into (" + fixedCustomer + ")");
		return fixedCustomer;
	}

}
