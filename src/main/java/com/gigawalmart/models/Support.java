package com.gigawalmart.models;

public class Support {
	
	int s_id;
	String reftag;
	String techname;
	String customername;
	String supportdesc;
	float supportprice;
	String datetime;
	
	public Support() {}
	
	public Support(int s_id, String reftag, String techname, String customername, String supportdesc, float supportprice, String datetime) {
		
		this.s_id = s_id;
		this.reftag = reftag;
		this.techname = techname;
		this.customername = customername;
		this.supportdesc = supportdesc;
		this.supportprice = supportprice;
		this.datetime = datetime;
	}	
		
	public String toString() {
		
		return this.s_id + " " + reftag +  " " + techname + " " + customername + " " + supportdesc + " " + supportprice + " " + datetime;
	}	
	
	public boolean equals(Support support) {
		
		return (support.s_id == this.s_id) && (support.reftag == this.reftag) && (support.techname == this.techname) && (support.customername == this.customername)
				&& (support.supportdesc == this.supportdesc) && (support.supportprice == this.supportprice) && (support.datetime == datetime);
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public void setReftag(String reftag) {
		this.reftag = reftag;
	}

	public void setTechname(String techname) {
		this.techname = techname;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public void setSupportdesc(String supportdesc) {
		this.supportdesc = supportdesc;
	}

	public void setSupportprice(float supportprice) {
		this.supportprice = supportprice;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getS_id() {
		return s_id;
	}

	public String getReftag() {
		return reftag;
	}

	public String getTechname() {
		return techname;
	}

	public String getCustomername() {
		return customername;
	}

	public String getSupportdesc() {
		return supportdesc;
	}

	public float getSupportprice() {
		return supportprice;
	}

	public String getDatetime() {
		return datetime;
	}
	

}
