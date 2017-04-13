/**
 * Author : Subbu
 *SpringBatchCSVMYSQL
 *BatchConfig.java
 *Apr 12, 2017
 */
package com.spring.boot.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.batch.dao.CustomerDao;
import com.spring.boot.batch.model.Customer;
import com.spring.boot.batch.step.CustomerListener;
import com.spring.boot.batch.step.CustomerProcessor;
import com.spring.boot.batch.step.CustomerReader;
import com.spring.boot.batch.step.CustomerWriter;


@Configuration
public class BatchConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	CustomerDao customerDao;
	
	@Bean
	public Job job(){
		return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).
				listener(new CustomerListener(customerDao)).flow(step1()).end().build();
	}
	
	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1").<Customer,Customer> chunk(3)
		.reader(CustomerReader.reader("customer-data.csv"))
		.processor(new CustomerProcessor()).writer(new CustomerWriter(customerDao)).build();
		
	}

}
