/**
 * Author:Subbu
 * Date:04/12/2017
 */
package com.spring.boot.rest.webservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rest.webservices.model.Customer;

@RestController
@RequestMapping("/SpringBootWithRestWebservices")
public class WebController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/greetings", method= RequestMethod.GET)
	public String greetings(){
		logger.info("Inside greting method....");
		return "Welcome to Restful webservies...";
	}
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public String postMethod(@RequestBody Customer customer){
		logger.info("Customer details:::",customer.toString());
		return "Post successfull...";
	}
	
	@RequestMapping(value="/getCustomer",method=RequestMethod.GET)
	public Customer getCustomer(@RequestParam("cid")Integer cid){
		logger.info("Customer Id::",cid);
		return new Customer(cid,"Subbarao","Bandi","India");		
	}

}
