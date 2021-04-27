package com.VTI.entity;

public class Employee extends User{

	public Employee(String name, double salaryratio) {
		super(name, salaryratio);

	}

	@Override
	public double calculatePay() {

		return getSalaryratio() *420;
	}

	@Override
	public void displayInfor() {

		
	}
	
}
