package com.VTI.entity;

public class SecondaryStudent extends Student{
	public static int countSec = 0;
	
	public SecondaryStudent(int id, String name) {
		super(id, name);
		countSec++;
		
	}
}
