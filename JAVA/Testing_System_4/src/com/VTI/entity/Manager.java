package com.VTI.entity;

public class Manager extends User {

	public Manager(String name, double salaryratio) {
		super(name, salaryratio);
		
	}

	@Override
	public double calculatePay() {
		
		return getSalaryratio() *520;
	}

	@Override
	public void displayInfor() {
		
		
	}
	
}
