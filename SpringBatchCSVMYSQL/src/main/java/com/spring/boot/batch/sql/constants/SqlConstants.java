
package com.spring.boot.batch.sql.constants;
/**
 * Author : Subbu
 *SpringBatchCSVMYSQL
 *SqlConstants.java
 *Apr 11, 2017
 */
public class SqlConstants {
	public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER"+"(cid,fName,lName,address) values(?,?,?,?);";
	public static final String GET_CUSTOMERS = "select * from customer";
}
