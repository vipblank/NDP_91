package com.VTI.frontend;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.VTI.backend.datalayer.Method_ExperienceCandidate;
import com.VTI.ultis.ScannerUltis;

public class Experience_Method_Funcition {
	
	public static void loginExperienceCandidate() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đăng nhập tài khoản");
		System.out.println("Mời nhập vào email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào password");
		String password = ScannerUltis.inputPassword();
		Method_ExperienceCandidate method_ExperienceCandidate = new Method_ExperienceCandidate();
		if (method_ExperienceCandidate.loginExperienceCandidate(email, password)) {
			System.out.println("Đăng nhập thành công");
		}else {
			System.out.println("Mời kiểm tra lại thông tin đăng nhập");
		}
	}
	public static void createExperienceCandidate() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo ExperienceCandidate mới");
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
		System.out.println("Mời bạn nhập vào ExplnYear");
		int explnYear = ScannerUltis.inputInt2();
		System.out.println("Mời bạn nhập vào ProSkill");
		String proskill = ScannerUltis.inputString();
		Method_ExperienceCandidate reCandidate = new Method_ExperienceCandidate();
		if (reCandidate.createExperienceCandidate(firstname, lastname, phone, email, password, explnYear, proskill)) {
			System.out.println("Tạo mới thành công");
		}
	}
}
