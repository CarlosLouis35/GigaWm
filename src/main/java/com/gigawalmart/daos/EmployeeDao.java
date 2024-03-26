package com.gigawalmart.daos;

import java.util.List;

import com.gigawalmart.models.Employee;

public interface EmployeeDao {
	
	void addEmployee(Employee employee);
		
	void updateEmployee(Employee employee);
	
	void deleteEmployee(int t_id);
	
	Employee getEmployeeById(int t_id);
	
	List<Employee> getAllEmployees();
	
}
