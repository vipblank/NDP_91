package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.VTI.backend.presentationlayer.Employee_ConTroller;
import com.VTI.backend.presentationlayer.Manager_ConTroller;
import com.VTI.entity.Employee;
import com.VTI.entity.Manager;
import com.VTI.ultis.ScannerUltis;

public class Admin_Funcition {

	public static void AdminWorks() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Getlist Manager                         |");
			System.out.println("|              2: Getlist Employee                        |");
			System.out.println("|              3: Create Manager                          |");
			System.out.println("|              4: Create Employee                         |");
			System.out.println("|              5: Update Manager                          |");
			System.out.println("|              6: Update Employee                         |");
			System.out.println("|              7: Detele Manager                          |");
			System.out.println("|              8: Delete Employee                         |");
			System.out.println("|              9: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				GetListManager();
				break;
			case 2:
				GetListEmployee();
				break;
			case 3:
				CreateManager();
				break;
			case 4:
				CreateEmployee();
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}
	
	public static void GetListEmployee()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Employee_ConTroller employeeC = new Employee_ConTroller();
		List<Employee> listEp = employeeC.GetListEmployee();
		if (listEp != null) {
			System.out.println("Thông tin Employee của Project");
			String format1 = "| %-10d | %-20s | %-25s | %-12s | %-10s |%n";
			System.out.format("+------------+----------------------+---------------------------+--------------+------------+%n");
			System.out.format("| EmployeeID | Fullname             | Email                     | Password     | ProSkill   |%n");
			System.out.format("+------------+----------------------+---------------------------+--------------+------------+%n");
			for (Employee employee : listEp) {
				System.out.format(format1, employee.getId(), employee.getFullname(), employee.getEmail(),
						employee.getPassword(), employee.getProskill());
			}
			System.out.format("+------------+----------------------+---------------------------+--------------+------------+%n");
		} 
	}

	public static void GetListManager()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Manager_ConTroller managerC = new Manager_ConTroller();
		List<Manager> listMg = managerC.GetListManager();
		if (listMg != null) {
			System.out.println("Thông tin Manager trên hệ thống");
			String format1 = "| %-10d | %-20s | %-25s | %-12s | %-10d |%n";
			System.out.format("+------------+----------------------+---------------------------+--------------+------------+%n");
			System.out.format("| ManagerID  | Fullname             | Email                     | Password     | ExplnYear  |%n");
			System.out.format("+------------+----------------------+---------------------------+--------------+------------+%n");
			for (Manager manager : listMg) {
				System.out.format(format1, manager.getId(), manager.getFullname(), manager.getEmail(),
						manager.getPassword(), manager.getExplnYear());
			}
			System.out.format("+------------+----------------------+---------------------------+--------------+------------+%n");
		}
	}

	public static void CreateManager() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo Manager mới");
		System.out.println("Mời bạn nhập vào fullname");
		String fullname = ScannerUltis.inputFullname();
		System.out.println("Mời bạn nhập vào Email theo định dạng: ...@vti.com.vn");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào password");
		String password = ScannerUltis.inputPassword();
		System.out.println("Mời bạn nhập vào ExplnYear");
		int explnYear = ScannerUltis.inputFunction(0, 10, "Mời nhập vào số");
		Manager_ConTroller managerC = new Manager_ConTroller();
		if (managerC.CreateManager(fullname, email, password, explnYear)) {
			System.out.println("Tạo mới thành công");
		}
	}

	public static void CreateEmployee()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo Employee mới");
		System.out.println("Mời bạn nhập vào fullname");
		String fullname = ScannerUltis.inputFullname();
		System.out.println("Mời bạn nhập vào Email theo định dạng: ...@vti.com.vn");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào password");
		String password = ScannerUltis.inputPassword();
		System.out.println("Mời bạn nhập chọn Proskill: 1.Dev, 2.Test, 3.Scrum Master, 4.SQL");
		String proskill = getProskill();
		Employee_ConTroller employeeC = new Employee_ConTroller();
		if (employeeC.CreateEmployee(fullname, email, password, proskill)) {
			System.out.println("Tạo mới thành công");
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
				return "SQL";
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}
}