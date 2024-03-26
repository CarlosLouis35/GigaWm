package com.gigawalmart.models;

public class Employee {
	int t_id;
	String tagref;
	String techname;
	int tech_pnum;
	String techemail;
	
	public Employee() {}
	
	// tech constructor
	public Employee(int t_id, String techname, String tagref,  int tech_pnum, String techemail) {
		this.t_id = t_id;
		this.techname = techname;
		this.tagref = tagref;
		this.tech_pnum = tech_pnum;
		this.techemail = techemail;
	}

	public String toString() {

		return this.t_id + " " + techname + " "+ tagref + " " + tech_pnum + " " + techemail;
	}

	public boolean equals(Employee employee) {

		return (employee.t_id == this.t_id) && (employee.techname == this.techname)&& (employee.tagref == this.tagref)
				&& (employee.tech_pnum == this.tech_pnum) && (employee.techemail == this.techemail);
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public void setTagref(String tagref) {
		this.tagref = tagref;
	}

	public void setTechname(String techname) {
		this.techname = techname;
	}

	public void setTech_pnum(int tech_pnum) {
		this.tech_pnum = tech_pnum;
	}

	public void setTechemail(String techemail) {
		this.techemail = techemail;
	}

	public int getT_id() {
		return t_id;
	}

	public String getTagref() {
		return tagref;
	}

	public String getTechname() {
		return techname;
	}

	public int getTech_pnum() {
		return tech_pnum;
	}

	public String getTechemail() {
		return techemail;
	}

}
