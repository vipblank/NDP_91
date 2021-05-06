package com.VTI.entity;

import com.VTI.ultis.ScannerUltis;

public class Student {
	private int id;
	private String name;
	private static String college = "Đại Học Bách KHoa";
	public static int count = 0;
	public static int moneyGroup;
	
	public Student() {
		count++;
		this.id = count;
		System.out.println("Nhập vào tên sinh viên");
		this.name = ScannerUltis.inputString();
	}
	
	
	@Override
	public String toString() {
		return "Student [id = " + id + ", name = " + name + " , college = " + college + ", moneyGroup = " + moneyGroup + "]";
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public static String getCollege() {
		return college;
	}


	public static void setCollege(String newcollege) {
		Student.college = newcollege;
	}


	public Student(int id, String name) {
		super();
		count++;
		this.id = count;
		this.name = name;
	}

}
