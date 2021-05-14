package com.VTI.entity;

public class PrimaryStudent extends Student{
	public static int countPri = 0;
	
	public PrimaryStudent(int id, String name) {
		super(id, name);
		countPri++;
		
	}

}
