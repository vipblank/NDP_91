package com.VTI.entity;

public class Student1 {
	private final int id ;
	private String name;
	
	
	public Student1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public final static void study() {
		System.out.println("Đang học bài");
	}

	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + "]";
	}

}	
