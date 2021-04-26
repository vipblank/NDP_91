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

	public void question3() {
		System.out.println("Ex4 - Question3");
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Mời nhập vào tên ");
		String name = sc1.nextLine();
		String name1 = name.substring(0, 1).toUpperCase();
		String name2 = name.substring(1);
		name = name1 + name2;
		System.out.println("Tên của bạn là: " + name);
	}

	public void question4() {
		System.out.println("Ex4 - Question4");
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Mời nhập vào tên ");
		String name = sc1.nextLine();
		for (int s = 0; s < name.length(); s++) {
			System.out.println("Ki tự thứ: " + s + " là " + name.charAt(s));
		}
	}

	public void question5() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Ex4 - Question5");
		System.out.println("Mời nhập vào họ ");
		String ho = sc2.nextLine();
		System.out.println("Mời nhập vào tên ");
		String ten = sc2.nextLine();
		String fullname = ho + ten;
		System.out.println("họ và tên của bạn là: " + fullname);
	}
	
}
