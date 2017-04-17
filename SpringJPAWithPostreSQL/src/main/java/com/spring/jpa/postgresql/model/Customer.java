package com.spring.jpa.postgresql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long cid;
	
	@Column(name="fName")
	private String fName;
	
	@Column(name="lName")
	private String lName;
	
	@Column(name="address")
	private String address;
	
	
	public Customer(){}

	public Customer(String fName, String lName, String address) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String toString() {
		return String.format("Customer[cid=%d,FirstName='%s',LastName='%s',Address='%s']", cid,fName,lName,address);
	}
	
	
	
}
