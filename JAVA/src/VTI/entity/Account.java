package com.VTI.entity;

import java.time.LocalDate;

public class Account {
	public int id;
	public String email;
	public String username;
	public String fullname;
	public Department dep ;
	public Position pos;
	public LocalDate CreateDate;
	public Group[] group;
}
