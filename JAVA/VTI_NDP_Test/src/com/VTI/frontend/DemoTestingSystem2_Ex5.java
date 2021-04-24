package com.VTI.frontend;

import java.time.LocalDate;
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

public class DemoTestingSystem2_Ex5 {
	public static void main(String[] args) {
//		create department
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Marketing";

		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Sale";

		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "Logistic";

		Department dep4 = new Department();
		dep4.id = 4;
		dep4.name = "Engineering";

		Department dep5 = new Department();
		dep5.id = 5;
		dep5.name = "Filenance";

//		create position
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.PM;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.TEST;

//		account for group
		Account ac4 = new Account();
		ac4.id = 4;
		ac4.email = "lehaiyen@gmail.com";
		ac4.userName = "yen";
		ac4.fullName = "lehaiyen";
		ac4.createDate = LocalDate.of(2021, 03, 12);
		ac4.dep = dep2;
		ac4.pos = pos2;

//		create group
		Group gr1 = new Group();
		gr1.id = 1;
		gr1.name = "muahang";
		gr1.creator = ac4;
		gr1.CreateDate = LocalDate.of(2021, 04, 15);

		Group gr2 = new Group();
		gr2.id = 2;
		gr2.name = "banhang";
		gr2.creator = ac4;
		gr2.CreateDate = LocalDate.of(2021, 03, 15);

		Group gr3 = new Group();
		gr3.id = 3;
		gr3.name = "xuatnhapkhau";
		gr3.creator = ac4;
		gr3.CreateDate = LocalDate.of(2021, 03, 25);

//		create account
		Account ac1 = new Account();
		ac1.id = 1;
		ac1.email = "vucamnhung@gmail.com";
		ac1.userName = "nhung";
		ac1.fullName = "vucamnhung";
		ac1.createDate = LocalDate.of(2021, 04, 05);
		ac1.dep = dep1;
		ac1.pos = pos1;
		ac1.groups = new Group[] { gr3, gr1 };

		Account ac2 = new Account();
		ac2.id = 2;
		ac2.email = "phamvantruong@gmail.com";
		ac2.userName = "truong";
		ac2.fullName = "phamvantruong";
		ac2.createDate = LocalDate.of(2021, 03, 12);
		ac2.dep = dep3;
		ac2.pos = pos2;
		ac2.groups = new Group[] { gr3, gr2 };

		Account ac3 = new Account();
		ac3.id = 3;
		ac3.email = "dangthanhlam@gmail.com";
		ac3.userName = "lam";
		ac3.fullName = "dangthanhlam";
		ac3.createDate = LocalDate.of(2021, 02, 22);
		ac3.dep = dep5;
		ac3.pos = pos3;
		ac3.groups = new Group[] { gr2, gr1 };

		Account ac5 = new Account();
		ac5.id = 5;
		ac5.email = "levannam@gmail.com";
		ac5.userName = "nam";
		ac5.fullName = "levannam";
		ac5.createDate = LocalDate.of(2021, 02, 28);
		ac5.dep = dep4;
		ac5.pos = pos2;

		Account ac6 = new Account();
		ac6.id = 6;
		ac6.email = "nguyenhuongly@gmail.com";
		ac6.userName = "ly";
		ac6.fullName = "nguyenhuongly";
		ac6.createDate = LocalDate.of(2021, 03, 18);
		ac6.dep = dep1;
		ac6.pos = pos3;

//		create typequestion
		Typequestion tp1 = new Typequestion();
		tp1.id = 1;
		tp1.toString();

		Typequestion tp2 = new Typequestion();
		tp2.id = 2;
		tp2.toString();

//		Create categoryquestion
		Categoryquestion cate1 = new Categoryquestion();
		cate1.id = 1;
		cate1.name = "Java";

		Categoryquestion cate2 = new Categoryquestion();
		cate2.id = 2;
		cate2.name = ".NET";

		Categoryquestion cate3 = new Categoryquestion();
		cate3.id = 3;
		cate3.name = "SQL";

		Categoryquestion cate4 = new Categoryquestion();
		cate4.id = 4;
		cate4.name = "Postman";

		Categoryquestion cate5 = new Categoryquestion();
		cate5.id = 5;
		cate5.name = "Python";

//		Create Exam
		Exam Ex1 = new Exam();
		Ex1.id = 1;
		Ex1.code = "VTI101";
		Ex1.title = "title1";
		Ex1.categoryid = cate1;
		Ex1.duration = 30;
		Ex1.creator = ac1;
		Ex1.createdate = LocalDate.of(2021, 04, 11);

		Exam Ex2 = new Exam();
		Ex2.id = 2;
		Ex2.code = "VTI102";
		Ex2.title = "title2";
		Ex2.categoryid = cate2;
		Ex2.duration = 30;
		Ex2.creator = ac4;
		Ex2.createdate = LocalDate.of(2021, 04, 11);

		Exam Ex3 = new Exam();
		Ex3.id = 3;
		Ex3.code = "VTI103";
		Ex3.title = "title3";
		Ex3.categoryid = cate3;
		Ex3.duration = 15;
		Ex3.creator = ac2;
		Ex3.createdate = LocalDate.of(2021, 04, 12);

		Exam Ex4 = new Exam();
		Ex4.id = 4;
		Ex4.code = "VTI104";
		Ex4.title = "title4";
		Ex4.categoryid = cate4;
		Ex4.duration = 15;
		Ex4.creator = ac6;
		Ex4.createdate = LocalDate.of(2021, 04, 12);

//		Create question
		Question Q1 = new Question();
		Q1.id = 1;
		Q1.content = "content1";
		Q1.categoryQ = cate1;
		Q1.typeQ = tp1;
		Q1.creator = ac3;
		Q1.createdate = LocalDate.of(2021, 04, 02);
		Q1.exams = new Exam[] { Ex1, Ex2 };

		Question Q2 = new Question();
		Q2.id = 2;
		Q2.content = "content2";
		Q2.categoryQ = cate2;
		Q2.typeQ = tp1;
		Q2.creator = ac2;
		Q2.createdate = LocalDate.of(2021, 04, 02);
		Q2.exams = new Exam[] { Ex1, Ex2 };

		Question Q3 = new Question();
		Q3.id = 3;
		Q3.content = "content3";
		Q3.categoryQ = cate3;
		Q3.typeQ = tp1;
		Q3.creator = ac1;
		Q3.createdate = LocalDate.of(2021, 04, 02);
		Q3.exams = new Exam[] { Ex1, Ex2 };

		Question Q4 = new Question();
		Q4.id = 4;
		Q4.content = "content4";
		Q4.categoryQ = cate5;
		Q4.typeQ = tp2;
		Q4.creator = ac2;
		Q4.createdate = LocalDate.of(2021, 04, 02);
		Q4.exams = new Exam[] { Ex3, Ex4 };

		Question Q5 = new Question();
		Q5.id = 5;
		Q5.content = "content5";
		Q5.categoryQ = cate4;
		Q5.typeQ = tp2;
		Q5.creator = ac4;
		Q5.createdate = LocalDate.of(2021, 04, 02);
		Q5.exams = new Exam[] { Ex3, Ex4 };

		Question Q6 = new Question();
		Q6.id = 6;
		Q6.content = "content6";
		Q6.categoryQ = cate4;
		Q6.typeQ = tp2;
		Q6.creator = ac5;
		Q6.createdate = LocalDate.of(2021, 04, 02);
		Q6.exams = new Exam[] { Ex3, Ex4 };

//		create answer
		Answer as1 = new Answer();
		as1.id = 1;
		as1.content = "content1";
		as1.quesid = Q1;

		Answer as2 = new Answer();
		as2.id = 2;
		as2.content = "content1";
		as2.quesid = Q1;

		Answer as3 = new Answer();
		as3.id = 3;
		as3.content = "content1";
		as3.quesid = Q2;

		Answer as4 = new Answer();
		as4.id = 4;
		as4.content = "content1";
		as4.quesid = Q2;

		Answer as5 = new Answer();
		as5.id = 5;
		as5.content = "content1";
		as5.quesid = Q3;

		Answer as6 = new Answer();
		as6.id = 6;
		as6.content = "content1";
		as6.quesid = Q3;

		Answer as7 = new Answer();
		as7.id = 7;
		as7.content = "content1";
		as7.quesid = Q4;

		Answer as8 = new Answer();
		as8.id = 8;
		as8.content = "content1";
		as8.quesid = Q4;
		
//		Ex5 - Question 1
		System.out.println("Ex5 - Q1 : Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình");
		Scanner sc1 = new Scanner(System.in);
		int x;
		int y;
		int z;
		System.out.println("Mời bạn nhập số thứ 1 ");
		x = sc1.nextInt();
		System.out.println("Mời bạn nhập số thứ 2");
		y = sc1.nextInt();
		System.out.println("Mời bạn nhập số thứ 3");
		z = sc1.nextInt();
		System.out.println("Những số đã nhập vào : " + x + y + z);
		

//		Ex5 - Question 2
		System.out.println("Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào 2 số thực");
		System.out.println("Mời bạn nhập vào số thứ 1");
		float f1 = sc2.nextFloat();
		System.out.println("Mời bạn nhập vào số thực thứ 2");
		float f2 = sc2.nextFloat();
		System.out.println("Những số bạn vừa nhập : " + f1 + "" + f2);

//		Ex5 - Question 3
		System.out.println("Ex5 - Q3 : Viết lệnh cho phép người dùng nhập họ và tên");
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào họ");
		String str1 = sc3.next();
		System.out.println("Mời bạn nhập vào tên");
		String str2 = sc3.next();
		System.out.println("Họ và tên của bạn là : " + str1 + "" + str2);

//		Ex5 - Question 4
		System.out.println("Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ");
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào năm sinh");
		int year = sc4.nextInt();
		System.out.println("Mời bạn nhập vào tháng sinh");
		int month = sc4.nextInt();
		System.out.println("Mời bạn nhập vào ngày sinh");
		int day = sc4.nextInt();
		LocalDate ngaysinh = LocalDate.of(year, month, day);
		System.out.println("Ngày sinh của bạn là : " + ngaysinh);

//		Ex5 - Question 5
		System.out.println("Ex5-Q5 : Viết lệnh cho phép người dùng tạo account (viết thành method)");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin account");
		Account acc = new Account();
		System.out.println("Mời bạn nhập vào ID ");
		acc.id = sc.nextInt();
		System.out.println("Mời bạn nhập vào userName");
		acc.userName = sc.next();
		System.out.println("Mời bạn nhập vào fullName");
		acc.fullName = sc.next();
		System.out.println("Mời bạn nhập vào Email");
		acc.email = sc.next();
		System.out.println("Mời bạn nhập vào mã chức vụ :  1.DEV,  2.TEST, 3.SCRUM_MASTER, 4.PM ");
		int posNum = sc.nextInt();
		switch (posNum) {
		case 1:
			Position ps1 = new Position();
			ps1.name = PositionName.DEV;
			acc.pos = ps1;
			break;
		case 2:
			Position ps2 = new Position();
			ps2.name = PositionName.TEST;
			acc.pos = ps2;
			break;
		case 3:
			Position ps3 = new Position();
			ps3.name = PositionName.SCRUM_MASTER;
			acc.pos = ps3;
			break;
		case 4:
			Position ps4 = new Position();
			ps4.name = PositionName.PM;
			acc.pos = ps4;
			break;
		default:
			break;
		}
		System.out.println("Thông tin account mới nhập");
		System.out.println("ID: " + acc.id);
		System.out.println("userName: " + acc.userName);
		System.out.println("FullName: " + acc.fullName);
		System.out.println("Email: " + acc.email);
		System.out.println("Chức Vụ: " + acc.pos.name);

//			Ex5 - Question 6
		System.out.println("Ex5 - Q6 : Viết lệnh cho phép người dùng tạo department (viết thành method)");
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin phòng ban");
		Department dep = new Department();
		System.out.println("Mời bạn nhập vào ID phòng ban");
		dep.id = sc5.nextInt();
		System.out.println("Mời bạn nhập tên phòng ban");
		dep.name = sc5.next();
		System.out.println("Thông tin phòng ban bạn vừa tạo : " + dep.id + "" + dep.name);

//			Ex5 - Question 7
		System.out.println("Nhập số chẵn từ console");

//			Ex5 - Question 8
		System.out.println("Viết chương trình thực hiện theo flow sau");
		Scanner sc6 = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng : 1. Tạo account, 2. Tạo Department");
			choose = sc6.nextInt();
			if (choose == 1 || choose == 2) {
				switch (choose) {
				case 1:
					Scanner sc7 = new Scanner(System.in);
					System.out.println("Mời bạn nhập vào thông tin account");
					Account acc1 = new Account();
					System.out.println("Mời bạn nhập vào ID ");
					acc.id = sc7.nextInt();
					System.out.println("Mời bạn nhập vào userName");
					acc1.userName = sc7.next();
					System.out.println("Mời bạn nhập vào fullName");
					acc1.fullName = sc7.next();
					System.out.println("Mời bạn nhập vào Email");
					acc1.email = sc7.next();
					System.out.println("Mời bạn nhập vào mã chức vụ :  1.DEV,  2.TEST, 3.SCRUM_MASTER, 4.PM ");
					int posNum1 = sc7.nextInt();
					switch (posNum1) {
					case 1:
						Position ps1 = new Position();
						ps1.name = PositionName.DEV;
						acc.pos = ps1;
						break;
					case 2:
						Position ps2 = new Position();
						ps2.name = PositionName.TEST;
						acc.pos = ps2;
						break;
					case 3:
						Position ps3 = new Position();
						ps3.name = PositionName.SCRUM_MASTER;
						acc.pos = ps3;
						break;
					case 4:
						Position ps4 = new Position();
						ps4.name = PositionName.PM;
						acc.pos = ps4;
						break;
					}
					System.out.println("Thông tin account mới nhập");
					System.out.println("ID: " + acc.id);
					System.out.println("userName: " + acc.userName);
					System.out.println("FullName: " + acc.fullName);
					System.out.println("Email: " + acc.email);
					System.out.println("Chức Vụ: " + acc.pos.name);
					break;

				case 2:
					Scanner sc8 = new Scanner(System.in);
					System.out.println("Mời bạn nhập vào thông tin phòng ban");
					Department dep0 = new Department();
					System.out.println("Mời bạn nhập vào ID phòng ban");
					dep0.id = sc8.nextInt();
					System.out.println("Mời bạn nhập tên phòng ban");
					dep0.name = sc8.next();
					System.out.println("Thông tin phòng ban bạn vừa tạo : " + dep.id + "" + dep.name);
					break;
				}
				return;
			} else {
				System.out.println("Mời Nhập Lại");
			
			}
		}
		
	}
}
