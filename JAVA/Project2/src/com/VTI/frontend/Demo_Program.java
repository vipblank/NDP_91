package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.ultis.ScannerUltis;

public class Demo_Program {
	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Đăng nhập quyền admin                   |");
			System.out.println("|              2: Đăng nhập quyền manager                 |");
			System.out.println("|              3: Đăng nhập quyền employee                |");
			System.out.println("|              3: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Method_Funcition.AdminLogin();
				AdminWorks();
				break;
			case 2:
				Method_Funcition.ManagerLogin();
				ManagerWorks();
				break;
			case 3:
				Method_Funcition.EmployeeLogin();
				EmployeeWorks();
				break;
			case 4:

				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	private static void ManagerWorks() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Create Project                          |");
			System.out.println("|              2: Get List Project                        |");
			System.out.println("|              3: Check ProjectTeam                       |");
			System.out.println("|              4: Check Manager at Project                |");
			System.out.println("|              5: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				
				break;
			case 2:
				Method_Funcition.GetListProject();
				break;
			case 3:
				Method_Funcition.ProjectTeamInfor();
				break;
			case 4:
				Method_Funcition.GetManagerAtProject();
				break;
			case 5:

				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	private static void EmployeeWorks()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Check ProjectTeam                       |");
			System.out.println("|              2: Get List Project                        |");
			System.out.println("|              2: Check Manager at Project                |");
			System.out.println("|              3: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Method_Funcition.ProjectTeamInfor();
				break;
			case 2:
				Method_Funcition.GetListProject();
				break;
			case 3:
				Method_Funcition.GetManagerAtProject();
				break;
			case 4:

				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	private static void AdminWorks() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: GetListEmployee                         |");
			System.out.println("|              2: GetListManager                          |");
			System.out.println("|              3: CreateEmployee                          |");
			System.out.println("|              4: CreateManager                           |");
			System.out.println("|              5: UpdateEmployee                          |");
			System.out.println("|              6: UpdateManager                           |");
			System.out.println("|              7: DeleteEmployee                          |");
			System.out.println("|              8: DeleteManager                           |");
			System.out.println("|              9: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Method_Funcition.GetListEmployee();
				break;
			case 2:
				Method_Funcition.GetListManager();
				break;
			case 3:

				break;
			case 4:

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
}
