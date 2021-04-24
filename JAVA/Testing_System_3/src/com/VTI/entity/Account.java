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
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName + ", dep="
				+ dep + ", pos=" + pos + ", createDate=" + createDate + ", groups=" + Arrays.toString(groups) + "]";
	}


}



