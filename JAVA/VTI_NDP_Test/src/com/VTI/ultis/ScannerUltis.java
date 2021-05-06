package com.VTI.ultis;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUltis {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.err.println("Mời nhập lại");
			}
		}
	}

	public static int inputInt2() {
		while (true) {
			try {
				int inputInt2 = Integer.parseInt(sc.next().trim());
				if (inputInt2 > 0) {
					return inputInt2;
				} else {
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
				System.err.println("Mời nhập lại");
			}
		}
	}

	public static LocalDate inputLocalDate() {
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
				System.err.println("Mời nhập lại");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String input = sc.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println("Mời nhập lại");
			}
		}
	}

	public static int inputScore() {
		while (true) {
			try {
				int inputInt2 = Integer.parseInt(sc.next().trim());
				if (inputInt2 > 0 && inputInt2 <= 10) {
					return inputInt2;
				} else {
					System.err.println("Wrong inputing! please input again");
				}
			} catch (Exception e) {
				System.err.println("wrong inputing! Please input an age as int, input again");
			}
		}
	}

	public static String inputEmail() {
		while (true) {
			String email = ScannerUltis.inputString();
			if (email == null || !email.contains("@")) {
				System.err.println("Xin nhập đúng định dạng email: ...@...");
			} else {
				return email;
			}
		}

	}

	public static int inputFunction(int a, int b, String errorMessage) {
		while (true) {
			int number = ScannerUltis.inputInt2();
			if (number >= a && number <= b) {
				return number;
			} else {
				System.out.println(errorMessage);
			}
		}
	}

	public static String inputPassword() {
		while (true) {
			String password = ScannerUltis.inputString();
			if (password.length() < 6 || password.length() > 12) {
				System.out.println("Mời nhập lại");
				continue;
			}
			boolean hasAtLeast1Character = false;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					hasAtLeast1Character = true;
					break;
				}
			}
			if (hasAtLeast1Character == true) {
				return password;
			} else {
				System.err.println("Mời bạn nhập lại password: bao gồm 6-12 kí tự và tối thiểu 1 kí tự viết hoa");
			}
		}
	}
	public static String inputPhonenumber() {
		while (true) {
			String phonnumber = ScannerUltis.inputString();
			if (phonnumber.length() < 9 || phonnumber.length() > 12) {
				System.err.println("Mời nhập lại");
				continue;
			}
			if (phonnumber.charAt(0) != '0') {
				System.err.println("Mời nhập lại");
				continue;
			}
			boolean isNumber = true;
			for (int i = 0; i < phonnumber.length(); i++) {
				if (Character.isDigit(phonnumber.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return phonnumber;
			}else {
				System.err.println("Mời nhập lại theo định dạng");
			}
		}
	}
}