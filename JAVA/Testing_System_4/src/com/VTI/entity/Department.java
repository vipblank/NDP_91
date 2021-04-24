package com.VTI.entity;

public class Department {
	public int id;
	public String name;

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Department(String name) {
		super();
		this.name = name;
		this.id = 2;
	}
			
	
	
	
	
}
	

	

