package com.VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public LocalDate CreateDate;
	public Account[] accounts;
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", CreateDate=" + CreateDate
				+ ", accounts=" + Arrays.toString(accounts) + "]";
	}
	public Group(String name, Account creator, LocalDate createDate, Account[] accounts) {
		super();
		this.name = name;
		this.creator = creator;
		CreateDate = createDate;
		this.accounts = accounts;
	}

}
	

