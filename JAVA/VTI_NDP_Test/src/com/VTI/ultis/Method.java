package com.VTI.ultis;

import java.util.Scanner;

public class Method {
	private static Scanner sc;
	
	public static void inpruInterger() {
		sc = new Scanner(System.in);
		while (true) {
			try {
				int input = Integer.parseInt(sc.next().trim());
				if (input >0) {
					return;
				}
			} catch (Exception e) {
				
			}
		}
	}
}
