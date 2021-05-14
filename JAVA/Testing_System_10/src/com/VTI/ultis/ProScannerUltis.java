package com.VTI.ultis;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ProScannerUltis {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.err.println("Nháº­p láº¡i:");
			}
		}
	}

	public static int inputIntPositive() {
		while (true) {
			try {
				int intPositive = Integer.parseInt(sc.next());
				if (intPositive >= 0) {
					return intPositive;
				} else {
					System.err.println("Nháº­p láº¡i:");
				}

			} catch (Exception e) {
				System.err.println("Nháº­p láº¡i:");
			}

		}
	}

	public static Float inputFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.next());
			} catch (Exception e) {
				System.err.println("Nháº­p láº¡i:");
			}
		}
	}

	public static Double inputDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.next());
			} catch (Exception e) {
				System.err.println("Nháº­p láº¡i:");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String string = sc.next().trim();
			if (!string.isEmpty()) {
				return string;
			} else {
				System.err.println("Nháº­p láº¡i:");
			}
		}
	}

	public static LocalDate inputLocalDate() {
		System.out.println("Nháº­p theo Ä‘á»‹nh dáº¡ng yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localdate = sc.next().trim();
			try {
				if (format.parse(localdate) != null) {
					LocalDate lc = LocalDate.parse(localdate);
					return lc;
				}
			} catch (Exception e) {
				System.err.println("Nháº­p láº¡i:");
			}

		}
	}

	public static String inputEmail() {
		while (true) {
			String email = ProScannerUltis.inputString();
			if (email == null || !email.contains("@")) {
				System.out.print("Nháº­p láº¡i: ");
			} else {
				return email;
			}
		}
	}

	public static int inputFunction(int a, int b, String errorMessage) {
		while (true) {
			int number = ProScannerUltis.inputInt();
			if (number >= a && number <= b) {
				return number;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputPassword() {
		while (true) {
			String password = ProScannerUltis.inputString();
			if (password.length() < 6 || password.length() > 12) {
				System.out.print("Nháº­p láº¡i: ");
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
				System.out.print("Má»�i báº¡n nháº­p láº¡i password: ");
			}
		}
	}

	public static String inputPhoneNumber() {
		while (true) {
			String number = ProScannerUltis.inputString();
			if (number.length() > 12 || number.length() < 9) {
				continue;
			}

			if (number.charAt(0) != '0') {
				continue;
			}

			boolean isNumber = true;

			for (int i = 0; i < number.length(); i++) {
				if (Character.isDigit(number.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return number;
			} else {
				System.out.print("Nháº­p láº¡i: ");
			}

		}
	}

}
