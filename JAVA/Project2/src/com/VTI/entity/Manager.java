package com.VTI.entity;

public class Manager extends User{
private int ExplnYear;
	
	public Manager(int id, String fullname, String email, String password, int ExplnYear) {
		super(id, fullname, email, password);
		this.ExplnYear = ExplnYear;
	}

	public int getExplnYear() {
		return ExplnYear;
	}

	public void setExplnYear(int explnYear) {
		ExplnYear = explnYear;
	}

	@Override
	public String toString() {
		return super.toString() +  "Manager [ExplnYear=" + ExplnYear + "]";
	}
}
