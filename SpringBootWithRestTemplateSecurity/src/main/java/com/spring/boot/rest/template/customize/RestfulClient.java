/**
 * 
 */
package com.spring.boot.rest.template.customize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.rest.template.model.Customer;

/**
 * @author subbu
 *
 */
public class RestfulClient {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	RestTemplate restTemplate;
	public RestfulClient(String userName,String password){
		restTemplate = RestTemplateBuilder.securityRestTemplateBuilder(userName, password);
	}
	
	
	//GET method..
	public void getCustomer(){
		String resource_url = "http://localhost:8080/springboot_rest_security/getCustomer?cid=100";
		ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(resource_url, Customer.class);
		logger.info("Customer details::",responseEntity.toString());
	}
	
	//POST method...
	public void addCustomer(){
		String resource_url = "http://localhost:8080/springboot_rest_security/addCustomer";
		Customer customer = new Customer(120,"subbu","bandi","India");
		ResponseEntity<String> response = restTemplate.postForEntity(resource_url, customer,String.class);
		logger.info("Response from add  service::"+response.getBody().toString());
	}

}
