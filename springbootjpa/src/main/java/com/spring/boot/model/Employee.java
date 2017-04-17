package com.spring.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer eid;
	private String nam;
	private String dept;
	
	public Employee(){
		
	}

	public Employee(Integer eid, String nam, String dept) {
		super();
		this.eid = eid;
		this.nam = nam;
		this.dept = dept;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
