package com.spring.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Long> {

}
