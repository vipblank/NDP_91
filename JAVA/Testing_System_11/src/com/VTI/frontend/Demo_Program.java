package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.VTI.ultis.ScannerUltis;

public class Demo_Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			System.out.println("+================ Lựa Chọn Chức Năng ===============+");
			System.out.println("|               1: Quản lý nhân viên                |");
			System.out.println("|               2: Quản lý phòng ban                |");
			System.out.println("|               3: Quản lý chức vụ                  |");
			System.out.println("|               4: Thoát chương trình               |");
			System.out.println("+===================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				getMenuAccount();
				break;
			case 2:
				getMenuDepartment();
				break;
			case 3:
				getMenuPossition();
				break;
			case 4:
				System.out.println("Chương trình kết thúc");
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	private static void getMenuPossition() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			while (true) {
				System.out.println("Mời bạn lựa chọn chức năng %n");
				System.out.println("+================ Lựa Chọn Chức Năng =====================+");
				System.out.println("|              1: read data – get list                    |");
				System.out.println("|              2: read data – get position by id          |");
				System.out.println("|              3: check position name exists              |");
				System.out.println("|              4: create position                         |");
				System.out.println("|              5: update position                         |");
				System.out.println("|              6: delete position                         |");
				System.out.println("|              7: Thoát khỏi chương trình                 |");
				System.out.println("+=========================================================+");
				int menu = ScannerUltis.inputInt2();
				switch (menu) {
				case 1:
					Position_Funcition.getlistPositions();
					break;
				case 2:
					Position_Funcition.getPosByID();
					break;
				case 3:
					Position_Funcition.isPositionNameExists();
					break;
				case 4:
					Position_Funcition.createPosition();
					break;
				case 5:
					Position_Funcition.updatePosition();
					break;
				case 6:
					Position_Funcition.deletePosition();
					break;
				case 7:
					
					return;
				default:
					System.err.println("Mời chọn lại");
					break;
				}
			}
		}	
	}

	private static void getMenuDepartment() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng %n");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: read data – get list                    |");
			System.out.println("|              2: read data – get department by id        |");
			System.out.println("|              3: check department name exists            |");
			System.out.println("|              4: create department                       |");
			System.out.println("|              5: update department                       |");
			System.out.println("|              6: delete department                       |");
			System.out.println("|              7: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Department_Funciton.getlistDepartments();
				break;
			case 2:
				Department_Funciton.getDepByID();
				break;
			case 3:
				Department_Funciton.isDepartmentNameExists();
				break;
			case 4:
				Department_Funciton.createDepartment();
				break;
			case 5:
				Department_Funciton.updateDepartmentName();
				break;
			case 6:
				Department_Funciton.deleteDepartment();
				break;
			case 7:
				
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	private static void getMenuAccount() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng %n");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: read data – get list account            |");
			System.out.println("|              2: read data – get account by id           |");
			System.out.println("|              3: check account name exists               |");
			System.out.println("|              4: create account                          |");
			System.out.println("|              5: update account                          |");
			System.out.println("|              6: delete account                          |");
			System.out.println("|              7: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Account_Funcition.getListAccount();
				break;
			case 2:
				Account_Funcition.getAccByID();
				break;
			case 3:
				Account_Funcition.isAccountNameExists();
				break;
			case 4:
				Account_Funcition.createAccount();
				break;
			case 5:
				Account_Funcition.updateAccount();
				break;
			case 6:
				Account_Funcition.deleteAccount();
				break;
			case 7:
				
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}		
	}
}
