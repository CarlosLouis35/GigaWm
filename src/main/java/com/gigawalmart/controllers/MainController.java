package com.gigawalmart.controllers;

import java.sql.Connection;
import java.util.Scanner;

import com.gigawalmart.models.Employee;
import com.gigawalmart.services.CustomerService;
import com.gigawalmart.services.EmployeeService;
import com.gigawalmart.services.LaptopService;
import com.gigawalmart.services.SupportServices;
import com.gigawalmart.util.SQLConnection;

public class MainController 
{
    public static void main( String[] args ){
    	
    	Connection connection = null;
    	
    	connection= SQLConnection.getConnection();
    	
    	LaptopService laptopService = new LaptopService();
    	CustomerService customerService = new CustomerService();
    	EmployeeService employeeService = new EmployeeService();
    	SupportServices supportServices = new SupportServices();
    	
    	Scanner sc = new Scanner(System.in);
    	int option;
    	int optprod = 0;
    	
    	
    	do {
    		System.out.println("***** Giga Walmart *****");
    		System.out.println("Please, select a option.");
    		System.out.println("1.Laptop Inventory");
    		System.out.println("2.Customer Registry");
    		System.out.println("3.Employee/Technician Registry");
    		System.out.println("4.Support Ticket Registry"); 		
    		System.out.println("5.Exit");
    		System.out.println("Enter your choice");
    		option = sc.nextInt();
    		sc.nextLine();
    		
    		switch(option) {
    		case 1:
    			do {
    				System.out.println("Please, select a option.");
    	    		System.out.println("1.Add laptop");
    	    		System.out.println("2.Update laptop");
    	    		System.out.println("3.Delete laptop");
    	    		System.out.println("4.Get laptop");
    	    		System.out.println("5.Get laptop inventory");
    	    		System.out.println("6.Exit");
    	    		System.out.println("Enter your choice");
    	    		optprod = sc.nextInt();
    	    		sc.nextLine();
   
    			switch(optprod) {
    			case 1:
    				laptopService.addLaptop(sc); // G
    				break;

    			case 2:
    				laptopService.updateLaptop(sc); // G
    				break;
    			
    			case 3:    			
    				laptopService.deleteLaptop(sc); // G
    				break;
    				
    			case 4:
    				laptopService.getLaptopById(sc); // G
    				break;
    			
    			case 5:
    				laptopService.getAllLaptops(); // G
    				break;
    			case 6:
    				System.out.println("Goodbye");
    				break;
    			
    			default:
    				System.out.println("Invalid choice. Please, try again");
    			break;
    			} }while (optprod != 6);

    		case 2:
    			do {
    				System.out.println("Please, select a option.");
    	    		System.out.println("1.Add customer");
    	    		System.out.println("2.Update customer");
    	    		System.out.println("3.Delete customer");
    	    		System.out.println("4.Get customer");
    	    		System.out.println("5.Get customer list");
    	    		System.out.println("6.Exit");
    	    		System.out.println("Enter your choice");
    	    		optprod = sc.nextInt();
    	    		sc.nextLine();
   
    			switch(optprod) {
    			case 1:
    				customerService.addCustomer(sc); // G
    				break;

    			case 2:
    				customerService.updateCustomer(sc); // G
    				break;
    			
    			case 3:    			
    				customerService.deleteCustomer(sc);  // G
    				break;
    				
    			case 4:
    				customerService.getCustomerById(sc);  // G
    				break;
    			
    			case 5:
    				customerService.getAllCustomers();  // G
    				break;
    			case 6:
    				System.out.println("Goodbye");
    				break;
    			
    			default:
    				System.out.println("Invalid choice. Please, try again");
    			break;
    			} }while (optprod != 6);
    			
    		case 3:
    			do {
    				System.out.println("Please, select a option.");
    	    		System.out.println("1.Add employee");
    	    		System.out.println("2.Update employee");
    	    		System.out.println("3.Delete employee");
    	    		System.out.println("4.Get employee");
    	    		System.out.println("5.Get employee list");
    	    		System.out.println("6.Exit");
    	    		System.out.println("Enter your choice");
    	    		optprod = sc.nextInt();
    	    		sc.nextLine();
   
    			switch(optprod) {
    			case 1:
    				employeeService.addEmployee(sc);  // G
    				break;

    			case 2:
    				employeeService.updateEmployee(sc);  // G
    				break;
    			
    			case 3:    			
    				employeeService.deleteEmployee(sc);  // G
    				break;
    				
    			case 4:
    				employeeService.getEmployeeById(sc);  // G
    				break;
    			
    			case 5:
    				employeeService.getAllEmployees();  // G
    				break;
    			case 6:
    				System.out.println("Goodbye");
    				break;
    			
    			default:
    				System.out.println("Invalid choice. Please, try again");
    			break;
    			} }while (optprod != 6);
    		case 4:	
    			do {
    				System.out.println("Please, select a option.");
    	    		System.out.println("1.Add support ticket");
    	    		System.out.println("2.Update support ticket");
    	    		System.out.println("3.Delete support ticket");
    	    		System.out.println("4.Get support ticket");
    	    		System.out.println("5.Get support ticket registry");
    	    		System.out.println("6.Exit");
    	    		System.out.println("Enter your choice");
    	    		optprod = sc.nextInt();
    	    		sc.nextLine();
   
    			switch(optprod) {
    			case 1:
    				supportServices.addSupportTicket(sc); // G
    				break;

    			case 2:
    				supportServices.updateSupportTicket(sc); // G
    				break;
    			
    			case 3:    			
    				supportServices.deletesupport(sc); // G
    				break;
    				
    			case 4:
    				supportServices.getSupportTicketById(sc); // G
    				break;
    			
    			case 5:
    				supportServices.getSupportRegistry(); // G
    				break;
    			case 6:
    				System.out.println("Goodbye");
    				break;
    			
    			default:
    				System.out.println("Invalid choice. Please, try again");
    			break;
    			} }while (optprod != 6);
    		
    		case 5:	
    			System.out.println("Thanks for using our system. Goodbye");
    			break;
    			
    		default:
				System.out.println("Invalid choice. Please, try again");
    		}
    		
    	} while (option != 5);
    	sc.close();
    	
    }
}
