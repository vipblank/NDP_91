package com.VTI.backend;

import java.time.LocalDate;
import java.util.Date;

import com.VTI.entity.Account;
import com.VTI.entity.Department;
import com.VTI.entity.Group;
import com.VTI.entity.Position;

public class Exercise2 {
	public void question1() {
		System.out.println("Ex2 - Question1");
		
		Account[] accAarray12 = new Account[5];
		for (int i = 0; i < accAarray12.length; i++) 
		{			
			accAarray12[i] = new Account();
			accAarray12[i].email = "Email" + i;
			accAarray12[i].userName = "Username" + i;
			accAarray12[i].fullName = "Fullname" + i;
			accAarray12[i].createDate = LocalDate.now() ;
		}
		for (int i = 0; i < accAarray12.length; i++) {
			System.out.println("\nEmail: " + accAarray12[i].email + "\nUsername: " + accAarray12[i].userName + "\nFullname: " + accAarray12[i].fullName + LocalDate.now());
		}
	}

}

		

		




