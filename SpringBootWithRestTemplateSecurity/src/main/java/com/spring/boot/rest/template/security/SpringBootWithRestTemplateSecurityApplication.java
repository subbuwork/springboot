package com.spring.boot.rest.template.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.rest.template.customize.RestfulClient;

@SpringBootApplication
public class SpringBootWithRestTemplateSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithRestTemplateSecurityApplication.class, args);
		RestfulClient restfulClient = new RestfulClient("user","user123");
		
		//Get method..
		restfulClient.getCustomer();
		
		//POSt method..
		restfulClient.addCustomer();
		
		
	}
}
