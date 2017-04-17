/**
 *      SpringJPAWithMYSQL
*       Apr 13, 2017
*       subbu
 */
package com.spring.jpa.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.jpa.mysql.model.Employee;

public interface EmployeeRep extends CrudRepository<Employee,Long> {
	List<Employee> findBylName(String lName);

}
