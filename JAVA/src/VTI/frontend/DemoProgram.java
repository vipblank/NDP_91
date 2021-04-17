package com.VTI.frontend;

import java.time.LocalDate;

import com.VTI.entity.Account;
import com.VTI.entity.Answer;
import com.VTI.entity.Categoryquestion;
import com.VTI.entity.Department;
import com.VTI.entity.Exam;
import com.VTI.entity.Group;
import com.VTI.entity.Position;
import com.VTI.entity.Position.PositionName;
import com.VTI.entity.Question;
import com.VTI.entity.Typequestion;

public class DemoProgram {
	public static void main(String[] args) {
		System.out.println("Hello VTI");

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
		ac4.username = "yen";
		ac4.fullname = "lehaiyen";
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
		ac1.username = "nhung";
		ac1.fullname = "vucamnhung";
		ac1.createDate = LocalDate.of(2021, 04, 05);
		ac1.dep = dep1;
		ac1.pos = pos1;
		ac1.groups = new Group[] { gr3,gr1};
						
		Account ac2 = new Account();
		ac2.id = 2;
		ac2.email = "phamvantruong@gmail.com";
		ac2.username = "truong";
		ac2.fullname = "phamvantruong";
		ac2.createDate = LocalDate.of(2021, 03, 12);
		ac2.pos = pos2;
		ac2.groups = new Group[] { gr3,gr2 };
		
		Account ac3 = new Account();
		ac3.id = 3;
		ac3.email = "dangthanhlam@gmail.com";
		ac3.username = "lam";
		ac3.fullname = "dangthanhlam";
		ac3.createDate = LocalDate.of(2021, 02, 22);
		ac3.dep = dep5;
		ac3.pos = pos3;
		ac3.groups = new Group[] {gr2,gr1};
		
		Account ac5 = new Account();
		ac5.id = 5;
		ac5.email = "levannam@gmail.com";
		ac5.username = "nam";
		ac5.fullname = "levannam";
		ac5.createDate = LocalDate.of(2021, 02, 28);
		ac5.dep = dep4;
		
		Account ac6 = new Account();
		ac6.id = 6;
		ac6.email = "nguyenhuongly@gmail.com";
		ac6.username = "ly";
		ac6.fullname = "nguyenhuongly";
		ac6.createDate = LocalDate.of(2021, 03, 18);
		ac6.pos = pos3;
		
//		create typequestion
		Typequestion tp1 = new Typequestion();
		tp1.id = 1;
		tp1.equals("EASY");
		
		Typequestion tp2 = new Typequestion();
		tp2.id = 2;
		tp2.equals("MULTI_CHOICE");
		
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
		Q1.categoryQ = cate1 ;
		Q1.typeQ = tp1;
		Q1.creator = ac3;
		Q1.createdate = LocalDate.of(2021, 04, 02);
		Q1.exams = new Exam[] {Ex1, Ex2};
		
		Question Q2 = new Question();
		Q2.id = 2;
		Q2.content = "content2";
		Q2.categoryQ = cate2 ;
		Q2.typeQ = tp1;
		Q2.creator = ac2;
		Q2.createdate = LocalDate.of(2021, 04, 02);
		Q2.exams = new Exam[] {Ex1, Ex2};
		
		Question Q3 = new Question();
		Q3.id = 3;
		Q3.content = "content3";
		Q3.categoryQ = cate3 ;
		Q3.typeQ = tp1;
		Q3.creator = ac1;
		Q3.createdate = LocalDate.of(2021, 04, 02);
		Q3.exams = new Exam[] {Ex1, Ex2};
		
		Question Q4 = new Question();
		Q4.id = 4;
		Q4.content = "content4";
		Q4.categoryQ = cate5 ;
		Q4.typeQ = tp2;
		Q4.creator = ac2;
		Q4.createdate = LocalDate.of(2021, 04, 02);
		Q4.exams = new Exam[] {Ex3, Ex4};
		
		Question Q5 = new Question();
		Q5.id = 5;
		Q5.content = "content5";
		Q5.categoryQ = cate4 ;
		Q5.typeQ = tp2;
		Q5.creator = ac4;
		Q5.createdate = LocalDate.of(2021, 04, 02);
		Q5.exams = new Exam[] {Ex3, Ex4};
		
		Question Q6 = new Question();
		Q6.id = 6;
		Q6.content = "content6";
		Q6.categoryQ = cate4 ;
		Q6.typeQ = tp2;
		Q6.creator = ac5;
		Q6.createdate = LocalDate.of(2021, 04, 02);
		Q6.exams = new Exam[] {Ex3, Ex4};
		
//		create answer
		Answer as1 = new Answer();
		as1.id = 1;
		as1.content = "content1";
		as1.quesid = Q1;
		as1.isCorrect.equals("True");
		
		Answer as2 = new Answer();
		as2.id = 2;
		as2.content = "content1";
		as2.quesid = Q1;
		as2.isCorrect.equals("False");
		
		Answer as3 = new Answer();
		as3.id = 3;
		as3.content = "content1";
		as3.quesid = Q2;
		as3.isCorrect.equals("True");
		
		Answer as4 = new Answer();
		as4.id = 4;
		as4.content = "content1";
		as4.quesid = Q2;
		as4.isCorrect.equals("False");
		
		Answer as5 = new Answer();
		as5.id = 5;
		as5.content = "content1";
		as5.quesid = Q3;
		as5.isCorrect.equals("True");
		
		Answer as6 = new Answer();
		as6.id = 6;
		as6.content = "content1";
		as6.quesid = Q3;
		as6.isCorrect.equals("False");
		
		Answer as7 = new Answer();
		as7.id = 7;
		as7.content = "content1";
		as7.quesid = Q4;
		as7.isCorrect.equals("True");
		
		Answer as8 = new Answer();
		as8.id = 8;
		as8.content = "content1";
		as8.quesid = Q4;
		as8.isCorrect.equals("False");
		
//		TestingSystem1
		
		
		System.out.println("chức vụ số 1");
		System.out.println("ID: " + pos1.id);
		System.out.println("Name: " + pos1.name);

		System.out.println("Phòng Số 2");
		System.out.println("ID: " + dep2.id);
		System.out.println("ID: " + dep2.name);

		System.out.println("tài khoản 1");
		System.out.println("email: " + ac1.email);
		System.out.println("username: " + ac1.username);
		System.out.println("fullname: " + ac1.fullname);
		System.out.println("createdate: " + ac1.createDate);
		System.out.println("phòng ban: " + ac1.dep.name);
		System.out.println("chức vụ: " + ac1.pos.name);

		System.out.println("Nhóm");
		System.out.println("id: " + gr1.id);
		System.out.println("name:" + gr1.name);
		System.out.println("người tạo:" + gr1.creator);
		System.out.println("ngày tạo:" + gr1.CreateDate);
		System.out.println("tài khoản:" + gr1.accounts);
		
		System.out.println("Nhân Viên Số 2");
		if (ac2.dep == null) {
			System.out.println("Nhân Viên Chưa Có Phòng Ban");
		} else {
			System.out.println("Phòng Số:" + ac2.dep.id);
		}

		if (ac4.groups == null) {
			System.out.println("Nhân Viên Này Chưa Có Group");
		}
		if (ac2.groups.length == 1 || ac2.groups.length == 2) {
			System.out.println("Group của nhân viên này là JAVA fresher, C#Fresher");
		} else if (ac2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng");
		} else if (ac2.groups.length == 4) {
			System.out.println("Nhân Viên Này Là Người Hóng Chuyện");
		}
		if (ac1.pos.name.equals("DEV")) {
			System.out.println("Đây là Deverloper");
		} else {
			System.out.println("Đây không phải là Deverloper");
		}
		
	}

}
