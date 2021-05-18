package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.VTI.ultis.ScannerUltis;

public class Demo_Program {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			System.out.println("+================ Lựa Chọn Chức Năng ===============+");
			System.out.println("|                 1: Login                          |");
			System.out.println("|                 2: Thoát                          |");
			System.out.println("+===================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Method_Funcition.Login();
				break;
			case 2:
				System.out.println("Chương Trình Kết Thúc");
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}
}