package com.gigawalmart.models;

public class Laptop extends Product {

	double screenSize;
	int ramSize;
	int ssdSize;
	String cpu;

	public Laptop() {}
	
	// Laptop Constructor

	public Laptop(int id, String name, double price, double rating, String cpu, int ramSize, int ssdSize,
			double screenSize) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.cpu = cpu;
		this.ramSize = ramSize;
		this.ssdSize = ssdSize;
		this.screenSize = screenSize;

	}

	// Overriding

	@Override
	public String toString() {
		return this.id + " " + this.cpu + " " + this.price + " " + this.ramSize + " " + this.ssdSize + " "
				+ this.screenSize;
	}

	// Laptop Equals

	public boolean equals(Laptop laptop) {
		return (laptop.id == this.id) && (laptop.cpu == this.cpu) && (laptop.ramSize == this.ramSize)
				&& (laptop.ssdSize == this.ssdSize) && (laptop.screenSize == this.screenSize)
				&& (laptop.price == this.price);
	}

	// Setters and getters

	public String getCpu() {
		return cpu;
	}

	public int getRamSize() {
		return ramSize;
	}

	public int getSsdSize() {
		return ssdSize;
	}

	public double getScreenSize() {
		return screenSize;
	}

	// **Setters

	public void setCpu(String newCpu) {
		this.cpu = newCpu;
	}

	public void setRamSize(int newRamSize) {
		this.ramSize = newRamSize;
	}

	public void setSsdSize(int newSsdSize) {
		this.ssdSize = newSsdSize;
	}

	public void setScreenSize(double newScreenSize) {
		this.screenSize = newScreenSize;
	}
}
