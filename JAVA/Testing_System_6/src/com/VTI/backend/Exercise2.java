package com.VTI.backend;

import java.util.Scanner;

import com.VTI.entity.Department;
import com.VTI.entity.Group;
import com.VTI.entity.Position;
import com.VTI.ultis.ScannerUltis;

public class Exercise2 {

	private static Scanner sc;

	public void question1_2() {
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (ArithmeticException errorMatch) {
			System.err.println("Không thể thực hiện phép chia với 0 ");
		} finally {
			System.err.println("divide kết thúc ");
		}
	}
	private float divide(int i, int j) {
		return i / j;
	}

	public void question3() {
		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);
		} catch (Exception e) {
			System.err.println("Vượt quá số phần tử của mảng");
		} finally {
			System.err.println("Kết thúc chương trình");
		}
	}

	public void getIndex() {
		try {
			String[] department = { "dep1", "dep2", "dep3" };
			sc = new Scanner(System.in);
			System.out.println("mời nhập vào số phần tử mảng muốn lấy ra");
			int index1 = sc.nextInt();
			System.out.println(department[index1]);
		} catch (Exception e) {
			System.err.println("Cannot find department");
		}
	}

	public static void inputAge() {
		System.out.println("Mời bạn nhập vào số tuổi");
		int addage = ScannerUltis.inputInt2();
		System.out.println("Tuôi bạn nhập vào là: " + addage);
	}
	public static void question9() throws Exception {
		System.out.println("tạo department");
		Department department = new Department();
		System.out.println("thông tin Department vừa nhập: ");
		System.out.println(department);

	}
	public static void question9_2() throws Exception {
		System.out.println("tạo position");
		Position position = new Position();
		System.out.println("thông tin position vừa nhập: ");
		System.out.println(position);
	}
	
}
