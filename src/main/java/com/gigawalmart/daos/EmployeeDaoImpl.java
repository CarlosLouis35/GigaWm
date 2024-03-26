package com.gigawalmart.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gigawalmart.models.Employee;



public class EmployeeDaoImpl implements EmployeeDao {

	private Connection connection;

	public EmployeeDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void addEmployee(Employee employee) {
	  try (PreparedStatement statement = connection.prepareStatement(
	      "insert into techemployee (tech_name, tech_reftag , tech_phonenum, tech_email) values (?, ?, ?, ?)")) {
	    statement.setString(1, employee.getTechname());
	    statement.setString(2,employee.getTagref());
	    statement.setInt(3,employee.getTech_pnum());
	    statement.setString(4, employee.getTechemail());
	
	    statement.executeUpdate();

	  } catch (SQLException e) {
	   e.getStackTrace();
	} 
	  }
	
	@Override
	public void updateEmployee(Employee employee)  {
	  try (PreparedStatement statement = connection.prepareStatement(
	      "update techemployee set tech_name = ?, tech_reftag = ? , tech_phonenum = ? , tech_email = ? where t_id=?")) {

	    statement.setString(1,employee.getTechname());
	    statement.setString(2,employee.getTagref());
	    statement.setInt(3, employee.getTech_pnum() > 0 ? employee.getTech_pnum() : null); // Set null for invalid RAM size
	    statement.setString(4, employee.getTechemail());
	    statement.executeUpdate();

	  } catch (SQLException e) {
		  e.printStackTrace();
	    
	  }
	}

	@Override
	public void deleteEmployee(int t_id) {
		try (PreparedStatement statement = connection.prepareStatement("delete from techemployee where t_id=?")) {
			statement.setInt(1, t_id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public
	Employee getEmployeeById(int t_id) {
		Employee employee = null;
		
		try (PreparedStatement statement = connection.prepareStatement(
				"select * from techemployee where tech_id = ?")) {
			statement.setInt(1,t_id);
			
			try(ResultSet rs = statement.executeQuery()){
				while(rs.next()) {

					String techname = rs.getString("tech_name");
					String tech_reftag = rs.getString("tech_reftag");
					int tech_pnum = rs.getInt("tech_phonenum");
					String techemail = rs.getString("tech_email");
					
					employee = new Employee(t_id, techname, tech_reftag, tech_pnum, techemail);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement("select * from techemployee");
				ResultSet rs = statement.executeQuery();
				){
			
			while(rs.next()) {
				int t_id = rs.getInt("tech_id");
				String techname = rs.getString("tech_name");
				String tech_reftag = rs.getString("tech_reftag");
				int tech_pnum = rs.getInt("tech_phonenum");
				String techemail = rs.getString("tech_email");
				
				Employee employee = new Employee(t_id, techname, tech_reftag, tech_pnum, techemail);
				
				employees.add(employee);
			}	
			} catch (SQLException e) {
				e.printStackTrace();
				}
		
			return employees;
		}
			
	}
