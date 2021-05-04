package com.VTI.entity;

public abstract class Student_1 extends Person{
	private int id;
	
	public Student_1(int id, String name) {
		super(name);
		this.id = id;
	}

	@Override
	public String toString() {
		return  super.toString() + "Student_1 [id=" + id + "]";
	}
	
}
