package com.gigawalmart.models;

public class Customer {
	int c_id;
	String customername;
	int customer_pnum;
	String customeremail;
	
	public Customer() {}
	
	// customer constructor
	public Customer(int c_id, String customername, int customer_pnum, String customeremail) {
		this.c_id = c_id;
		this.customername = customername;
		this.customer_pnum = customer_pnum;
		this.customeremail = customeremail;
	}

	public String toString() {

		return this.c_id + " " + customername + " " + customer_pnum + " " + customeremail;
	}

	public boolean equals(Customer customer) {

		return (customer.c_id == this.c_id) && (customer.customername == this.customername)
				&& (customer.customer_pnum == this.customer_pnum) && (customer.customeremail == this.customeremail);
	}

	// Setters
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public void setCustomer_pnum(int customer_pnum) {
		this.customer_pnum = customer_pnum;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	
	//Getters
	public int getC_id() {
		return c_id;
	}
	
	public String getCustomername() {
		return customername;
	}
	
	public int getCustomer_pnum() {
		return customer_pnum;
	}
	
	public String getCustomeremail() {
		return customeremail;
	}
	
	
	




}
