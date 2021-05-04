package com.VTI.ultis;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import com.VTI.entity.Department;

public class ScannerUltis {
	private static Scanner sc = new Scanner(System.in);
	
	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.err.println("Nhập lại");
			}
		}
	}	
	public static int inputInt2() {
		while (true) {
			try {
				int inputInt2 = Integer.parseInt(sc.next().trim());
				if (inputInt2 > 0) {
					return inputInt2;
				}else {
					System.err.println("Wrong inputing! The age must be greater than 0, please input again");	
				}
			} catch (Exception e) {
						System.err.println("wrong inputing! Please input an age as int, input again");	
			}
		}		
	}
	public static Float inputFloadt() {
		while (true) {
			try {
				Float inputFloadt = Float.parseFloat(sc.next().trim());
				return inputFloadt;
			} catch (Exception e) {
				System.err.println("Nhập lại");	
			}
		}	
	}
	public static LocalDate inputLocalDate () {
		System.out.println();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localdate = sc.next().trim();
			try {
				if (format.parse(localdate) != null) {
					LocalDate lc = LocalDate.parse(localdate);
					return lc;
				}
			} catch (Exception e) {
				System.err.println("Nhập lại");	
			}
		}	
	}
	public static String inputString() {
		while (true) {
			String input = sc.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			}else {
				System.err.println("Mời nhập lại");
			}
		}		
	}
}