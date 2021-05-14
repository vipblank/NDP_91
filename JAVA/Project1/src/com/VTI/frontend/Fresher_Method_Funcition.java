package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VTI.backend.datalayer.Method_FresherCandidate;
import com.VTI.entity.FresherCandidate;
import com.VTI.ultis.ScannerUltis;
import com.VTI.ultis.jdbcUltis;

public class Fresher_Method_Funcition {
	private static jdbcUltis jdbc;
	public Fresher_Method_Funcition() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	public static void createFresherCandidate() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		boolean check;
		do {
			System.out.println("Tạo FresherCandidate mới");
			System.out.println("Mời bạn nhập vào FirstName");
			String firstname = ScannerUltis.inputString();
			System.out.println("Mời bạn nhập vào Lastname");
			String lastname = ScannerUltis.inputString();
			System.out.println("Mời bạn nhập vào Phone");
			String phone = ScannerUltis.inputPhonenumber();
			System.out.println("Mời bạn nhập vào Email");
			String email = ScannerUltis.inputEmail();
			System.out.println("Mời bạn nhập vào Password");
			String password = ScannerUltis.inputPassword();
			System.out.println("Mời bạn lựa chọn graduationRank: 1.Excellence, 2.Good, 3.Fair, 4.Poor");
			String choose = getgraduationRank();
			Method_FresherCandidate methodFresherCandidate = new Method_FresherCandidate();
			if (methodFresherCandidate.createFresherCandidate(firstname, lastname, phone, email, password, choose)) {
				System.out.println("Tạo mới thành công");
				break;
			}
			check = false;
		} while (check == false);
		
	}
	public static String getgraduationRank() {
		while (true) {
			switch (ScannerUltis.inputInt2()) {
			case 1:
				
				return "Excellence";
			case 2:
				
				return "Good";
			case 3:
				
				return "Fair";
			case 4:
				
				return "Poor";
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}		
	}
	public static void loginFresherCandidate() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đăng nhập tài khoản");
		System.out.println("Mời nhập vào email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào password");
		String password = ScannerUltis.inputPassword();
		Method_FresherCandidate methodFresherCandidate = new Method_FresherCandidate();
		if (methodFresherCandidate.loginFresherCandidate(email, password)) {
			System.out.println("Đăng nhập thành công");
		}else {
			System.out.println("Mời kiểm tra lại thông tin đăng nhập");
		}
	}
}
