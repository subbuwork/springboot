/**
 *      SpringJPAWithMYSQL
*       Apr 13, 2017
*       subbu
 */
package com.spring.jpa.postgresql.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.postgresql.model.Customer;
import com.spring.jpa.postgresql.model.CustomerRepository;



@RestController
@RequestMapping(value="/springjpapostgresql")
public class WebController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	CustomerRepository custRep;
	
	@RequestMapping("/save")
	public String process(){
		logger.info("Inside proces method....");
		custRep.save(new Customer("Subbarao","Bandi","Ongole India"));
		custRep.save(new Customer("Neelima", "Mukkala","Guntur India"));
		custRep.save(new Customer("Aadhya", "Bandi","Charlotte USA"));
		custRep.save(new Customer("Jason Daniel", "Bandi","Charlotte USA"));
		custRep.save(new Customer("Varsith", "Bandi","Ongole India"));
		return "done!!";
	}
	
	@RequestMapping("/getAllCustomers")
	public String findAll(){
		logger.info("Inside findAll() method...");
		String result = "<html>";
		for(Customer cust:custRep.findAll()){
			result += "<div>"+cust.toString()+"</dib>";
		}
		return result+"</html>";
	}
	
	@RequestMapping("getCustomerByID")
	public String findById(@RequestParam("eid")Integer eid){
		logger.info("Inside getCustomerByID().....");
		String result = "";
		result = custRep.findOne(new Long(eid)).toString();
		return result;
	}
	
	@RequestMapping("getCustomerByLastName")
	public String findByLastName(@RequestParam("lName")String lName){
		logger.info("Inside getCustomerByLastName.....");
		String result = "<html>";
		for(Customer cust:custRep.findCustomerBylName(lName)){
			result += "<div>"+cust.toString()+"</div>";
		}
		return result;
	}
}
