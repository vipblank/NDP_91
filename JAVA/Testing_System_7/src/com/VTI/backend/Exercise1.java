package com.VTI.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.VTI.entity.PrimaryStudent;
import com.VTI.entity.SecondaryStudent;
import com.VTI.entity.Student;
import com.VTI.ultis.ScannerUltis;

public class Exercise1 {
	public static int count = 0;
	public int count1 = 0;
	public int count2 = 0;
	private static ArrayList<Student> listStudent;
	private static ArrayList<PrimaryStudent> listPri;
	private static ArrayList<SecondaryStudent> listSec;
	private static Scanner sc;
	public void question1_2_4() {
		Student[] Arrstudent = new Student[3];
		System.out.println("Khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên" + (i + 1 + " : "));
			Student student = new Student();
			Arrstudent[i] = student;				
		}
		Student.setCollege("Đại Học Công Nghệ") ;
		System.out.println("Thông tin sinh viên vừa nhập");
		for (int i = 0; i < Arrstudent.length; i++) {
			System.out.println(Arrstudent[i]);
		}
		System.out.println("Sinh viên nộp quỹ 100k");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup  += 300));
		System.out.println("Sinh viên 1 lấy 50k mua bimbim về liên hoan");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup  -= 50));
		System.out.println("Sinh viên 2 lấy 20k mua bánh mỳ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup  -= 20));
		System.out.println("Sinh viên 3 lấy 150k mua đồ dùng học tập");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup  -= 150));
		System.out.println("Sinh viên nộp quỹ 50k");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup  += 150));
	}
	public void question5() {
		sc = new Scanner(System.in);
		listStudent = new ArrayList<Student>();
		while (true) {
			System.out.println("Bạn có muốn khởi tạo sinh viên: 1.Có, 2.Không");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Mời nhập vào tên sinh viên");
				String name = ScannerUltis.inputString();
				Student student = new Student(count, name);
				listStudent.add(student);		
				count++;
				break;
			case 2:
				System.out.println("Số sinh viên được tạo ra là: " + Student.count);
				System.out.println("chương trình kết thúc");
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}						
		}
	}
	public void question6() {
		sc = new Scanner(System.in);
		listPri = new ArrayList<PrimaryStudent>();
		listSec = new ArrayList<SecondaryStudent>();
		while (true) {
			System.out.println("Bạn có muốn khởi tạo sinh viên: 1.Có, 2.Không");
			int choose = ScannerUltis.inputInt();
			switch (choose) {
			case 1:
				System.out.println("Mời nhập vào tên sinh viên");
				String name = ScannerUltis.inputString();
					System.out.println("Bạn muốn khởi tạo PrimaryStudent hay SecondaryStudent: 1.PrimaryStudent, 2.SecondaryStudent");
					int choose1 = ScannerUltis.inputInt2();
					switch (choose1) {
					case 1:		
						if (count1 >= 2) {
							System.out.println("Vượt quá số lượng học sinh được tạo. Mời chọn khối học sinh khác");
							continue;
						}else {
							PrimaryStudent primaryStudent = new PrimaryStudent(count1, name);
							listPri.add((PrimaryStudent) primaryStudent);
							count1++;
							continue;
						}						
					case 2:
						if (count2 >= 2) {
							System.out.println("Vượt quá số lượng học sinh được tạo. Mời chọn khối học sinh khác");
							continue;
						}else {
							SecondaryStudent secondaryStudent = new SecondaryStudent(count2, name);
							listSec.add(secondaryStudent);
							count2++;
							continue;
						}					
					default:
						System.out.println("Mời chọn lại");
						continue;
					}										
			case 2:
				System.out.println("Số PrimaryStudent được tạo ra là: " + PrimaryStudent.countPri + " Số SecondaryStudent được tạo ra là: " + SecondaryStudent.countSec);
				System.out.println("Thông tin PrimaryStudent đã khởi tạo: " + listPri.toString() + "\nThông tin SecondaryStudent đã khởi tạo: " + listSec.toString());
				System.out.println("chương trình kết thúc");
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}						
		}
	}
	public void question8() {
		
	}
}
