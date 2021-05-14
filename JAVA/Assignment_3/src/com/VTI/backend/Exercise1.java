package com.VTI.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.VTI.entity.Student;
import com.VTI.ultis.ScannerUltis;

public class Exercise1 {
	private static Scanner sc;
	public ArrayList<Student> listStudent;
	public void question1() {
		sc = new Scanner(System.in);
		float inch = 2.54f;
		float foot = 12*inch;
		System.out.println("chương trình nhập vào số thực");
		System.out.println("Mời bạn nhập vào 1 số thực");
		float number = ScannerUltis.inputFloadt();
		System.out.println("chuyển số đã nhập ra: 1.inch, 2.foot");
		while (true) {
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				number /= inch;
				System.out.printf( "Số bạn nhập vào tương đương với: " + number + " inch");
				return;
			case 2:
				number /= foot;
				System.out.printf( "Số bạn nhập vào tương đương với: " + number + " foot");
				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}		
	}
	public static void question3() {
		sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào số nguyên thứ 1");
		int number1 = ScannerUltis.inputInt();
		System.out.println("Mời bạn nhập vào số nguyên thứ 2");
		int number2 = ScannerUltis.inputInt();
		System.out.println("Mời bạn nhập vào số nguyên thứ 3");
		int number3 = ScannerUltis.inputInt();
		System.out.println("Mời bạn nhập vào số nguyên thứ 4");
		int number4 = ScannerUltis.inputInt();
		int numbers[] = {number1, number2, number3, number4};
		sc.close();
		int maxvalue = numbers[0];
		int minvalue = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > maxvalue) {		
				maxvalue = numbers[i];
			}else if (numbers[i] < minvalue) {
				minvalue = numbers[i];
			}	
		}
		System.out.println("số lớn nhất là: " + maxvalue);
		System.out.println("số nhỏ nhất là: " + minvalue);
	}
	public void question4() {
		sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào số nguyên thứ 1");
		int number1 = ScannerUltis.inputInt();
		System.out.println("Mời bạn nhập vào số nguyên thứ 2");
		int number2 = ScannerUltis.inputInt();
		sc.close();
		int number = number1-number2;
		if (number < 0) {
			System.out.println( number + " number1 < number2 ");
		}else if (number > 0) {
			System.out.println( number + " number1 > number2 ");
		}else if (number == 0) {
			System.out.println( number + " number1 = number2 ");
		}
	}
	public void question5() {
		sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào số nguyên thứ 1");
		int number1 = ScannerUltis.inputInt();
		System.out.println("Mời bạn nhập vào số nguyên thứ 2");
		int number2 = ScannerUltis.inputInt();
		sc.close();	
		if (number1 % number2 !=0 ) {
			System.out.println("number1 không chia hết cho number2");		
		}else if (number1 % number2 == 0) {
			System.out.println("number1 chia hết cho number2");
		}
	}
	public void question6() {
		sc = new Scanner(System.in);
		listStudent = new ArrayList<Student>();
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("============ 1: Nhập vào điểm 3 môn học ================");
			System.out.println("============ 2: Hiển thị thông tin học sinh ============");
			System.out.println("============ 3: Tính điểm trung bình ===================");
			System.out.println("============ 4: Xác định học lực của học sinh ==========");
			System.out.println("============ 5: Thoát chương trình =====================");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				System.out.println("Mời bạn nhập vào điểm toán");
				float Tscore = ScannerUltis.inputScore();
				System.out.println("Mời bạn nhập vào điểm lý");
				float Lscore = ScannerUltis.inputScore();
				System.out.println("Mời bạn nhập vào điểm hóa");
				float Hscore = ScannerUltis.inputScore();
				Student student = new Student(Tscore, Lscore, Hscore);
				listStudent.add(student);
				break;
			case 2:
				for (Student student1 : listStudent) {
					System.out.println("thông tin học sinh" + student1);
				}
				break;
			case 3:
				for (Student student1 : listStudent) {
					float diemTB = (float) (student1.getDiemtoan()*2 + student1.getDiemly() + student1.getDiemhoa())/4;
					System.out.printf("điểm trung bình của học sinh thứ "+ student1.getId() + " là: " + diemTB + "\n");
				}			
				break;
			case 4:
				for (Student student1 : listStudent) {
					float diemTB = (float) (student1.getDiemtoan()*2 + student1.getDiemly() + student1.getDiemhoa())/4;
					if (diemTB >= 9.0) {
						System.out.println("Học lực của học sinh thứ " + student1.getId() + " là xuất sắc");
					}else if (diemTB >= 8.0 && diemTB < 9.0) {
						System.out.println("Học lực của học sinh thứ " + student1.getId() + " là giỏi");
					}else if (diemTB >= 7.0 && diemTB < 8.0) {
						System.out.println("Học lực của học sinh thứ " + student1.getId() + " là khá");
					}else if (diemTB >= 6.0 && diemTB < 7.0) {
						System.out.println("Học lực của học sinh thứ " + student1.getId() + " là trung bình khá");
					}else if (diemTB >= 5.0 && diemTB < 6.0) {
						System.out.println("Học lực của học sinh thứ " + student1.getId() + " là trung bình");
					}else if (diemTB < 5.0) {
						System.out.println("Học lực của học sinh thứ " + student1.getId() + " là yếu");
					}
				}				
				break;
			case 5:
				
				return;
			default:
				System.err.println("Mời chọn lại chức năng");
				break;
			}
		}
	}
}
