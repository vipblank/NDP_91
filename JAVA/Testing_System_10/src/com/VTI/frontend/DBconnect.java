package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.backend.Exercise1;
import com.VTI.ultis.ScannerUltis;

public class DBconnect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Exercise1 ex1 = new Exercise1();
		while (true) {
			System.out.println("========================================================");
			System.out.println("=====            Lựa Chọn Chức Năng                =====");
			System.out.println("=====        1: Question1: Test kết nối            =====");
			System.out.println("=====        2: Question2: In thông tin account    =====");
			System.out.println("=====        3: Question3: Tạo position            =====");
			System.out.println("=====        4: Question4: Update position         =====");
			System.out.println("=====        5: Question5: Delete position         =====");
			System.out.println("=====                  6: Exit                     =====");
			System.out.println("========================================================");
			System.out.println("Mời lựa chọn chức năng");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				ex1.question1();
				break;
			case 2:
				ex1.quesiton2();
				break;
			case 3:
				ex1.quesiton3();
				break;
			case 4:
				ex1.question4();
				break;
			case 5:
				ex1.question5();
				break;
			case 6:
				System.out.println("Kết thúc chương trình");
				return;
			default:
				
				break;
			}
		}
	}
}
