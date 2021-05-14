package com.VTI.backend;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

import com.VTI.entity.Student;
import com.VTI.ultis.ScannerUltis;

public class Exercise1 {
	public ArrayList<Student> listStudent;
	public Exercise1() {
		listStudent = new ArrayList<Student>();
		Student st1 = new Student("nam");
		Student st2 = new Student("nam");
		Student st3 = new Student("nam");
		listStudent.add(st1);
		listStudent.add(st2);
		listStudent.add(st3);

		Student st4 = new Student("linh");
		Student st5 = new Student("huy");
		Student st6 = new Student("hai");
		listStudent.add(st4);
		listStudent.add(st5);
		listStudent.add(st6);
		
	}
	public void question1a() {
		System.out.println("Số sinh viên có trên hệ thống: " + listStudent.size());
	}
	public void question1b() {
		System.out.println("Thông tin học sinh thứ 4 là : " + listStudent.get(3));
	}
	public void question1c() {
		System.out.println("Thông tin học sinh đầu tiên: " + listStudent.get(0));
		System.out.println("Thông tin học sinh cuối cùng: " + listStudent.get(listStudent.size()-1));
	}
	public void question1d() {
		System.out.println("Nhập thông tin học sinh muốn thêm");
		String name = ScannerUltis.inputString();
		listStudent.add(0, new Student(name));
		System.out.println("Thông tin học sinh đầu tiên: " + listStudent.get(0));
		
		System.out.println("Nhập thông tin học sinh muốn thêm");
		String name1 = ScannerUltis.inputString();
		listStudent.add(new Student(name1));
		System.out.println("Thông tin học sinh cuối cùng: " + listStudent.get(listStudent.size()-1));
		for (Student student : listStudent) {
			System.out.println(student);
		}
	}
	public void question1e() {
		Collections.reverse(listStudent);
		System.out.println("danh sách sau khi đảo: ");
		for (Student student : listStudent) {
			System.out.println(student);
		}
	}
	public void question1f() {
		System.out.println("Nhập vào id sinh viên cần tìm kiểm");
		int checkID = ScannerUltis.inputInt2();
		for (Student student : listStudent) {
			if (student.getId() == checkID) {
				System.out.println("Thông tin học sinh cần tìm: " + student.toString());
			}
		}
	}
	public void question1g() {
		System.out.println("Nhập vào têm sinh viên cần tìm kiểm");
		String checkName = ScannerUltis.inputString();
		for (Student student : listStudent) {
			if (student.getName().equals(checkName)) {
				System.out.println("Thông tin học sinh cần tìm: " + student.toString());
			}
		}
	}
	public void question1h() {
		System.out.println("Nhập vào id sinh viên cần xóa");
		int deleteID = ScannerUltis.inputInt2();
		java.util.Iterator<Student> iterator = listStudent.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			if (student.getId() == deleteID) {
				iterator.remove();
				for (Student student1 : listStudent) {
					System.out.println(student1.toString());
				}
			}
		}
	}
	public void question1i() {
		System.out.println("Nhập vào id sinh viên cần xóa");
		int deleteID1 = ScannerUltis.inputInt2();
		for (Student student2 : listStudent) {
			if (student2.getId() == deleteID1) {
				student2.setName(null);				
			}			
			System.out.println(student2.toString());
		}		
	}
	public void question1k() {
		System.out.println("Tạo mới arraylist để copy");
		ArrayList<Student> listCopy = new ArrayList<Student>();
		listCopy.addAll(listStudent);
		System.out.println("In ra phần tử trong array copy");
		for (Student student : listCopy) {
			System.out.println(student);
		}
	}
	public void question2a() {
		
		Stack<Student> stackStudents = new Stack<Student>();
		Student student1 = new Student("nam");
		Student student2 = new Student("nam");
		Student student3 = new Student("nam");
		Student student4 = new Student("linh");
		Student student5 = new Student("huy");
		Student studen6 = new Student("hai");
		stackStudents.add(student1);
		stackStudents.add(student2);
		stackStudents.add(student3);
		stackStudents.add(student4);
		stackStudents.add(student5);
		stackStudents.add(studen6);
		Iterator<Student> iterator = stackStudents.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student);
		}
				
	}
}
