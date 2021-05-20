package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.backend.datalayer.Admin_Repository;
import com.VTI.backend.presentationlayer.Employee_ConTroller;
import com.VTI.backend.presentationlayer.Manager_ConTroller;
import com.VTI.ultis.ScannerUltis;

public class Login_Funcition {
	
	public static void Login() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đăng nhập tài khoản");
		System.out.println("Mời nhập vào email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào password");
		String password = ScannerUltis.inputPassword();
		Admin_Repository methodRepository = new Admin_Repository();
		Manager_ConTroller managerC = new Manager_ConTroller();
		Employee_ConTroller employeeC = new Employee_ConTroller();
		if (methodRepository.AdminLogin(email, password)) {
			System.out.println("Đăng nhập thành công");
			Admin_Funcition.AdminWorks();
		} else if (employeeC.EmployeeLogin(email, password)) {
			System.out.println("Đăng nhập thành công");
			Employee_Funcition.EmployeeWorks();
		} else if (managerC.ManagerLogin(email, password)) {
			System.out.println("Đăng nhập thành công");
			Manager_Funcition.ManagerWorks();
		}else {
			System.err.println("Email - mật khẩu không đúng. Xin thử lại");
		}
	}	
}
