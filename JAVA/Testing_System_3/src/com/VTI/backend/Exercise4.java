package com.VTI.backend;

import java.util.Scanner;

public class Exercise4 {
	public void question1() {
		System.out.println("Ex4 - Question1");
		Scanner sc = new Scanner(System.in);
		System.out.println("xin nhập vào chuỗi kí tự: ");
		String str = sc.next();
		String[] words = str.split("");
		System.out.println("đếm chuỗi kí tự : " + words.length);
		sc.close();
	}
	public void question2() {
		System.out.println("Ex4 - Question2");
		Scanner sc1 = new Scanner(System.in);
		String str1;
		String str2;
		System.out.println("xin nhập vào chuỗi kí tự thứ 1: ");
		str1 = sc1.next();
		System.out.println("xin nhập vào chuỗi kí tự thứ 2: ");
		str2 = sc1.next();
		System.out.println("Nối 2 chuỗi kí tự: " + str1 + "" + str2);
		sc1.close();
	}
}
