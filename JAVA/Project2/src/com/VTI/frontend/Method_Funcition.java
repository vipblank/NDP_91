package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.datalayer.Method_Repository;
import com.VTI.entity.Employee;
import com.VTI.entity.Manager;
import com.VTI.entity.Project;
import com.VTI.entity.ProjectTeam;
import com.VTI.ultis.ScannerUltis;

public class Method_Funcition {
	public static void EmployeeLogin() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đăng nhập tài khoản");
		System.out.println("Mời nhập vào email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào password");
		String password = ScannerUltis.inputPassword();
		Method_Repository methodRepository = new Method_Repository();
		if (methodRepository.EmployeeLogin(email, password)) {
			System.out.println("Đăng nhập thành công");
		} else {
			System.err.println("Mời kiểm tra lại thông tin đăng nhập");
		}
	}

	public static void ManagerLogin() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đăng nhập tài khoản");
		System.out.println("Mời nhập vào email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào password");
		String password = ScannerUltis.inputPassword();
		Method_Repository methodRepository = new Method_Repository();
		if (methodRepository.ManagerLogin(email, password)) {
			System.out.println("Đăng nhập thành công");
		} else {
			System.err.println("Mời kiểm tra lại thông tin đăng nhập");
		}
	}

	public static void AdminLogin() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đăng nhập tài khoản");
		System.out.println("Mời nhập vào email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào password");
		String password = ScannerUltis.inputPassword();
		Method_Repository methodRepository = new Method_Repository();
		if (methodRepository.AdminLogin(email, password)) {
			System.out.println("Đăng nhập thành công");
		} else {
			System.err.println("Mời kiểm tra lại thông tin đăng nhập");
		}
	}

	public static void ProjectTeamInfor()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Mời nhập vào pjID");
		int PJid = ScannerUltis.inputInt2();
		Method_Repository methodRepository = new Method_Repository();
		List<ProjectTeam> listPjTeam = methodRepository.ProjectTeamInfor(PJid);
		if (listPjTeam != null) {
			System.out.println("Thông tin ProjectTeam trên hệ thống");
			String format1 = "| %-12d | %-12d | %-12d |%n";
			System.out.format("+--------------+--------------+--------------+%n");
			System.out.format("| ProjectID    | ManagerID    | EmployeeID   |%n");
			System.out.format("+--------------+--------------+--------------+%n");
			for (ProjectTeam projectTeam2 : listPjTeam) {
				System.out.format(format1, projectTeam2.getProject(), projectTeam2.getManager(),
						projectTeam2.getEmployee());
			}
			System.out.format("+--------------+--------------+--------------+%n");
		} else {
			System.err.println("Project chưa được khởi tạo.");
		}
	}

	public static void GetManagerAtProject()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Method_Repository methodRepository = new Method_Repository();
		List<Project> listPj = methodRepository.GetManagerAtProject();
		if (listPj != null) {
			System.out.println("Thông tin Manager của Project");
			String format1 = "| %-12d | %-12d |%n";
			System.out.format("+--------------+--------------+%n");
			System.out.format("| ProjectID    | ManagerID    |%n");
			System.out.format("+--------------+--------------+%n");
			for (Project project2 : listPj) {
				System.out.format(format1, project2.getProjectID(), project2.getManager());
			}
			System.out.format("+--------------+--------------++%n");
		} else {
			System.err.println("Project chưa được khởi tạo.");
		}
	}

	public static void GetListEmployee()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Method_Repository methodRepository = new Method_Repository();
		List<Employee> listEp = methodRepository.GetListEmployee();
		if (listEp != null) {
			System.out.println("Thông tin Employee của Project");
			String format1 = "| %-10d | %-12s | %-16s | %-12s | %-10s |%n";
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
			System.out.format("| EmployeeID | Fullname     | Email            | Password     | ProSkill   |%n");
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
			for (Employee employee : listEp) {
				System.out.format(format1, employee.getId(), employee.getFullname(), 
						employee.getEmail(), employee.getPassword(), employee.getProskill());			
			}	
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
		} else {
			System.err.println("Employee chưa có thông tin trên hệ thống");
		}
	}

	public static void GetListManager()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Method_Repository methodRepository = new Method_Repository();
		List<Manager> listMg = methodRepository.GetListManager();
		if (listMg != null) {
			System.out.println("Thông tin Manager trên hệ thống");
			String format1 = "| %-10d | %-12s | %-16s | %-12s | %-10d |%n";
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
			System.out.format("| ManagerID  | Fullname     | Email            | Password     | ExplnYear  |%n");
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
			for (Manager manager : listMg) {
				System.out.format(format1, manager.getId(), manager.getFullname(), manager.getEmail(),
						manager.getPassword(), manager.getExplnYear());
			}
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
		} else {
			System.err.println("Manager chưa có thông tin trên hệ thống.");
		}
	}
	public static void GetListProject() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Method_Repository methodRepository = new Method_Repository();
		List<Project> listPj = methodRepository.GetListProject();
		if (listPj != null) {
			System.out.println("Thông tin Project trên hệ thống");
			String format1 = "| %-10d | %-12s | %-16s | %-10d |%n";
			System.out.format("+------------+--------------+------------------+------------+%n");
			System.out.format("| ProjectID  | ProjectName  | ProjectManagerID | TeamSize   |%n");
			System.out.format("+------------+--------------+------------------+------------+%n");
			for (Project project : listPj) {
				System.out.format(format1, project.getProjectID(), project.getProjectName(), project.getManager(),project.getTeamSize());
			}
			System.out.format("+------------+--------------+------------------+------------+%n");
		}else {
			System.err.println("Project chưa có thông tin trên hệ thống.");
		}
	}
}
