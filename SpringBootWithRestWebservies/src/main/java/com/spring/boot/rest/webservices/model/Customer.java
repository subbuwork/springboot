/**
 * 
 */
package com.spring.boot.rest.webservices.model;

/**
 * @author subbu
 *
 */
public class Customer {
	
	private Integer cid;
	private String fName;
	private String lName;
	private String address;
	
	
	
	public Customer(){}



	public Customer(Integer cid, String fName, String lName, String address) {
		super();
		this.cid = cid;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
	}



	public Integer getCid() {
		return cid;
	}



	public void setCid(Integer cid) {
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
	
	@Override
    public String toString() {
        String info = String.format("Customer Info: Customer ID=%d, firstname = %s, lastname = %s, address = %s", 
                                                cid, fName, lName,address);
        return info;
    }

}
