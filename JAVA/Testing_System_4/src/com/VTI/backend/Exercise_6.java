package com.VTI.backend;

import java.util.Scanner;

import com.VTI.entity.VietnamesePhone;

public class Exercise_6 {
	private Scanner sc ;
	public VietnamesePhone vnPhone;
	public void question1() {
		sc = new Scanner(System.in);	    
		vnPhone = new VietnamesePhone();
		while (true) {				
		System.out.println("========================================================");
		System.out.println("================ Lựa Chọn Chức Năng ====================");
		System.out.println("================ 1: insertContact ======================");
		System.out.println("================ 2: removeContact ======================");
		System.out.println("================ 3: updateContact ======================");
		System.out.println("================ 4: searchContact ======================");
		System.out.println("================ 5: Thoát khỏi chương trình ============");
		System.out.println("========================================================");
		int luachon = sc.nextInt();
		switch (luachon) {
		case 1:
			insertContact();
			break;
		case 2:
			removeContact();
			break;
		case 3:
			updateContact();
			break;
		case 4:
			searchContact();
			break;
		case 5:
			
			return;
		default:
			System.out.println("Mời bạn chọn chức năng");
			break;
			}
		}
	}
	public void insertContact() {
		System.out.println("Mời nhập tên Contact");
		String addname = sc.next();
		System.out.println("Mời nhập số Phone");
		String addphone = sc.next();
		vnPhone.insertContact(addname, addphone);
	}
	public void removeContact() {
		System.out.println("Nhập tên Contact bạn muốn xóa ");
		String deletename = sc.next();
		vnPhone.removeContact(deletename);
	}
	public void updateContact() {
		System.out.println("Mời nhập tên Contact");
		String addname = sc.next();
		System.out.println("Mời nhập số Phone");
		String addnewphone = sc.next();
		vnPhone.updateContact(addname, addnewphone);
	}
	public void searchContact() {
		System.out.println("Nhập tên Contact bạn muốn tìm ");
		String findname = sc.next();
		vnPhone.searchContact(findname);			
	}
	
}

