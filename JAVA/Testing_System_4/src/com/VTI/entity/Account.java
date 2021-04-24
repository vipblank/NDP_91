package com.VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {
	public int id;
	public String email;
	public String userName;
	public String firstName;
	public String lastName;
	public Department dep ;
	public Position pos;
	public LocalDate createDate;
	public Group[] groups;


	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + firstName
				 + lastName + ", dep=" + dep + ", pos=" + pos + ", createDate=" + createDate + "]";
	}
	public Account(int id, String email, String userName, String firstName, String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Account(int id, String email, String userName, String firstName, String lastName, Position pos
			) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pos = pos;
		this.createDate = LocalDate.now();
	}
	public Account(int id, String email, String userName, String firstName, String lastName, Department dep,
			Position pos, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dep = dep;
		this.pos = pos;
		this.createDate = createDate;
	}
	public Account(String userName) {
		super();
		this.userName = userName;
	}
	
}

