package com.gigawalmart.services;



import java.util.Scanner;

import com.gigawalmart.daos.SupportDaoImpl;
import com.gigawalmart.models.Support;
import com.gigawalmart.util.SQLConnection;


public class SupportServices {
	
	static SupportDaoImpl supportDao = new SupportDaoImpl(SQLConnection.getConnection());
	
	public static void getSupportRegistry() {
		
		if (supportDao.getSupportRegistry().size() > 0) {

			for (Support support : supportDao.getSupportRegistry()) {
				System.out.println(support);
			}
		} else {
			System.out.println("No support registry available");
		}

	}

	public static void addSupportTicket(Scanner sc) {
		
		System.out.println("Enter support/technician tag reference tag: ");
		String reftag= sc.nextLine();
		
		System.out.println("Enter support/technician name: ");
		String techname = sc.nextLine();

		System.out.println("Enter customer name: ");
		String customername = sc.nextLine();
		
		System.out.println("Enter support ticket description: ");
		String supportdesc= sc.nextLine();
		
		System.out.println("Enter support service price: ");
		float supportprice = sc.nextFloat();
		
		Support support = new Support(0, reftag, techname, customername, supportdesc, supportprice, supportdesc );
		
		
		supportDao.addSupportTicket(support);
		

		System.out.println("Support ticket added successfully!");
	}
	
	public static void updateSupportTicket(Scanner sc) {
		System.out.println("Enter support ticket id to update: ");
		int s_id = sc.nextInt();
		sc.nextLine();
		Support support = supportDao.getSupportTicketById(s_id);
		
		if (support == null) {
			System.out.println("support/Technician not found");
		} else {
			System.out.println("Enter new support/technician name (or press Enter to skip this step): ");
			String reftag = sc.nextLine();
			
			System.out.println("Enter new support/technician name (or press Enter to skip this step): ");
			String techname = sc.nextLine();

			System.out.println("Enter new customer name (or press Enter to skip this step): ");
			String customername = sc.nextLine();
			
			System.out.println("Enter new support description (or press Enter to skip this step): ");
			String supportdesc = sc.nextLine();
			
			System.out.println("Enter new support price (or press Enter to skip this step): ");
			float supportprice = sc.nextFloat();
			sc.nextLine();
			
			support.setReftag(reftag.isEmpty() ? support.getReftag() : reftag);
			support.setTechname(techname.isEmpty() ? support.getTechname() : techname);
			support.setCustomername(customername.isEmpty() ? support.getCustomername() : customername);
			support.setSupportdesc(supportdesc.isEmpty() ? support.getSupportdesc() : supportdesc);
			support.setSupportprice(supportprice > 0 ? supportprice : support.getSupportprice());
			

			System.out.println("Support ticket updated successfully!");		
	}
		
	}
	
	public static void deletesupport(Scanner sc) {

		System.out.println("Enter support ticket ID to delete: ");
		int s_id = sc.nextInt();
		sc.nextLine();
		supportDao.deleteSupportTicket(s_id);

		System.out.println("Customer deleted sucessfully!");
	}
	
	public static void getSupportTicketById(Scanner sc) {

		System.out.println("Enter support ID to retrieve information: ");
		int s_id = sc.nextInt();
		sc.nextLine();

//		support support = supportDao.getsupportById(t_id);
		Support support = supportDao.getSupportTicketById(s_id);

		if (support == null) {
			System.out.println("Support ticket not found");
		} else {
			System.out.println("Support ticket ID: " + support.getS_id());
			System.out.println("Employee/Tech Tag Reference: " + support.getReftag());
			System.out.println("Employee/Tech name: " + support.getTechname());
			System.out.println("Customer name: " + support.getCustomername());
			System.out.println("Support description: " + support.getSupportdesc());
			System.out.println("Support price: " + support.getSupportprice());
			System.out.println("Support date: " + support.getDatetime());
			
			

	
		}

	}

	
}