package com.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.model.Employee;
import com.spring.boot.repo.EmpRepo;

@Controller
public class SpringController {
	@Autowired
	EmpRepo empRepo;
	
	@RequestMapping(value="/addNewEmp.html", method=RequestMethod.POST)
	public String newEmp(Employee emp){
		empRepo.save(emp);
		return ("redirect:/listEmployees.html");
	}
	
	@RequestMapping(value="/addNewEmployee.html",method=RequestMethod.GET)
	public ModelAndView addNewEmp(){
		Employee emp = new Employee();
		return new ModelAndView("newEmployee","form",emp);
	}
	@RequestMapping(value="/listEmployees.html",method=RequestMethod.GET)
	public ModelAndView listAllEmp(){
		List<Employee> allEmp = empRepo.findAll();
		return new ModelAndView("allEmployees","listAllEmp",allEmp);
	}

}
