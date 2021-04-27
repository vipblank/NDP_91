package com.VTI.entity;

public class Waiter extends User {

	public Waiter(String name, double salaryratio) {
		super(name, salaryratio);
		
	}

	@Override
	public double calculatePay() {
		
		return getSalaryratio() * 220;
	}

	@Override
	public void displayInfor() {
		
		
	}
	
}
