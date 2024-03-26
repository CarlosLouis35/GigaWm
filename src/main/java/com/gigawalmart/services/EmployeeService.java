package com.gigawalmart.services;

import java.util.Scanner;

import com.gigawalmart.daos.*;
import com.gigawalmart.models.Customer;
import com.gigawalmart.models.Employee;
import com.gigawalmart.util.SQLConnection;

public class EmployeeService {

	static EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(SQLConnection.getConnection());

	public static void getAllEmployees() {

		if (employeeDao.getAllEmployees().size() > 0) {

			for (Employee employee : employeeDao.getAllEmployees()) {
				System.out.println(employee);
			}
		} else {
			System.out.println("No technician or employee available");
		}

	}
	
	public static void addEmployee(Scanner sc) {

		System.out.println("Enter employee/technician name: ");
		String techname = sc.nextLine();
		
		System.out.println("Enter employee/technician tag reference: ");
		String tagref= sc.nextLine();

		System.out.println("Enter employee/technician phone number: ");
		int tech_pnum = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter employee/technician email: ");
		String techemail = sc.nextLine();

		Employee employee = new Employee(0, techname, tagref, tech_pnum, techemail);
		
		employeeDao.addEmployee(employee);

		System.out.println("Employee/Technician added successfully!");
	}

	public static void updateEmployee(Scanner sc) {
		System.out.println("Enter employee/technician id to update: ");
		int t_id = sc.nextInt();
		sc.nextLine();
		Employee employee = employeeDao.getEmployeeById(t_id);

		if (employee == null) {
			System.out.println("Employee/Technician not found");
		} else {
			System.out.println("Enter new employee/technician name (or press Enter to skip this step): ");
			String techname = sc.nextLine();
			
			System.out.println("Enter new employee/technician name (or press Enter to skip this step): ");
			String tagref = sc.nextLine();

			System.out.println("Enter new employee/technician phone number (or press Enter to skip this step): ");
			int tech_pnum = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter new employee/technician email (or press Enter to skip this step): ");
			String techemail = sc.nextLine();
			
			employee.setTechname(techname.isEmpty() ? employee.getTechname() : techname);
			employee.setTagref(tagref.isEmpty() ? employee.getTagref() : tagref);
			employee.setTech_pnum(tech_pnum > 0 ? tech_pnum : employee.getTech_pnum());
			employee.setTechemail(techemail.isEmpty() ? employee.getTechemail() : techemail);


			System.out.println("Employee/Technician updated successfully!");

		}
	}

	public static void deleteEmployee(Scanner sc) {

		System.out.println("Enter Employee/Technician ID to delete: ");
		int t_id = sc.nextInt();
		sc.nextLine();
		employeeDao.deleteEmployee(t_id);

		System.out.println("Customer deleted sucessfully!");
	}

	public static void getEmployeeById(Scanner sc) {

		System.out.println("Enter employee/technician ID to retrieve information: ");
		int t_id = sc.nextInt();
		sc.nextLine();

		Employee employee = employeeDao.getEmployeeById(t_id);

		if (employee == null) {
			System.out.println("Employee/Technician not found");
		} else {
			System.out.println("Employee/Tech ID: " + employee.getT_id());
			System.out.println("Employee/Tech name: " + employee.getTechname());
			System.out.println("Employee/Tech Tag Reference: " + employee.getTagref());
			System.out.println("Employee/Tech phone number: " + employee.getTech_pnum());
			System.out.println("Employee/Tech email: " + employee.getTechemail());
	
		}

	}

}
