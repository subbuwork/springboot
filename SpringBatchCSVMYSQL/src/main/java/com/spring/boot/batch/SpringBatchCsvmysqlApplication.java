package com.spring.boot.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchCsvmysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchCsvmysqlApplication.class, args);
	}
}
