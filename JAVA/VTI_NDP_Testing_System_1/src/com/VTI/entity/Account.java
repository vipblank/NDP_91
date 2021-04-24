package com.VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Department dep ;
	public Position pos;
	public LocalDate createDate;
	public Group[] groups;	
	
	public Account() {
		super();
	}

	public Account(int id, String email, String userName, String fullName, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName + ", dep="
				+ dep + ", pos=" + pos + ", createDate=" + createDate + ", groups=" + Arrays.toString(groups) + "]";
	}

}

