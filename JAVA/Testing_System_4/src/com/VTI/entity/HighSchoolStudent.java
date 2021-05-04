package com.VTI.entity;

import java.util.Scanner;

public class HighSchoolStudent extends Student_1{
	public static Scanner sc;
	private String clazz;
	private String desiredUniversity;
	
	public HighSchoolStudent(int id, String name, String clazz, String desiredUniversity) {
		super(id, name);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}

	@Override
	public String toString() {
		return super.toString() + "HighSchoolStudent [clazz=" + clazz + ", desiredUniversity=" + desiredUniversity + "]";
	}
		
}
