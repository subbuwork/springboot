/**
 *      SpringJPAWithMYSQL
*       Apr 13, 2017
*       subbu
 */
package com.spring.jpa.mysql.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.mysql.model.Employee;
import com.spring.jpa.mysql.repo.EmployeeRep;

@RestController
@RequestMapping(value="/springjpamysql")
public class WebController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	EmployeeRep employeeRep;
	
	@RequestMapping("/save")
	public String process(){
		logger.info("Inside proces method....");
		employeeRep.save(new Employee("Subbarao","Bandi", "IT",12000.0000,"Ongole India"));
		employeeRep.save(new Employee("Neelima", "Mukkala", "IT", 13000.0000,"Guntur India"));
		employeeRep.save(new Employee("Aadhya", "Bandi", "IT", 1000000.0000,"Charlotte USA"));
		employeeRep.save(new Employee("Jason Daniel", "Bandi", "IT", 1300000.0000,"Charlotte USA"));
		employeeRep.save(new Employee("Varsith", "Bandi", "IT", 12000.0000,"Ongole India"));
		return "done!!";
	}
	
	@RequestMapping("/getAllEmployees")
	public String findAll(){
		logger.info("Inside findAll() method...");
		String result = "<html>";
		for(Employee emp:employeeRep.findAll()){
			result += "<div>"+emp.toString()+"</dib>";
		}
		return result+"</html>";
	}
	
	@RequestMapping("getEmployeeByID")
	public String findById(@RequestParam("eid")Integer eid){
		logger.info("Inside getEmployeeByID().....");
		String result = "";
		result = employeeRep.findOne(new Long(eid)).toString();
		return result;
	}
	
	@RequestMapping("getEmployeeByLastName")
	public String findByLastName(@RequestParam("lName")String lName){
		logger.info("Inside getEmployeeByLastName.....");
		String result = "<html>";
		for(Employee emp:employeeRep.findBylName(lName)){
			result += "<div>"+emp.toString()+"</div>";
		}
		return result;
	}
}
