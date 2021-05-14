package com.VTI.backend;

import java.util.Iterator;
import java.util.Stack;

import com.VTI.entity.Student;

public class Exercise2 {
	public static Stack<Student> stackStudent;
	public Exercise2() {
		stackStudent = new Stack<Student>();
		Student st1 = new Student("name1");
		Student st2 = new Student("name2");
		Student st3 = new Student("name3");
		Student st4 = new Student("name4");
		Student st5 = new Student("name5");
		Student st6 = new Student("name6");
		stackStudent.push(st1);
		stackStudent.push(st2);
		stackStudent.push(st3);
		stackStudent.push(st4);
		stackStudent.push(st5);
		stackStudent.push(st6);
	}
	public void question1() {
		System.out.println("Thứ tự sinh viên từ thấp đến cao");
		Iterator<Student> iterator = stackStudent.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student);
		}
	}
	public void question2() {
		System.out.println("Sinh viên đến muộn nhất" + stackStudent.peek());
		System.out.println("Thứ tự sinh viên từ cao đến thấp");
		for (int i = 0; i < stackStudent.size(); i++) {
			System.out.println(stackStudent.pop());
		}
		System.out.println("Số sinh viên còn lại trong stack: " + stackStudent.size());
	}
	public void question3() {
		
	}
}
