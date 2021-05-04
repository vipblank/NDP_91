package com.VTI.backend;

import java.util.Scanner;

public class Exercise1 {
	public void question1() {
		System.out.println("Ex1 - Question1");
		float luong1 = 5240.5f;
		float luong2 = 10970.055f;
		int a = (int) luong1;
		int b = (int) luong2;
		System.out.println("luong account1 : " + a );
		System.out.println("luong account2 : " + b);
	}
	public void question4() {
		System.out.println("Ex1 - Question4");
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào số thứ 1 :");
		int a = sc1.nextInt();
		System.out.println("Mời bạn nhập vào số thứ 2 :");
		int b = sc1.nextInt();
		float c = (float)a / b;
		System.out.println("thương của 2 số là : " + (float)c);
	}
}
