package com.VTI.frontend;

import java.util.Scanner;

import com.VTI.entity.Account;
import com.VTI.entity.Department;
import com.VTI.entity.Position;
import com.VTI.entity.Position.PositionName;

public class DemoContructor {
	public static void main(String[] args) {
		System.out.println("Demo Menu");
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng : 1. Tạo account, 2. Tạo Department");
			choose = sc.nextInt();
			if (choose == 1|| choose == 2) {
				switch (choose) {
				case 1:
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Mời bạn nhập vào thông tin account");
					Account acc = new Account();
					System.out.println("Mời bạn nhập vào ID ");
					acc.id = sc1.nextInt();
					System.out.println("Mời bạn nhập vào userName");
					acc.userName = sc1.next();
					System.out.println("Mời bạn nhập vào fullName");
					acc.fullName = sc1.next();
					System.out.println("Mời bạn nhập vào Email");
					acc.email = sc1.next();
					System.out.println("Mời bạn nhập vào mã chức vụ :  1.DEV,  2.TEST, 3.SCRUM_MASTER, 4.PM ");
					int posNum = sc1.nextInt();
					switch (posNum) {
					case 1:
						Position ps1 = new Position();
						ps1.name = PositionName.DEV;
						acc.pos = ps1;
						break;
					case 2:
						Position ps2 = new Position();
						ps2.name = PositionName.TEST;
						acc.pos = ps2;
						break;
					case 3:
						Position ps3 = new Position();
						ps3.name = PositionName.SCRUM_MASTER;
						acc.pos = ps3;
						break;
					case 4:
						Position ps4 = new Position();
						ps4.name = PositionName.PM;
						acc.pos = ps4;
						break;
					default:
						break;
					}
					System.out.println("Thông tin account mới nhập");
					System.out.println("ID: " + acc.id);
					System.out.println("userName: " + acc.userName);
					System.out.println("FullName: " + acc.fullName);
					System.out.println("Email: " + acc.email);
					System.out.println("Chức Vụ: " + acc.pos.name);
					break;
				case 2:
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Mời bạn nhập vào thông tin phòng ban");
					Department dep = new Department();
					System.out.println("Mời bạn nhập vào ID phòng ban");
					dep.id = sc3.nextInt();
					System.out.println("Mời bạn nhập tên phòng ban");
					dep.name = sc3.next();
					System.out.println("Thông tin phòng ban bạn vừa tạo : " + dep.id + "" + dep.name);
				default:
					break;
				}
				return;
			}else {
				System.out.println("Mời Nhập Lại");
			}
		}
	}
}
