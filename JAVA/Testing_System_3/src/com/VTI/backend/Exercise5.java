package com.VTI.backend;

import java.util.Scanner;

import com.VTI.entity.Department;

public class Exercise5 {
	public void question1() {
		Department[] department = new Department[5];
		Department dep1 = new Department(1, "Marketing");
		Department dep2 = new Department(2, "Sale");
		Department dep3 = new Department(3, "Logistic");
		Department dep4 = new Department(4, "Engineering");
		Department dep5 = new Department(5, "Filenance");

		department[0] = dep1;
		department[1] = dep2;
		department[2] = dep3;
		department[3] = dep4;
		department[4] = dep5;
		
		System.out.println("Ex5 - Question1");	
		System.out.println("thông tin phòng ban số 1: " + department[0].toString() );
		
	}
	public void question2() {
		Department[] department = new Department[5];
		Department dep1 = new Department(1, "Marketing");
		Department dep2 = new Department(2, "Sale");
		Department dep3 = new Department(3, "Logistic");
		Department dep4 = new Department(4, "Engineering");
		Department dep5 = new Department(5, "Filenance");

		department[0] = dep1;
		department[1] = dep2;
		department[2] = dep3;
		department[3] = dep4;
		department[4] = dep5;
		
		System.out.println("Ex5 - Question2");	
		for (Department department2 : department) {
			System.out.println("thông tin các phòng ban: " + department2.toString());
		}
	}
	public void question3() {
		Department[] department = new Department[3];
		Department dep1 = new Department(1, "Marketing");
		Department dep2 = new Department(2, "Sale");
		Department dep3 = new Department(3, "Logistic");

		department[0] = dep1;
		department[1] = dep2;
		department[2] = dep3;

		System.out.println("Ex5 - Question3");	
		System.out.println("địa chỉ phòng ban số 1: " + department[0].hashCode());
	}
	public void question4() {
		Department[] department = new Department[1];
		Department dep1 = new Department(1, "Marketing");

		department[0] = dep1;
	
		System.out.println("Ex5 - Question4");	
		if (department[0].name == "Phong A") {
			System.out.println("Đây là phòng A");
		}else {
			System.out.println("Đây không phải phòng A");
		}
	}
	public void question5() {
		Department[] department = new Department[2];
		Department dep1 = new Department(1, "Marketing");
		Department dep2 = new Department(2, "Logistic");
		
		department[0] = dep1;
		department[1] = dep2;
		
		System.out.println("Ex5 - Question5");	
		if (department[0].name.equals(department[1].name)) {
			System.out.println("2 phòng ban bằng nhau");
		}else {
			System.out.println("2 phòng ban không bằng nhau");
		}
	}
	public void question6() {
		Department[] department = new Department[5];
		Department dep1 = new Department(1, "Waiting room");
		Department dep2 = new Department(2, "Marketingr");
		Department dep3 = new Department(3, "Boss of director");
		Department dep4 = new Department(4, "Sale");
		Department dep5 = new Department(5, "Accounting");

		department[0] = dep1;
		department[1] = dep2;
		department[2] = dep3;
		department[3] = dep4;
		department[4] = dep5;
		
		System.out.println("Ex5 - Question6");	
		for (Department department2 : department) {
			System.out.println("thông tin các phòng ban: " + department2.toString());
		}
	}
}
