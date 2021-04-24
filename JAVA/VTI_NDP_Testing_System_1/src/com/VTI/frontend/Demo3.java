package com.VTI.frontend;

import java.util.Scanner;

import com.VTI.entity.Account;
import com.VTI.entity.Position;
import com.VTI.entity.Position.PositionName;

public class Demo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("chương trình tính tổng. Mời bạn nhập số thứ 1");
		int num1 = sc.nextInt();
		System.out.println("chương trình tính tổng. Mời bạn nhập số thứ 2");
		int num2 = sc.nextInt();
		System.out.println("Tổng 2 số là : " + tinhtong(num1, num2));
			}
							
	private static int tinhtong(int a, int b) {	
		int sum = a + b;
		return sum;
	}

}
