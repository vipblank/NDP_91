package com.VTI.backend;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.VTI.entity.Account;
import com.VTI.entity.Department;
import com.VTI.entity.Group;
import com.VTI.entity.Position;
import com.VTI.entity.Position.PositionName;

public class Exercise_1 {
	

	public void question1() {
		Department dep1 = new Department(1, "Sale");
		
		System.out.println(dep1.toString());
		
		Department dep2 = new Department("Marketing");
		
		System.out.println(dep2.toString());

	}
	public void question2() {
		Account acc1 = new Account(1, "phuongtccs@gmail.com", "phuong91", "nguyen", "ducphuong");
		System.out.println(acc1.toString());
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;
		Account acc2 = new Account(2, "hoptccs@gmail.com", "hop83", "nguyen", "bichhop", pos1);
		System.out.println(acc2.toString());
		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.TEST;	
		Department dep1 = new Department(3, "muahang");
		Account account3 = new Account(3, "minhtccs@gmail.com", "minh90", "le", "binhminh", dep1, pos2, LocalDate.now());
		
	}
	public void question3() {
		Account acc4 = new Account(4, "lehaiyen85@gmail.com", "yen85", "le", "haiyen");
		Account acc5 = new Account(5, "phamhoangnam91@gmail.com", "nam91", "pham", "hoangnam");
		Account[] accArray = {acc4, acc5};
		Group gr1 = new Group("anchoi", acc4, LocalDate.now(), accArray);
		System.out.println(gr1.toString());
		
		Account acc6 = new Account("Huy92");
		Account acc7 = new Account("Hung93");
		Account[] stringArray = {acc6, acc7};
		Group gr2 = new Group("annhau", acc6, LocalDate.now(), stringArray);
		System.out.println(gr2.toString());
	}
}
