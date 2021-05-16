package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.VTI.ultis.ScannerUltis;

public class Demo_Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			System.out.println("+================ Lựa Chọn Chức Năng ===============+");
			System.out.println("|                     1: Register                   |");
			System.out.println("|                     2: Login                      |");
			System.out.println("|                     3: Thoát                      |");
			System.out.println("+===================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Register();
				break;
			case 2:
				Login();
				break;
			case 3:
				
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	private static void Login() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Fresher Login                           |");
			System.out.println("|              2: Experience Login                        |");
			System.out.println("|              3: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Fresher_Method_Funcition.loginFresherCandidate();
				break;
			case 2:
				Experience_Method_Funcition.loginExperienceCandidate();
				break;
			case 3:
				
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}	
	}

	private static void Register() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
			while (true) {
				System.out.println("Mời bạn lựa chọn chức năng");
				System.out.println("+================ Lựa Chọn Chức Năng =====================+");
				System.out.println("|              1: Fresher Register                        |");
				System.out.println("|              2: Experience Register                     |");
				System.out.println("|              3: Thoát khỏi chương trình                 |");
				System.out.println("+=========================================================+");
				int menu = ScannerUltis.inputInt2();
				switch (menu) {
				case 1:
					Fresher_Method_Funcition.createFresherCandidate();
					break;
				case 2:
					Experience_Method_Funcition.createExperienceCandidate();
					break;
				case 3:
					
					return;
				default:
					System.err.println("Mời chọn lại");
					break;
			}
		}	
	}	
}
