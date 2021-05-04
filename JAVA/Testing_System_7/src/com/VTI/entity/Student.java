package com.VTI.entity;

public class Student {
	private final int id;
	private String name;
	
	public Student() {

		this.id = 1;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
