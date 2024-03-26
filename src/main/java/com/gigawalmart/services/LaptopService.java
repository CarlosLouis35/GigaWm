package com.gigawalmart.services;

import java.util.Scanner;

import com.gigawalmart.daos.LaptopDao;
import com.gigawalmart.daos.LaptopDaoImpl;
import com.gigawalmart.models.Laptop;
import com.gigawalmart.util.SQLConnection;

public class LaptopService {

	static LaptopDao laptopDao = new LaptopDaoImpl(SQLConnection.getConnection());

	public static void getAllLaptops() {

		if (laptopDao.getAllLaptops().size() > 0) {

			for (Laptop laptop : laptopDao.getAllLaptops()) {
				System.out.println(laptop);
			}
		} else {
			System.out.println("No laptop available");
		}
	}
	
public 
	static void addLaptop(Scanner sc) {

		System.out.println("Enter laptop name: ");
		String name = sc.nextLine();

		System.out.println("Enter laptop price: ");
		double price = sc.nextDouble();
		sc.nextLine();

		System.out.println("Enter laptop rating");
		double rating = sc.nextDouble();
		sc.nextLine();

		System.out.println("Enter laptop cpu name");
		String cpu = sc.nextLine();

		System.out.println("Enter laptop RAM size");
		int ramSize = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter laptop SSD size");
		int ssdSize = sc.nextInt();
	
		System.out.println("Enter laptop screen size");
		double screenSize = sc.nextDouble();
		sc.nextLine();

		Laptop laptop = new Laptop(0, name, price, rating, cpu, ramSize, ssdSize, screenSize);
		
		laptopDao.addLaptop(laptop);

		System.out.println("Laptop added successfully!");
	}

	public static void updateLaptop(Scanner sc) {
		System.out.println("Enter laptop id to update: ");
		int id = sc.nextInt();
		sc.nextLine();

		Laptop laptop = laptopDao.getLaptopById(id);
		if (laptop == null) {
			System.out.println("Laptop not found");
		} else {
			System.out.println("Enter new laptop name (or press Enter to skip this step): ");
			String name = sc.nextLine();

			System.out.println("Enter new laptop price (or press Enter to skip this step): ");
			Double price = sc.nextDouble();
			sc.nextLine();

			System.out.println("Enter new laptop rating (or press Enter to skip this step): ");
			Double rating = sc.nextDouble();
			sc.nextLine();

			System.out.println("Enter new laptop cpu name (or press Enter to skip this step): ");
			String cpu = sc.nextLine();

			System.out.println("Enter new laptop RAM size (or press Enter to skip this step): ");
			Double ramSize = sc.nextDouble();
			sc.nextLine();

			System.out.println("Enter new laptop SSD size (or press Enter to skip this step): ");
			Double ssdSize = sc.nextDouble();
			sc.nextLine();

			System.out.println("Enter new laptop screen size (or press Enter to skip this step): ");
			Double screenSize = sc.nextDouble();
			sc.nextLine();

			laptop.setName(name.isEmpty() ? laptop.getName() : name);
			laptop.setPrice(price != null ? laptop.getPrice() : price);
			laptop.setRating(rating != null ? laptop.getRating() : rating);
			laptop.setCpu(cpu.isEmpty() ? laptop.getCpu() : cpu);
			laptop.setName(name.isEmpty() ? laptop.getName() : name); // Si el size no es igual a nulo, o el valor es mayor que cero
			laptop.setSsdSize((int) (ssdSize != null && ssdSize > 0 ? ssdSize : laptop.getSsdSize())); // atrapara lo que este escrito como tambien se puede dejar en blanco
			laptop.setScreenSize(screenSize != null ? laptop.getScreenSize() : screenSize);
			laptopDao.updateLaptop(laptop);

			System.out.println("Laptop updated successfully!");

		}
	}

	public static void deleteLaptop(Scanner sc) {

		System.out.println("Enter laptop ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		laptopDao.deleteLaptop(id);

		System.out.println("Laptop deleted sucessfully!");
	}

	public static void getLaptopById(Scanner sc) {

		System.out.println("Enter laptop ID to retrieve laptop information: ");
		int id = sc.nextInt();
		sc.nextLine();

		Laptop laptop = laptopDao.getLaptopById(id);

		if (laptop == null) {
			System.out.println("Laptop not found");
		} else {
			System.out.println("Laptop ID: " + laptop.getId());
			System.out.println("Laptop name: " + laptop.getName());
			System.out.println("Laptop price: $" + laptop.getPrice());
			System.out.println("Laptop rating: " + laptop.getRating());
			System.out.println("Laptop cpu: " + laptop.getCpu());
			System.out.println("Laptop RAM size: " + laptop.getRamSize());
			System.out.println("Laptop SSD Size: " + laptop.getSsdSize());
			System.out.println("Laptop screen size: " + laptop.getScreenSize());
		}

	}

}
