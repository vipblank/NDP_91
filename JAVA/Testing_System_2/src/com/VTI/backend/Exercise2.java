package com.VTI.backend;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import com.VTI.entity.Account;
import com.VTI.entity.Answer;
import com.VTI.entity.Categoryquestion;
import com.VTI.entity.Department;
import com.VTI.entity.Exam;
import com.VTI.entity.Group;
import com.VTI.entity.Position;
import com.VTI.entity.Question;
import com.VTI.entity.Typequestion;
import com.VTI.entity.Position.PositionName;

public class Exercise2 {
	

		public void question1() {
//			Ex2 - Question 1
			System.out.println("Ex2 - Q1 : Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó");
			int o1 = 5;
			System.out.printf("%s", "số nguyên là : " + o1);
		}
		public void question2() {
			
		
//			Ex2 - Question 2
			System.out.println("Ex2 - Q2 : Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000");
			int o2 = 100000000;
			System.out.printf(Locale.US, "%,d %n", o2 );
		}
		public void question3() {
			
		
//			Ex2 - Question 3
			System.out.println("Ex2 - Q3 : Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau");
		}
		public void question4() {
			
		
//			Ex2 - Question 4
			System.out.println("Ex2 - Q4 : Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng");
			System.out.print("Tên tôi là : " );
			System.out.println("Tôi đang độc thân");
		}
		public void question5() {
			
		
//			Ex2 - Question 5
			System.out.println("Ex2 - Q5 : Lấy thời gian bây giờ và in ra theo định dạng sau");
		}
	

}




