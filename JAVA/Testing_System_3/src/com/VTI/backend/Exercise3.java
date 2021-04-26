package com.VTI.backend;

import java.util.Scanner;

public class Exercise3 {
	public void question1() {
		System.out.println("Ex3 - Question1");
		Integer luong = 5000;
		float luongf = luong	;
		System.out.printf("%2.2f %n", luongf );
	}
	public void question2() {
		System.out.println("Ex3 - Question2");
		String str = "1234567";
		int a = Integer.parseInt(str);
		System.out.println(a);
		
	}
	public void question3() {
		System.out.println("Ex3 - Question3");
		Integer i = new Integer(1234567);
		int z = i.intValue();
		System.out.println(z);
	}

}
