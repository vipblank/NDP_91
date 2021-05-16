package com.VTI.backend;

import com.VTI.entity.Student;

public class Exercise1 {
	public void question1() {
		Student<Integer> student1 = new Student<Integer>(1, "name1");
		printStudent(student1);
//		System.out.println(student1);
		Student<String> student2 = new Student<String>("VTI2" , "name2");
		printStudent(student2);
//		System.out.println(student2);
		Student<Float> student3 = new Student<Float>((float) 2.2, "name3");
		printStudent(student3);
//		System.out.println(student3);
	}

	private <T> void printStudent(T student) {
		System.out.println(student);	
	}
	public <E> void question4() {
		Integer[] arrnum1 = {5, 10, 15};
		printArr(arrnum1);
		Float[] arrnum2 = {5f, 6f, 7f};
		printArr(arrnum2);
		Double[] arrnum3 = {5.5, 6.6, 7.7};
		printArr(arrnum3);
		
	}

	private <E> void printArr(E[] arrnum) {
		for (int i = 0; i < arrnum.length; i++) {
			System.out.println(arrnum[i]);
		}
		
	}
	
}
