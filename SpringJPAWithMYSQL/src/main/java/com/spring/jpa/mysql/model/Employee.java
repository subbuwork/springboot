/**
 *      SpringJPAWithMYSQL
*       Apr 13, 2017
*       subbu
 */
package com.spring.jpa.mysql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long  eid;
	
	@Column(name="fName")
	private String fName;
	
	@Column(name="lNmae")
	private String lName;
	
	@Column(name="dept")
	private String dept;
	
	@Column(name="sal")
	private Double sal;
	
	@Column(name="address")
	private String address;
	
	protected Employee(){}

	public Employee(String fName, String lName, String dept,Double sal, String address) {
		//this.eid = eid;
		this.fName = fName;
		this.lName = lName;
		this.dept = dept;
		this.sal = sal;
		this.address = address;
		//this.country = country;
	}

	/*public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}*/

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}*/
	public String toString() {
		return String.format("Customer[eid=%d,fName='%s',lName='%s',Dept='%s',sal=%f,address='%s']",
				             eid,fName,lName,dept,sal,address);
	}
}
