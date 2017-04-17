
package com.spring.boot.batch.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;









import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;









import org.springframework.stereotype.Repository;

import com.spring.boot.batch.model.Customer;
import com.spring.boot.batch.sql.constants.SqlConstants;
/**
 * Author : Subbu
 *SpringBatchCSVMYSQL
 *CustomerDaoImpl.java
 *Apr 11, 2017
 */
@Repository
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertCustomer(List<? extends Customer> customers) {
	  logger.info(this.getClass().getName(),"insertCustomer()::::",customers);
    
      getJdbcTemplate().batchUpdate(SqlConstants.INSERT_CUSTOMER,new BatchPreparedStatementSetter() {
	  public void setValues(PreparedStatement ps, int i) throws SQLException {
			Customer customer = customers.get(i);
			ps.setInt(1,customer.getCid());
			ps.setString(2, customer.getfName());
			ps.setString(3,customer.getlName());
			ps.setString(4,customer.getAddress());
		}
		public int getBatchSize() {
			return customers.size();
		}
	});
	}

	public List<Customer> getCustomers() {
		logger.info("Start:::getCustomers():::");
		
		List<Map<String,Object>> rows =getJdbcTemplate().queryForList(SqlConstants.GET_CUSTOMERS);
		Customer customer;
		List<Customer> customersList = new ArrayList<Customer>();
		for(Map<String,Object> row:rows){
			customer = new Customer();
			customer.setCid((Integer)row.get("cid"));
			customer.setfName((String) row.get("fName"));
			customer.setlName((String)row.get("lName"));
			customer.setAddress((String)row.get("address"));
			customersList.add(customer);
		}
		logger.info("End:::getCustomers():::",customersList);
		return customersList;
		
	}

}
