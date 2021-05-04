package com.VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import com.VTI.ultis.ScannerUltis;

public class Account {
	public static int count;
	private int id;
	private String email;
	private String userName;
	private String fullName;

	public Account() {
		System.out.println("Mời nhập thông tin account");
		this.id = count;
		System.out.println("Mời nhập email");
		this.email = ScannerUltis.inputString();
		System.out.println("Mời nhập vào username");
		this.userName = ScannerUltis.inputString();
		System.out.println("Mời nhập vào fullname");
		this.fullName = ScannerUltis.inputString();

	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName + "]";
	}

}

