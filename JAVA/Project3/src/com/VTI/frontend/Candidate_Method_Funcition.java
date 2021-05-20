package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.VTI.backend.datalayer.Method_Candidate;
import com.VTI.backend.presentationlayer.Candidate_Method_ConTroller;
import com.VTI.ultis.ScannerUltis;

public class Candidate_Method_Funcition {

	public static void createFresherCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo FresherCandidate mới");
		System.out.println("Mời bạn nhập vào FirstName");
		String firstname = ScannerUltis.inputFullname();
		System.out.println("Mời bạn nhập vào Lastname");
		String lastname = ScannerUltis.inputFullname();
		System.out.println("Mời bạn nhập vào Phone");
		String phone = ScannerUltis.inputPhonenumber();
		System.out.println("Mời bạn nhập vào Email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào Password");
		String password = ScannerUltis.inputPassword();
		System.out.println("Xác nhận bạn là FresherCandidate: bấm 1");
		String choose3 = getCategory1();
		System.out.println("Mời bạn lựa chọn graduationRank: 1.Excellence, 2.Good, 3.Fair, 4.Poor, 5.không có rank");
		String choose = getgraduationRank();
		Candidate_Method_ConTroller controller = new Candidate_Method_ConTroller();
		if (controller.createFresherCandidate(firstname, lastname, phone, email, password, choose, choose3)) {
			System.out.println("Tạo mới thành công");
		}

	}

	public static void createExperienceCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo ExperienceCandidate mới");
		System.out.println("Mời bạn nhập vào FirstName");
		String firstname = ScannerUltis.inputFullname();
		System.out.println("Mời bạn nhập vào Lastname");
		String lastname = ScannerUltis.inputFullname();
		System.out.println("Mời bạn nhập vào Phone");
		String phone = ScannerUltis.inputPhonenumber();
		System.out.println("Mời bạn nhập vào Email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào Password");
		String password = ScannerUltis.inputPassword();
		System.out.println("Xác nhận bạn là ExperienceCandidate: bấm 1");
		String choose3 = getCategory2();
		System.out.println("Mời bạn chọn Proskill: 1.Dev, 2.Test, 3.Scrum Master, 4.SQL.");
		String choose1 = getProskill();
		System.out.println("Mời bạn nhập ExplnYear ");
		int choose2 = ScannerUltis.inputFunction(0, 10, "Chỉ nhập từ 0-10");
		Candidate_Method_ConTroller controller = new Candidate_Method_ConTroller();
		if (controller.createExperienceCandidate(firstname, lastname, phone, email, password, choose2, choose1,
				choose3)) {
			System.out.println("Tạo mới thành công");
		}
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

	public static String getProskill() {
		while (true) {
			switch (ScannerUltis.inputInt2()) {
			case 1:

				return "Dev";
			case 2:

				return "Test";
			case 3:

				return "Scrum Master";
			case 4:

				return "SQl";
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	public static String getCategory1() {
		while (true) {
			switch (ScannerUltis.inputInt2()) {
			case 1:

				return "Fresher";
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	public static String getCategory2() {
		while (true) {
			switch (ScannerUltis.inputInt2()) {
			case 1:

				return "Experience";
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	public static void loginCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đăng nhập tài khoản");
		System.out.println("Mời nhập vào email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào password");
		String password = ScannerUltis.inputPassword();
		Candidate_Method_ConTroller controller = new Candidate_Method_ConTroller();
		if (controller.loginCandidate(email, password)) {
			System.out.println("Đăng nhập thành công");
		} else {
			System.err.println("Mời kiểm tra lại thông tin đăng nhập");
		}
	}
}
