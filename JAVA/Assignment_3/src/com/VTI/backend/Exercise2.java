package com.VTI.backend;

import java.util.Scanner;
import com.VTI.ultis.ScannerUltis;

public class Exercise2 {
	private static Scanner sc;
	public void question1() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào họ");
		String addho = ScannerUltis.inputString().trim().toUpperCase();
		System.out.println("Mời nhập vào họ");
		String addten = ScannerUltis.inputString().trim().toUpperCase();	
		String fullname = addho + addten;
		System.out.println("Họ và tên đã nhập vào là: " + fullname);
	}

	public void question2() {
		
	}
	public void question3() {
		
	}
	public void question4() {
	}
}
