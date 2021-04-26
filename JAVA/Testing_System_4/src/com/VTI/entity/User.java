package com.VTI.entity;

public abstract class User {
	private String name;
	private double salaryratio;
	public User(String name, double salaryratio) {
		super();
		this.name = name;
		this.salaryratio = salaryratio;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalaryratio() {
		return salaryratio;
	}
	public void setSalaryratio(double salaryratio) {
		this.salaryratio = salaryratio;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", salaryratio=" + salaryratio + "]";
	}
	public abstract double calculatePay();
	
	public abstract void displayInfor();
}
