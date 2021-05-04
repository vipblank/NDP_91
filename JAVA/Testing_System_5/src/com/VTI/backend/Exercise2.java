package com.VTI.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.VTI.entity.Student;

public class Exercise2 {
	private Scanner sc;
	private ArrayList<Student> listStudent;
	private Random random;
	public void question1() {
		sc = new Scanner(System.in);
		listStudent = new ArrayList<Student>();
		random = new Random();
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("      	      1: Tạo 10 học sinh, chia thành 3 nhóm     ");
			System.out.println("      	      2: Kêu gọi cả lớp điểm danh		        ");
			System.out.println("      	      3: Gọi nhóm 1 đi học bài 		            ");
			System.out.println("      	      4: Gọi nhóm 2 đi dọn vệ sinh 		        ");
			System.out.println("     	      5: Thoát khỏi chương trình.			    ");
			System.out.println("========================================================");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				TaoHS();
				break;
			case 2:
				DDanh();
				break;
			case 3:
				HocBai();
				break;
			case 4:
				DonVS();
				break;
			case 5:
				
				return;
			default:
				
				break;
			}
		}
	}
	public void TaoHS() {
		for (int i = 0; i < 10; i++) {
			Student student = new Student( " Student " + ( i + 1 ) , random.nextInt(3)+1);
			listStudent.add(student);
		}
	}
	public void DDanh() {
		for (Student student : listStudent) {
			student.DiemDanh();
		}
	}
	public void HocBai() {
		for (Student student : listStudent) {
			if (student.getGroup() == 1) {
				student.HocBai();
			}
		}
	}
	public void DonVS() {
		for (Student student : listStudent) {
			if (student.getGroup() == 2) {
				student.DonVeSinh();
			}
		}
	}
	
}
