package com.gigawalmart.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gigawalmart.models.Customer;



public class CustomerDaoImpl implements CustomerDao {

	private Connection connection;

	public CustomerDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void addCustomer(Customer customer) {
	  try (PreparedStatement statement = connection.prepareStatement(
	      "insert into customer(customer_name, customer_phonenum, customer_email) values (?, ?, ?)")) {
	    statement.setString(1, customer.getCustomername());
	    statement.setInt(2,customer.getCustomer_pnum());
	    statement.setString(3, customer.getCustomeremail());
	
	    statement.executeUpdate();

	  } catch (SQLException e) {
	   e.getStackTrace();
	} 
	  }
	
	@Override
	public void updateCustomer(Customer customer)  {
	  try (PreparedStatement statement = connection.prepareStatement(
	      "update customer set customer_name=?, customer_phonenume=?, customer_email=? where l_id=?")) {

	    statement.setString(1,customer.getCustomername());
	    statement.setInt(2, customer.getCustomer_pnum() > 0 ? customer.getCustomer_pnum() : null); // Set null for invalid RAM size
	    statement.setString(3, customer.getCustomeremail());
	    statement.executeUpdate();

	  } catch (SQLException e) {
		  e.printStackTrace();
	    
	  }
	}

	@Override
	public void deleteCustomer(int c_id) {
		try (PreparedStatement statement = connection.prepareStatement("delete from customer where customer_id=?")) {
			statement.setInt(1, c_id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public
	Customer getCustomerById(int c_id) {
		Customer customer = null;
		
		try (PreparedStatement statement = connection.prepareStatement(
				"select * from customer where customer_id = ?")) {
			statement.setInt(1,c_id);
			
			try(ResultSet rs = statement.executeQuery()){
				while(rs.next()) {

					String customername = rs.getString("customer_name");
					int customer_pnum = rs.getInt("customer_phonenum");
					String customeremail = rs.getString("customer_email");
					customer = new Customer(c_id, customername,customer_pnum,customeremail );
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement("select * from customer");
				ResultSet rs = statement.executeQuery();
				){
			
			while(rs.next()) {
				int c_id = rs.getInt("customer_id");
				String customername = rs.getString("customer_name");
				int customer_pnum = rs.getInt("customer_phonenum");				
				String customeremail = rs.getString("customer_email");

				Customer customer = new Customer(c_id, customername, customer_pnum, customeremail);
				customers.add(customer);
			}	
			} catch (SQLException e) {
				e.printStackTrace();
				}
		
			return customers;
		}
			
	}
