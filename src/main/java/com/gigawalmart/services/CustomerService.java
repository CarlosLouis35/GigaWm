package com.gigawalmart.services;

import java.util.Scanner;

import com.gigawalmart.daos.CustomerDaoImpl;

import com.gigawalmart.models.Customer;

import com.gigawalmart.util.SQLConnection;

public class CustomerService {

	static CustomerDaoImpl customerDao = new CustomerDaoImpl(SQLConnection.getConnection());

	public static void getAllCustomers() {

		if (customerDao.getAllCustomers().size() > 0) {

			for (Customer customer : customerDao.getAllCustomers()) {
				System.out.println(customer);
			}
		} else {
			System.out.println("No customer available");
		}

	}
	
	public static void addCustomer(Scanner sc) {

		System.out.println("Enter customer name: ");
		String customername = sc.nextLine();

		System.out.println("Enter customer phone number: ");
		int customer_pnum = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter customer email: ");
		String customeremail = sc.nextLine();

		Customer customer = new Customer(0,customername, customer_pnum, customeremail);
		
		customerDao.addCustomer(customer);

		System.out.println("Customer added successfully!");
	}

	public static void updateCustomer(Scanner sc) {
		System.out.println("Enter customer id to update: ");
		int c_id = sc.nextInt();
		sc.nextLine();

		Customer customer = customerDao.getCustomerById(c_id);
		if (customer == null) {
			System.out.println("Customer not found");
		} else {
			System.out.println("Enter new customer name (or press Enter to skip this step): ");
			String customername = sc.nextLine();

			System.out.println("Enter new customer phone number (or press Enter to skip this step): ");
			int customer_pnum = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter new customer email (or press Enter to skip this step): ");
			String customeremail = sc.nextLine();

			customer.setCustomername(customername.isEmpty() ? customer.getCustomername() : customername);
			customer.setCustomer_pnum(customer_pnum > 0 ? customer_pnum : customer.getCustomer_pnum()); // Si el size no es igual a nulo, o el valor es mayor que cero
			customer.setCustomeremail(customeremail.isEmpty() ? customer.getCustomeremail() : customeremail);

			System.out.println("Customer updated successfully!");

		}
	}

	public static void deleteCustomer(Scanner sc) {

		System.out.println("Enter customer ID to delete: ");
		int c_id = sc.nextInt();
		sc.nextLine();
		customerDao.deleteCustomer(c_id);

		System.out.println("Customer deleted sucessfully!");
	}

	public static void getCustomerById(Scanner sc) {

		System.out.println("Enter Customer ID to retrieve information: ");
		int c_id = sc.nextInt();
		sc.nextLine();

		Customer customer = customerDao.getCustomerById(c_id);

		if (customer == null) {
			System.out.println("Customer not found");
		} else {
			System.out.println("Customer ID: " + customer.getC_id());
			System.out.println("Customer name: " + customer.getCustomername());
			System.out.println("Customer phone number: " + customer.getCustomer_pnum());
			System.out.println("Customer email: " + customer.getCustomeremail());
	
		}

	}



}
