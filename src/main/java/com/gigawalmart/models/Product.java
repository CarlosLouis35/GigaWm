package com.gigawalmart.models;

public abstract class Product{
	int id;
	String name;
	double price;
	double rating;
	
	//Method
	public void checkTotalSales() {
			
		}

	//Setters and getters
	
	// ***Getters
	
	 public int getId() {
		    return id;
		  }
	 public String getName() {
		    return name;
		  }
	 public double getPrice() {
		    return price;
		  }
	 public double getRating() {
		    return rating;
		  }
	
	// **Setters
	 
	  public void setId(int newId) {
		    this.id = newId;
		  }
	  public void setName(String newName) {
		    this.name = newName;
		  }
	  public void setPrice(double newPrice) {
		    this.price = newPrice;
		  }
	  public void setRating(double newRating) {
		    this.rating = newRating;
		  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
