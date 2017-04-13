package com.spring.boot.batch.step;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import com.spring.boot.batch.dao.CustomerDao;
import com.spring.boot.batch.model.Customer;

public class CustomerListener extends JobExecutionListenerSupport {
	
	Logger logger = LoggerFactory.getLogger(CustomerListener.class);
	private final CustomerDao customerDao;

	public CustomerListener(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED){
			logger.info("Finish Job! Check the results");
			List<Customer> customersList = customerDao.getCustomers();
			for(Customer customer:customersList){
				logger.info("Found <" + customer + "> in the database.");
				
			}
		}
	}	
	
	

}
