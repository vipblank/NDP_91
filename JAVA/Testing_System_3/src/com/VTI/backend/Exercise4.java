package com.VTI.backend;

import java.util.Scanner;

public class Exercise4 {
	private static Scanner sc;
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
	public static void question7() {
		String fullName;
		sc = new Scanner(System.in);
		System.out.println("Nhập họ tên đầy đủ");
		fullName = sc.nextLine();
		sc.close();
		// remove space characters
		fullName = fullName.replaceAll("\\s+", " ");
		System.out.println("test: "+ fullName);
		String[] words = fullName.split(" ");
		fullName = "";
		for (String word : words) {
		String firstCharacter = word.substring(0, 1).toUpperCase();
		String leftCharacter = word.substring(1);
		word = firstCharacter + leftCharacter;
		fullName += word;
		}
		System.out.println("Họ tên sau khi chuẩn hóa: " + fullName);
		}
	public static void question10() {
		sc = new Scanner(System.in);
		String s1, s2, reverseS1 = "";
		System.out.println("Mời nhập vào 1 chuỗi kí tự");
		s1 = sc.nextLine();
		System.out.println("Mời nhập vào 1 chuỗi kí tự");
		s2 = sc.nextLine();
		sc.close();
		for (int i = s1.length() -1; i >= 0; i--) {
			reverseS1 += s1.substring(i, i + 1);
		}
			if (s2.equals(reverseS1)) {
				System.out.println("Đây là chuỗi đảo");
			}else {
				System.out.println("Đây không phải chuỗi đảo");
		}	
	}
	public static void question11() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào 1 chuỗi kí tự");
		String str = sc.nextLine();
		sc.close();
		int count = 0;
		for (int i = count; i < str.length(); i++) {
			if ('a' == str.charAt(i)) {
				count++;	
			}
		}
		System.out.println("Số lần chữ 'a' lặp trong chuỗi kí tự là: " + count);
	}
	public static void question12() {
		sc = new Scanner(System.in);
		String reverse = "";
		System.out.println("Mời nhập vào 1 chuỗi kí tự");
		String str = sc.nextLine();
		sc.close();
		for (int i = str.length() -1 ; i >= 0; i--) {
			reverse += str.charAt(i);
		}
		System.out.println(reverse);
	}
	public static void question13() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào 1 chuỗi kí tự");
		String str = sc.nextLine();
		sc.close();
		for (int i = 0; i < str.length(); i++) {
			if (checkKeyNumber(str.charAt(i))) {
				System.out.println("False");
				return;
			}
		}
		System.out.println("True");
	}
	public static boolean checkKeyNumber(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}else {
			return false;
		}
	}
	public static void question14() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào 1 chuỗi kí tự");
		String str = sc.nextLine();
		sc.close();
		String replace = str.replaceAll("e", "*");
		System.out.println(replace);
	}
	public static void question15() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào 1 chuỗi kí tự");
		String str = sc.nextLine().trim();
		sc.close();
		str = str.replaceAll("\\s+", " ");
		String[] name = str.split(" ");
		for (int i = name.length -1; i >= 0; i--) {
			System.out.println(name[i] + "");
		}
	}
	public static void question16() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào 1 chuỗi kí tự");
		String str = sc.nextLine();
		System.out.println("Mời nhập vào n");
		int n = sc.nextInt();
		sc.close();
		if (str == null || str.isEmpty()||str.length() %n != 0) {
			System.out.println("No");
			return;
		}
		for (int i = 0; i < str.length(); i+=n) {
			System.out.println(str.substring(i, i+n));
		}
	}
}
