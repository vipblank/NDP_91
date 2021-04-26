package com.VTI.backend;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

import com.VTI.entity.Student;

public class Exercise_4 {
	private Scanner sc ;
	public static int count = 0;
	private ArrayList<Student> listStudent;
	public void question1() {
		sc = new Scanner(System.in);
		listStudent = new ArrayList<Student>();
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("================ 1: Thêm mới học sinh ==================");
			System.out.println("================ 2: Thông tin học sinh =================");
			System.out.println("================ 3: Nhập điểm số =======================");
			System.out.println("================ 4: Thoát khỏi chương trình ============");
			System.out.println("========================================================");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Nhập vào tên học sinh");
				String name = sc.next();
				System.out.println("Nhập vào địa chỉ học sinh");
				String diachi = sc.next();
				Student student = new Student(name, diachi);
				listStudent.add(student);
				count++;
				student.setId(count);
				break;
			case 2:
				showStudent();
				break;
			case 3:
				System.out.println("Nhập vào tên của học sinh");
				String name1 = sc.next();
				for (Student student2 : listStudent) {
					if (student2.getName().equals(name1)) {
						System.out.println("Nhập vào điểm của học sinh");
						Float addScore = sc.nextFloat();
						student2.setScore(addScore);
						System.out.println("Điểm số đã nhập vào: " + addScore);
					}
				}
				break;
			case 4:			
				return;
			default:
				System.out.println("Mời chọn chức năng");
				break;
			}
		}
	}
	public void showStudent() {	
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("============ 1: Thông tin toàn bộ học sinh =============");
			System.out.println("============== 2: Thông tin học sinh yếu ===============");
			System.out.println("=========== 3: Thông tin học sinh trung bình ===========");
			System.out.println("================ 4: Thông tin học sinh khá =============");
			System.out.println("=========== 5: Thông tin học sinh giỏi =================");
			System.out.println("================ 6: Thoát khỏi chương trình ============");
			System.out.println("========================================================");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				for (Student student : listStudent) {
					System.out.println(student);
				}
				break;
			case 2:
				for (Student student : listStudent) {
					if (student.getScore() < 4.0) {
						System.out.println("danh sách học sinh yếu: " + student);
					}
				}
				break;
			case 3:
				for (Student student : listStudent) {			
					if (student.getScore() > 4.0 && student.getScore() < 6.0) {
						System.out.println("danh sách học sinh trung bình: " + student);
					}
				}
				break;
			case 4:
				for (Student student : listStudent) {
					if (student.getScore() > 6.0 && student.getScore() < 8.0) {
						System.out.println("danh sách học sinh khá: " + student);
					}
				}
				break;
			case 5:
				for (Student student : listStudent) {
					if (student.getScore() > 8.0) {
						System.out.println("danh sách học sinh giỏi: " + student);
					}
				}
				break;
			case 6:				
				return;
			default:
				System.out.println("Mời chọn chức năng");
				break;
			}				
		}
	}
}

