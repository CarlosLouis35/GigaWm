package com.gigawalmart.daos;


import java.util.List;

import com.gigawalmart.models.Laptop;

public interface LaptopDao {

	void addLaptop(Laptop laptop);

	void updateLaptop(Laptop laptop);

	void deleteLaptop(int id);

	Laptop getLaptopById(int id);

	List<Laptop> getAllLaptops();

}
