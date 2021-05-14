package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.VTI.backend.Exercise2_1;
import com.VTI.ultis.ScannerUltis;

public class DBconnectAcc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Exercise2_1 ex2 = new Exercise2_1();
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng test \n");			
			System.out.println("+================ Lựa Chọn Chức Năng ====================+");
			System.out.println("|       1: question 1: read data – get list              |");
			System.out.println("|       2: question 2: read data – get account by id     |");
			System.out.println("|       3: question 3: check account name exists         |");
			System.out.println("|       4: question 4: create account                    |");
			System.out.println("|       5: question 5: update account                    |");
			System.out.println("|       6: question 6: delete account                    |");
			System.out.println("|       7: Thoát khỏi chương trình                       |");
			System.out.println("+========================================================+");
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
				System.out.println("Chương trình kết thúc");
				return;
			default:

				break;
			}
		}
	}
}
