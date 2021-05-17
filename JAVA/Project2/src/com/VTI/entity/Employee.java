package com.VTI.entity;

public class Employee extends User{
private String proskill;
	
	public Employee(int id, String fullname, String email, String password, String proskill) {
		super(id, fullname, email, password);
		this.proskill = proskill;
	}

	public String getProskill() {
		return proskill;
	}

	public void setProskill(String proskill) {
		this.proskill = proskill;
	}

	@Override
	public String toString() {
		return super.toString() + "Employee [proskill=" + proskill + "]";
	}
}
