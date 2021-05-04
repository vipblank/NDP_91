package com.VTI.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Student1 extends Person{
	public Scanner sc;
	private int maSV;
	private Float diemTB;
	private String email;

	
	public Student1(String hoten, LocalDate ngaysinh, String diachi, Gioitinh gioitinh, int maSV, Float diemTB,
			String email) {
		super(hoten, ngaysinh, diachi, gioitinh);
		this.maSV = maSV;
		this.diemTB = diemTB;
		this.email = email;
	}

	public void question2b() {
		sc = new Scanner(System.in);
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("      	      1: InputInfo    							");
			System.out.println("      	      2: ShowInfo		        				");
			System.out.println("     	      3: Thoát khỏi chương trình.			    ");
			System.out.println("========================================================");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				inputInfo();
				break;
			case 2:
				showInfo();
				break;
			case 3:
				
				return;
			default:
				System.out.println("Mời chọn chức năng");
				break;
			}
		}
	}
	
	@Override
	public void inputInfo() {
		sc = new Scanner(System.in);
		super.inputInfo();
		System.out.println("Mời bạn nhập vào maSV");
		this.maSV = sc.nextInt();
		System.out.println("Mời bạn nhập vào điểm TB");
		this.diemTB = sc.nextFloat();
		System.out.println("Mời bạn nhập vào email");
		this.email = sc.next();	
	}
@Override
	public String showInfo() {
	
	return super.showInfo() + "Student1 [maSV=" + maSV + ", diemTB=" + diemTB + ", email=" + email + "]";
	}
	public void checkdiemTB() {
		if (this.diemTB > 7.0) {
			System.out.println("Học sinh này đạt được học bổng");
		}else {
			System.out.println("Học sinh này không đạt được học bổng");
		}
	}
}


