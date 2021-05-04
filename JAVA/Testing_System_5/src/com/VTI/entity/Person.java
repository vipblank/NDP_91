package com.VTI.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	public Scanner sc;
	private String hoten;
	private Gioitinh gioitinh;
	private LocalDate ngaysinh;
	private String diachi;
	public enum Gioitinh{
		NAM, NU, KHAC
	}

	public Person(String hoten, LocalDate ngaysinh, String diachi, Gioitinh gioitinh) {
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
	}
	
	public Person() {
		super();
	}
	
	public String showInfo() {
		return "Person [hoten=" + hoten + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi
				+ "]";
	}

	public void question2() {
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
	public void inputInfo() {
		sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào hoten");
		this.hoten = sc.next();
		System.out.println("Mời bạn nhập vào ngày sinh");
		int addday = sc.nextInt();
		System.out.println("Mời bạn nhập vào tháng sinh");
		int addmonth = sc.nextInt();
		System.out.println("Mời bạn nhập vào năm sinh");
		int addyear = sc.nextInt();
		this.ngaysinh = LocalDate.of(addyear, addmonth, addday);
		System.out.println("Mời bạn nhập vào địa chỉ");
		this.diachi = sc.next();
		System.out.println("Mời bạn chọn giới tính : 1.Nam, 2.Nu, 3.Khac");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			this.gioitinh = gioitinh.NAM;
			break;
		case 2:
			this.gioitinh = gioitinh.NU;
			break;
		case 3:
			this.gioitinh = gioitinh.KHAC;
			break;
		case 4:		
			return;
		default:
			System.out.println("Mời bạn chọn lại giới tính");
			break;
		}
	}
}


