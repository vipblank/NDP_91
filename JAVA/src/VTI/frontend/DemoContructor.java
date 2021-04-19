package com.VTI.frontend;

import java.util.Scanner;

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
					System.out.println("Menu1");
					break;
				case 2:
					System.out.println("Menu2");
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
