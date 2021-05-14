package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.backend.Exercise1;
import com.VTI.backend.Exercise2;
import com.VTI.ultis.ScannerUltis;

public class DBconnectDep {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Exercise2 ex2 = new Exercise2();
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng test");
			System.out.println("=========================================================");
			System.out.println("================ Lựa Chọn Chức Năng =====================");
			System.out.println("       1: question1: read data – get list   			 ");
			System.out.println("       2: question2: read data – get department by id    ");
			System.out.println("       3: question3: read data – get department by id    ");
			System.out.println("       4: question4: check department name exists 		 ");
			System.out.println("       5: question5: create department    				 ");
			System.out.println("       6: question6: update department    				 ");
			System.out.println("       7: question7: delete department    				 ");
			System.out.println("       8: Thoát khỏi chương trình      				     ");
			System.out.println("=========================================================");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				ex2.question1();
				break;
			case 2:
				ex2.question2();
				break;
			case 3:
				ex2.question3();
				break;
			case 4:
				ex2.question4();
				break;
			case 5:
				ex2.question5();
				break;
			case 6:
				ex2.question6();
				break;
			case 7:
				ex2.question7();
				break;
			case 8:
				System.out.println("Chương trình kết thúc");
				return;
			default:

				break;
			}
		}
	}
}
