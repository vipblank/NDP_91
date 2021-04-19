package com.VTI.frontend;

import java.time.LocalDate;
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

public class DemoTestingSystem2 {
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

//		Ex1 - Question 1		
		System.out.println("Ex1-Q1 : Kiểm tra account thứ 2");
		if (ac2.dep == null) {
			System.out.println("Nhân Viên Chưa Có Phòng Ban");
		} else {
			System.out.println("Phòng Số:" + ac2.dep.id);
		}

//		Ex1 - Question 2
		System.out.println("Ex1-Q2 : Kiểm tra account thứ 2");
		if (ac2.groups == null) {
			System.out.println("Nhân Viên Này Chưa Có Group");
		}
		if (ac2.groups.length == 1 || ac2.groups.length == 2) {
			System.out.println("Group của nhân viên này là JAVA fresher, C#Fresher");
		} else if (ac2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng");
		} else if (ac2.groups.length == 4) {
			System.out.println("Nhân Viên Này Là Người Hóng Chuyện");
		}

//		Ex1 - Question 3
		System.out.println("Ex1-Q3 : Sử dụng toán tử ternary để làm Question 1");
		System.out.println(ac2.dep.name);
		if (ac2.dep == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là: " + ac2.dep.name);
		}

//		Ex1 - Question 4
		System.out.println("Ex1-Q4 : Sử dụng toán tử ternary để làm yêu cầu");
		System.out.println("Kiểm tra Position của account thứ 1");
		System.out.println("position" + ac1.pos.name);
		if (ac1.pos.name.equals("DEV")) {
			System.out.println("Đây là Deverloper");
		} else {
			System.out.println("Đây không phải là Deverloper");
		}

//		Ex1 - Question 5
		System.out.println("Ex1-Q5 : Lấy ra số lượng account trong nhóm thứ 2 và in ra theo format");

		if (gr2.accounts == null) {
			System.out.println("Nhóm chưa có thành viên");
		} else {
			int countAccInGroup = gr2.accounts.length;
			switch (countAccInGroup) {
			case 1:
				System.out.println("Nhóm có 1 thành viên");
				break;
			case 2:
				System.out.println("Nhóm có 2 thành viên");
				break;
			case 3:
				System.out.println("Nhóm có 3 thành viên");
			default:
				System.out.println("Nhóm có nhiều thành viên");
				break;
			}
		}

//		Ex1 - Question 6
		System.out.println("Ex1-Q6 : Sử dụng switch case để làm lại Question 2");
		if (ac2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {
			int countGroupInAcc = ac2.groups.length;
			switch (countGroupInAcc) {
			case 1:
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher\"");
				break;
			case 2:
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher\"");
				break;
			case 3:
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
				break;
			default:
				System.out.println("Nhân viên này tham gia tất cả các group");
				break;
			}
		}

//		Ex1 - Question 7
		System.out.println("Ex1 - Q7 : Sử dụng switch case để làm lại Question 4");
		

//		Ex1 - Question 8
		System.out.println("Ex1-Q8 : In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ");
		Account[] accArray = { ac1, ac2, ac3, ac4, ac5, ac6 };
		for (Account account : accArray) {
			System.out.println("Email: " + account.email + "FullName: " + account.fullName);
		}

//		Ex1 - Question 9
		System.out.println("Ex1-Q9 : In ra thông tin các phòng ban bao gồm: id và name");
		Department[] depArray = { dep1, dep2, dep3, dep4, dep5 };
		for (Department department : depArray) {
			System.out.println("ID : " + department.id + "Name : " + department.name);
		}

//		Ex1 - Question 10
		System.out.println(
				"Ex1-Q10 : In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng");
		Account[] accArray1 = { ac1, ac2, ac3, ac4, ac5, ac6 };
		for (int i = 0; i < accArray1.length; i++) {
			System.out.println("Email : " + accArray1[i].email);
			System.out.println("FullName : " + accArray1[i].fullName);
			System.out.println("PhòngBan : " + accArray1[i].dep.name);
		}

//		Ex1 - Question 11
		System.out.println("Ex1-Q11 : In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau");
		Department[] depArray1 = { dep1, dep2, dep3, dep4, dep5 };
		for (int j = 0; j < depArray1.length; j++) {
			System.out.println("ID : " + depArray1[j].id);
			System.out.println("Name : " + depArray1[j].name);
		}

//		Ex1 - Question 12 
		System.out.println("Ex1-Q12 : Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10");
		Department[] depArray2 = { dep1, dep2, dep3, dep4, dep5 };
		for (int i = 0; i < 2; i++) {
			System.out.println("ID : " + depArray2[i].id);
			System.out.println("Name : " + depArray2[i].name);
		}

//		Ex1 - Question 13
		System.out.println("Ex1-Q13 : In ra thông tin tất cả các account ngoại trừ account thứ 2");
		Account[] accArray2 = { ac1, ac2, ac3, ac4, ac5, ac6 };
		for (int i = 0; i < accArray2.length; i++) {
			if (i != 1) {
				System.out.println("ID : " + accArray2[i].id);
				System.out.println("userName : " + accArray2[i].userName);
				System.out.println("fullName : " + accArray2[i].fullName);
				System.out.println("Email : " + accArray2[i].email);
			}
		}

//		Ex1 - Question 14
		System.out.println("Ex1 - Q14 : In ra thông tin tất cả các account có id < 4");
		for (int i = 0; i < 3; i++) {
			System.out.println("ID : " + accArray2[i].id);
			System.out.println("userName : " + accArray2[i].userName);
			System.out.println("fullName : " + accArray2[i].fullName);
			System.out.println("Email : " + accArray2[i].email);
		}

//		Ex1 - Question 15
		System.out.println("Ex1 - Q15 : In ra các số chẵn nhỏ hơn hoặc bằng 20");
		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(i + "");
			}
		}

//		Ex1 - Question 16
		System.out.println(
				"Ex1 - Q16 : Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue");
		System.out.println(
				"Ex1 - Q16 - Q10 : In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng");
		Account[] accArray3 = { ac1, ac2, ac3, ac4, ac5, ac6 };
		int i1 = 0;
		while (i1 < accArray3.length) {
			System.out.println("Email : " + accArray3[i1].email);
			System.out.println("FullName : " + accArray3[i1].fullName);
			System.out.println("PhòngBan : " + accArray3[i1].dep.name);
			i1++;
		};

		System.out.println("Ex1 - Q16 - Q11 : In ra thông tin các phòng ban bao gồm: id và name theo định dạng");
		Department[] depArray3 = { dep1, dep2, dep3, dep4, dep5 };
		int j1 = 0;
		while (j1 < depArray3.length) {
			System.out.println("ID : " + depArray3[j1].id);
			System.out.println("Name : " + depArray3[j1].name);
			j1++;
		};

		System.out
				.println("Ex1 - Q16 - Q12 : Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10");
		Department[] depArray6 = { dep1, dep2, dep3, dep4, dep5 };
		int j6 = 0;
		while (j6 < 2) {
			System.out.println("ID : " + depArray6[j6].id);
			System.out.println("Name : " + depArray6[j6].name);
			j6++;
		}

		System.out.println("Ex1 - Q16 - Q13 : In ra thông tin tất cả các account ngoại trừ account thứ 2");
		Account[] accArray4 = { ac1, ac2, ac3, ac4, ac5, ac6 };
		int i2 = 0;
		while (i2 < accArray4.length) {
		if (i2 != 1) {
			System.out.println("Thông tin account thứ " + (i2 + 1) + " là:");
			System.out.println("ID : " + accArray4[i2].id);
			System.out.println("userName : " + accArray4[i2].userName);
			System.out.println("fullName : " + accArray4[i2].fullName);
			System.out.println("Email : " + accArray4[i2].email);
		} i2++;
	}	
		
		System.out.println("Ex1 - Q16 - Q14 : In ra thông tin tất cả các account có id < 4");
		Account[] accArray13 = { ac1, ac2, ac3, ac4, ac5, ac6 };
		int a4 = 0;
			while (a4 < accArray13.length) {
				if (accArray13[a4].id < 4) {
					System.out.println("ID : " + accArray13[a4].id);
					System.out.println("userName : " + accArray13[a4].userName);
					System.out.println("fullName : " + accArray13[a4].fullName);
					System.out.println("Email : " + accArray13[a4].email);
				} a4++;
			}
		
		System.out.println("Ex1 - Q16 - Q15 : In ra các số chẵn nhỏ hơn hoặc bằng 20");
		int a = 0;
				while (a <= 20) {
					if (a%2 == 0) {
						System.out.println(a + "");
					}a++;
				}
			
//		Ex1 - Question 17

			System.out.println("Ex1 - Q17 - Q10 : In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ ");
			Account[] accArray5 = { ac1, ac2, ac3, ac4, ac5, ac6 };
			int i3 = 0;
			do {
				System.out.println("Thông tin account thứ " + (i3 + 1) + "là: ");
				System.out.println("Email : " + accArray5[i3].email);
				System.out.println("FullName : " + accArray5[i3].fullName);
				System.out.println("PhòngBan : " + accArray5[i3].dep.name);
				i3++;
			} while (i3 < accArray3.length);

			System.out.println("Ex1 - Q17 - Q11 : In ra thông tin các phòng ban bao gồm: id và name theo định dạng");
			Department[] depArray4 = { dep1, dep2, dep3, dep4, dep5 };
			int j4 = 0;
			do {
				System.out.println("Email : " + depArray4[j4].id);
				System.out.println("FullName : " + depArray4[j4].name);
				j4++;
			} while (j4 < depArray4.length);
			
			
			System.out.println("Ex1 - Q17 - Q12 : Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10");
			Department[] depArray5 = { dep1, dep2, dep3, dep4, dep5 };
			int j5 = 0;
			do {
				System.out.println("Email : " + depArray5[j5].id);
				System.out.println("FullName : " + depArray5[j5].name);
				j5++;
			} while ( j5 < 2);
			
			System.out.println("Ex1 - Q17 - Q13 : In ra thông tin tất cả các account ngoại trừ account thứ 2");
			Account[] accArray6 = { ac1, ac2, ac3, ac4, ac5, ac6 };
			int i6 = 0;
			do {if (i6 != 1) {							
				System.out.println("ID: " + accArray6[i6].id);
				System.out.println("Email : " + accArray6[i6].email);
				System.out.println("FullName : " + accArray6[i6].fullName);
				System.out.println("PhòngBan : " + accArray6[i6].dep.name);
				}i6++;
			} while (i6 < accArray6.length);
			
			System.out.println("Ex1 - Q17 - Q14 : In ra thông tin tất cả các account có id < 4");
			Account[] accArray7 = { ac1, ac2, ac3, ac4, ac5, ac6 };
			int i7 = 0;
			do {
				if (accArray7[i7].id < 4) {
					System.out.println("ID: " + accArray7[i7].id);
					System.out.println("Email : " + accArray7[i7].email);
					System.out.println("FullName : " + accArray7[i7].fullName);
					System.out.println("PhòngBan : " + accArray7[i7].dep.name);
				}i7++;
			} while (i7 < accArray6.length);
			
			System.out.println("Ex1 - Q17 - Q15 : In ra các số chẵn nhỏ hơn hoặc bằng 20");
			int a2 = 0;
			do {
				if (a2%2 == 0) {
					System.out.println(a2 + "");
				}a2++;
			} while (a2 <= 20);
			
//		Ex4 - Question 1
			System.out.println("Ex4-Q1 : In ngẫu nhiên ra 1 số nguyên");
			Random random1 = new Random();
			int m = random1.nextInt();
			System.out.println("Số Ngẫu Nhiên : " + m);

//		Ex4 - Question 2
			System.out.println("Ex4-Q2 : In ngẫu nhiên ra 1 số thực");
			Random random3 = new Random();
			int o = random3.nextInt();
			System.out.println("Số Ngẫu Nhiên : " + o);

//		Ex4 - Question 3
			System.out.println(
					"Ex4-Q3 : Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn");
			Account[] accountArray = { ac1, ac2, ac3, ac4, ac5, ac6 };
			Random random = new Random();
			int a1 = random.nextInt(accountArray.length);
			System.out.println("Tên ngấu nhiên của 1 nhân viên : " + accountArray[a1].fullName);

//		Ex5 : Question 5
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

		}
	}

