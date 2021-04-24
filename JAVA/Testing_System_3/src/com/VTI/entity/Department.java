package com.VTI.entity;

public class Department {
	public int id;
	public String name;

	@Override
	public boolean equals(Object dep) {
		Department department = (Department) dep;
		if (name.equals(department.name)) {	
		}
		return true;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
