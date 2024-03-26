package com.gigawalmart.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gigawalmart.models.Laptop;


public class LaptopDaoImpl implements LaptopDao {

	private Connection connection;

	public LaptopDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void addLaptop(Laptop laptop) {
	  try (PreparedStatement statement = connection.prepareStatement(
	      "insert into laptop_db(l_name,l_price,l_rating,l_cpu,l_ram,l_ssd,l_scsize) values (?, ?, ?, ?, ?, ?, ?)")) {
	    statement.setString(1, laptop.getName());
	    statement.setDouble(2, laptop.getPrice());
	    statement.setDouble(3, laptop.getRating());
	    statement.setString(4, laptop.getCpu());
	    statement.setInt(5, laptop.getRamSize());
	    statement.setInt(6, laptop.getSsdSize());
	    statement.setDouble(7, laptop.getScreenSize());

	    statement.executeUpdate();

	  } catch (SQLException e) {
	   e.getStackTrace();
	} 
	  }
	
	@Override
	public void updateLaptop(Laptop laptop)  {
	  try (PreparedStatement statement = connection.prepareStatement(
	      "update laptop_db set l_name=?, l_price=?, l_rating=?, l_cpu=?, l_ram=?, l_ssd=?, l_scsize=? where l_id=?")) {

	    statement.setString(1, laptop.getName());
	    statement.setDouble(2, laptop.getPrice());
	    statement.setDouble(3, laptop.getRating());
	    statement.setString(4, laptop.getCpu());
	    statement.setInt(5, laptop.getRamSize() > 0 ? laptop.getRamSize() : null); // Set null for invalid RAM size
	    statement.setInt(6, laptop.getSsdSize() > 0 ? laptop.getSsdSize() : null); // Set null for invalid SSD size
	    statement.setDouble(7, laptop.getScreenSize());
	    statement.setInt(8, laptop.getId());

	    statement.executeUpdate();

	  } catch (SQLException e) {
		  e.printStackTrace();
	    
	  }
	}

	@Override
	public void deleteLaptop(int id) {
		try (PreparedStatement statement = connection.prepareStatement("delete from laptop_db where l_id=?")) {
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public
	Laptop getLaptopById(int id) {
		Laptop laptop = null;
		
		try (PreparedStatement statement = connection.prepareStatement(
				"select * from laptop_db where l_id = ?")) {
			statement.setInt(1,id);
			
			try(ResultSet rs = statement.executeQuery()){
				while(rs.next()) {
					
					String name = rs.getString("l_name");
					double price = rs.getDouble("l_price");
					double rating = rs.getDouble("l_rating");
					String cpu = rs.getString("l_cpu");
					int ramSize = rs.getInt("l_ram");
					int ssdSize = rs.getInt("l_ssd");
					double sreenSize = rs.getDouble("l_scsize");
					laptop = new Laptop(id, name, price, rating, cpu, ramSize, ssdSize, sreenSize);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laptop;
	}

	public List<Laptop> getAllLaptops() {
		List<Laptop> laptops = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement("select * from laptop_db");
				ResultSet rs = statement.executeQuery();
				){
			
			while(rs.next()) {
				int id = rs.getInt("l_id");
				String name = rs.getString("l_name");
				double price = rs.getDouble("l_price");
				double rating = rs.getDouble("l_rating");
				String cpu = rs.getString("l_cpu");
				int ramSize = rs.getInt("l_ram");
				int ssdSize = rs.getInt("l_ssd");
				double sreenSize = rs.getDouble("l_scsize");
				Laptop laptop = new Laptop(id, name, price, rating, cpu, ramSize, ssdSize, sreenSize);
				laptops.add(laptop);
			}	
			} catch (SQLException e) {
				e.printStackTrace();
				}
		
			return laptops;
		}
			
	}
