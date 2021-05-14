package com.VTI.entity;

public class Student {
	private int id;
	private String name;
	public static int count;
	public Student( String name) {
		super();
		count++;
		this.id = count;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
